

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;

public class GUICharCreate extends CharacterCreation{

    private JTextField name;
    private JFrame frame2;
    JRadioButton vagabondButton;
    JRadioButton samuraiButton;
    JRadioButton warriorButton;
    JRadioButton heroButton;
    JRadioButton astrologerButton;
    JRadioButton prophetButton;
    ImageIcon vagabondIcon;
    ImageIcon samuraiIcon;
    ImageIcon warriorIcon;
    ImageIcon heroIcon;
    ImageIcon astrologerIcon;
    ImageIcon prophetIcon;

    public void run(){
        frame2 = new JFrame("ELDEN ROGUE");
        frame2.setSize(1400, 800);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setBackground(new Color(0, 0, 0));

        Container contentPane = frame2.getContentPane();
        contentPane.setLayout(null);

        JLabel TitleCard = new JLabel("ELDEN ROGUE");
        TitleCard.setBounds(625, -70 , 300, 200);
        TitleCard.setFont(new Font("Calibri", 1, 15));
        TitleCard.setForeground(new Color(254, 181, 0));
        contentPane.add(TitleCard);
        contentPane.setBackground(new Color(0, 0, 0));
        contentPane.setForeground(new Color(255, 203, 116));

        JLabel label = new JLabel("Character Creation");
        label.setBounds(10, -20 , 300, 200);
        label.setFont(new Font("Calibri", 1, 25));
        label.setForeground(new Color(254, 181, 0));
        contentPane.add(label);
        contentPane.setBackground(new Color(0, 0, 0));
        contentPane.setForeground(new Color(255, 203, 116));

        name = new JTextField();
        name.setBounds(10, 100, 200, 30);
        contentPane.add(name);
        name.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                nameFocusGained(e);
            }

            @Override
            public void focusLost(FocusEvent e) {
                nameTextFieldFocusLost(e);
            }
        });

        JPanel grayPanel = new JPanel();
        grayPanel.setForeground(new Color(231, 225, 218));
        grayPanel.setBounds(10, 140, 1360, 610);
        grayPanel.setLayout(null);
        contentPane.add(grayPanel);

        JLabel selectJob = new JLabel("Select Jobclass");
        selectJob.setFont(new Font("Calibri", 1, 20));
        selectJob.setBounds(10, -60, 300, 200);
        grayPanel.add(selectJob);


        ButtonGroup jobclasses = new ButtonGroup();
        jobclasses.add(vagabondButton);
        jobclasses.add(samuraiButton);
        jobclasses.add(warriorButton);
        jobclasses.add(heroButton);
        jobclasses.add(astrologerButton);
        jobclasses.add(prophetButton);

        vagabondIcon = new ImageIcon("Jobclass/Vagabond.png");
        vagabondButton = new JRadioButton();
        vagabondButton.setBounds(50, 50 , 200,400);
        vagabondButton.setIcon(vagabondIcon);
        grayPanel.add(vagabondButton);
        vagabondButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                updateStatsActionPerformed(e);
            }
        });

        samuraiIcon = new ImageIcon("Jobclass/Samurai.png");
        samuraiButton = new JRadioButton();
        samuraiButton.setBounds(250, 50 , 200,400);
        samuraiButton.setIcon(samuraiIcon);
        grayPanel.add(samuraiButton);
        samuraiButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                updateStatsActionPerformed(e);
            }
        });


        warriorIcon = new ImageIcon("Jobclass/Warrior.png");
        warriorButton = new JRadioButton();
        warriorButton.setBounds(450, 50 , 200,400);
        warriorButton.setIcon(warriorIcon);
        grayPanel.add(warriorButton);
        warriorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                updateStatsActionPerformed(e);
            }
        });

        heroIcon = new ImageIcon("Jobclass/Hero.png");
        heroButton = new JRadioButton();
        heroButton.setBounds(650, 50 , 200,400);
        heroButton.setIcon(heroIcon);
        grayPanel.add(heroButton);
        heroButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                updateStatsActionPerformed(e);
            }
        });

        astrologerIcon = new ImageIcon("Jobclass/astrologer.png");
        astrologerButton = new JRadioButton();
        astrologerButton.setBounds(850, 50 , 200,400);
        astrologerButton.setIcon(astrologerIcon);
        grayPanel.add(astrologerButton);
        astrologerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                updateStatsActionPerformed(e);
            }
        });

        prophetIcon = new ImageIcon("Jobclass/prophet.png");
        prophetButton = new JRadioButton();
        prophetButton.setBounds(1050, 50 , 200,400);
        prophetButton.setIcon(prophetIcon);
        grayPanel.add(prophetButton);
        prophetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                updateStatsActionPerformed(e);
            }
        });


        JButton confirm = new JButton("Confirm");
        confirm.setBounds(750, 570, 80, 30);
        grayPanel.add(confirm);
        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                setPlayerName();
                confirmActionPerformed(e);
                frame2.dispose();
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(550, 570, 80, 30);
        grayPanel.add(back);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                backActionPerformed(e);
                frame2.dispose();
            }
        });
        frame2.setVisible(true);
    }

    private void backActionPerformed(ActionEvent e) {
        GUITitleScreen display = new GUITitleScreen();
        display.run();
    }

    private void confirmActionPerformed(ActionEvent e){
        GUIGameLobby gameLobby = new GUIGameLobby();
        gameLobby.run();

    }

    private void nameFocusGained(FocusEvent e) {
        if(name.getText().equals("Name")) {
            name.setText("");
            name.setForeground(new Color(153, 153, 153));
        }
    }

    private void nameTextFieldFocusLost(FocusEvent e) {
        if(name.getText().equals("")){
            name.setText("Name");
            name.setForeground(new Color(153, 153, 153));
        }
    }

    private void setPlayerName() {
        setName(name.getText()); 
    }

    private void updateStatsActionPerformed (ActionEvent e) {

        if(e.getSource()==vagabondButton) {
            updateCharacterStats(1);
        }
        else if(e.getSource()==samuraiButton) {
            updateCharacterStats(2);
        }
        else if(e.getSource()==samuraiButton) {
            updateCharacterStats(3);
        }
        else if(e.getSource()==samuraiButton) {
            updateCharacterStats(4);
        }
        else if(e.getSource()==samuraiButton) {
            updateCharacterStats(5);
        }
        else if(e.getSource()==samuraiButton) {
            updateCharacterStats(6);
        }
        else if(e.getSource()==samuraiButton) {
            updateCharacterStats(7);
        }
    }
}
