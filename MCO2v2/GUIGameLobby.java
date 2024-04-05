import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUIGameLobby {
    private JFrame frame3;
    private JButton fastTravel;
    private JButton levelUp;
    private JButton shop;
    private JButton inventory;


    public void run() {

        frame3 = new JFrame("ELDEN ROGUE");
        frame3.setSize(1400, 800);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = frame3.getContentPane();
        contentPane.setLayout(null);

        JLabel TitleCard = new JLabel("ELDEN ROGUE");
        TitleCard.setBounds(625, -70 , 300, 200);
        TitleCard.setFont(new Font("Calibri", 1, 15));
        TitleCard.setForeground(new Color(254, 181, 0));
        contentPane.add(TitleCard);
        contentPane.setBackground(new Color(0, 0, 0));
        contentPane.setForeground(new Color(255, 203, 116));

        JLabel label = new JLabel("Game Lobby");
        label.setBounds(10, -20 , 300, 200);
        label.setFont(new Font("Calibri", 1, 25));
        label.setForeground(new Color(254, 181, 0));
        contentPane.add(label);
        contentPane.setBackground(new Color(0, 0, 0));
        contentPane.setForeground(new Color(255, 203, 116));

        fastTravel = new JButton("Fast Travel");
        fastTravel.setBounds(425, 100, 500, 100);
        contentPane.add(fastTravel);
        fastTravel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                fastTravelActionPerformed(e);
                frame3.dispose();
            }
        });

        levelUp = new JButton("Level up");
        levelUp.setBounds(425, 250, 500, 100);
        contentPane.add(levelUp);

        shop = new JButton("Shop");
        shop.setBounds(425, 400, 500, 100);
        contentPane.add(shop);

        inventory = new JButton("Inventory");
        inventory.setBounds(425, 550, 500, 100);
        contentPane.add(inventory);

        frame3.setVisible(true);
    }

    private void fastTravelActionPerformed(ActionEvent e) {
        //TODO: input code here to call area gui
    }
  
}

