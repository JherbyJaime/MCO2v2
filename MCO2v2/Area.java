

import java.util.Scanner;

public class Area {

    private char[][] firstRoom;
    private char[][] secondRoom;
    private char[][] thirdRoom;
    private char[][] areaMap;
    private int[] playerPosition;
    private boolean inMenu;

    public Area() {
        firstRoom = createFirstRoom();
        secondRoom = createSecondRoom();
        thirdRoom = createThirdRoom();
        areaMap = firstRoom;
        playerPosition = new int[]{0, 1};
        inMenu = true;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (inMenu) {
                displayMenu();
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        areaMap = firstRoom; // Spawn in the first room
                        playerPosition[0] = 0; // Reset player position
                        playerPosition[1] = 1;
                        inMenu = false;
                        break;
                    case 2:
                        System.out.println("\nArea 2 is not yet available.\n");
                        break;
                    case 3:System.out.println("\n\nThe Elden Throne is LOCKED.\n\n");
                        break;
                    case 4:System.out.println("Back to Game Lobby...");
                        return;
                        
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } else {
                // Display area map with player
                displayAreaMap();

                // Player movement
                System.out.print("\nEnter your action (WASD to move, E to interact): ");
                char action = Character.toUpperCase(scanner.next().charAt(0));

                movePlayer(action);

                // If the player is standing on a door tile and presses 'E', transition to the connected area
                if (areaMap[playerPosition[1]][playerPosition[0]] == 'D' && action == 'E') {
                    handleDoorTransition();
                }

                // If the player is standing on the "?" tile and presses 'E', interact with it
                if (areaMap[playerPosition[1]][playerPosition[0]] == '?' && action == 'E') {
                    interactWithTile();
                }

                // If the player is standing on the "?" tile, display prompt to interact
                if (areaMap[playerPosition[1]][playerPosition[0]] == '?') {
                    System.out.println("Press E to interact (enemy or treasure).");
                }

                // If the player is standing on a door tile, display prompt to enter
                if (areaMap[playerPosition[1]][playerPosition[0]] == 'D') {
                    System.out.println("Press E to enter this door.");
                }

                // If the player is standing on the "F" tile, prompt to return to the menu
                if (areaMap[playerPosition[1]][playerPosition[0]] == 'F') {
                    System.out.println("Press E to return to the Fast Travel Menu.");
                }

                // If the player presses 'E' on the "F" tile, return to the menu
                if (areaMap[playerPosition[1]][playerPosition[0]] == 'F' && action == 'E') {
                    inMenu = true;
                }
            }
        }
    }

    private void handleDoorTransition() {
        if (areaMap == firstRoom) {
            areaMap = secondRoom; // Transition to the second area
            playerPosition[0] = 0; // Start at the left door of the second area
            playerPosition[1] = secondRoom.length / 2;
        } else if (areaMap == secondRoom) {
            if (playerPosition[0] == secondRoom[0].length - 1) { // If player is at the right door of the second area
                areaMap = thirdRoom; // Transition to the third area
                playerPosition[0] = 0; // Start at the left door of the third area
                playerPosition[1] = thirdRoom.length / 2;
            } else { // If player is at the left door of the second area
                areaMap = firstRoom; // Transition back to the first area
                playerPosition[0] = firstRoom[0].length - 1; // Start at the right door of the first area
                playerPosition[1] = firstRoom.length / 2;
            }
        } else {
            areaMap = secondRoom; // Transition back to the second area
            playerPosition[0] = secondRoom[0].length - 1; // Start at the right door of the second area
            playerPosition[1] = secondRoom.length / 2;
        }

        // Check if the player is on the 'F' tile after transition
        if (areaMap[playerPosition[1]][playerPosition[0]] == 'F') {
            inMenu = true; // Return to menu
        }
    }

    private void interactWithTile() {
        // Print message for interacting with the tile
        System.out.println("Press E to interact with the tile.");
        // Other actions to interact with the tile...
        // For example, spawning an enemy
        spawnEnemy();
    }

    // Method to spawn an enemy
    private void spawnEnemy() {
        // Print message
        System.out.println("An enemy has appeared");
        // Other actions to spawn enemy...
    }

    private void displayMenu() {
        System.out.println("Fast Travel Menu");
        System.out.println("1. Stromveil Castle");
        System.out.println("2. Raya Lucaria Academy");
        System.out.println("3. The Elden Throne[LOCKED]");
        System.out.println("4. Quit");
    }

    private void displayAreaMap() {
        // Clear the console before displaying the map
        System.out.print("\033[H\033[2J");
        System.out.flush();

        for (int i = 0; i < areaMap.length; i++) {
            for (int j = 0; j < areaMap[i].length; j++) {
                if (i == playerPosition[1] && j == playerPosition[0]) {
                    System.out.print("P ");
                } else {
                    System.out.print(areaMap[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private void movePlayer(char action) {
        int newX = playerPosition[0];
        int newY = playerPosition[1];
        switch (action) {
            case 'W':
                newY--;
                break;
            case 'S':
                newY++;
                break;
            case 'A':
                newX--;
                break;
            case 'D':
                newX++;
                break;
            default:
                return;
        }
        if (isValidMove(newX, newY)) {
            playerPosition[0] = newX;
            playerPosition[1] = newY;
        }
    }

    private boolean isValidMove(int x, int y) {
        return x >= 0 && x < areaMap[0].length && y >= 0 && y < areaMap.length;
    }

    private char[][] createFirstRoom() {
        char[][] firstRoom = new char[3][7]; // Rows: 1-3, Columns: A-G

        // Fill area map with empty tiles
        for (int i = 0; i < firstRoom.length; i++) {
            for (int j = 0; j < firstRoom[i].length; j++) {
                firstRoom[i][j] = '-';
            }
        }

        // Set tile "D" on the middle most right position
        firstRoom[1][firstRoom[0].length - 1] = 'D';
        // Set spawn tile "F"
        firstRoom[1][0] = 'F';
        // Place "?" tiles
        firstRoom[0][firstRoom[0].length - 2] = '?'; // Top left of the door
        firstRoom[firstRoom.length - 1][firstRoom[0].length - 2] = '?'; // Bottom left of the door

        return firstRoom;
    }

    private char[][] createSecondRoom() {
        char[][] secondRoom = new char[7][7]; // 7x7 room

        // Fill area map with empty tiles
        for (int i = 0; i < secondRoom.length; i++) {
            for (int j = 0; j < secondRoom[i].length; j++) {
                if (j == secondRoom[i].length - 1 && i == secondRoom.length / 2) { // Middle most right position
                    secondRoom[i][j] = 'D'; // Set right door tile
                } else if (j == 0 && i == secondRoom.length / 2) { // Middle most left position
                    secondRoom[i][j] = 'D'; // Set left door tile
                } else {
                    secondRoom[i][j] = '-';
                }
            }
        }

        // Place "?" tiles with blanks in the specified coordinates
        secondRoom[4][1] = '?';
        secondRoom[0][3] = '?';
        secondRoom[2][1] = '?';
        secondRoom[2][3] = '?';
        secondRoom[3][3] = '?';
        secondRoom[4][3] = '?';
        secondRoom[6][3] = '?';
        secondRoom[3][5] = '?';

        return secondRoom;
    }

    private char[][] createThirdRoom() {
        char[][] thirdRoom = new char[5][7]; // 5x7 room

        // Fill area map with empty tiles
        for (int i = 0; i < thirdRoom.length; i++) {
            for (int j = 0; j < thirdRoom[i].length; j++) {
                if (j == 0 && i == thirdRoom.length / 2) { // Middle most left position
                    thirdRoom[i][j] = 'D'; // Set door tile
                } else if (j == thirdRoom[i].length - 1 && i == thirdRoom.length / 2) { // Middle most right position
                    thirdRoom[i][j] = 'F'; // Set F tile
                } else {
                    thirdRoom[i][j] = '-';
                }
            }
        }

        return thirdRoom;
    }
}