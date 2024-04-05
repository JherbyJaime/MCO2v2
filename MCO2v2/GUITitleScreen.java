

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUITitleScreen {

    public void run() {
        JFrame frame = new JFrame("ELDEN ROGUE");
        frame.setSize(1400, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(null);

        JLabel TitleCard = new JLabel("ELDEN ROGUE");
        TitleCard.setBounds(550, 75 , 300, 200);
        TitleCard.setFont(new Font("Calibri", 1, 50));
        TitleCard.setForeground(new Color(254, 181, 0));
        contentPane.add(TitleCard);
        contentPane.setBackground(new Color(0, 0, 0));
        contentPane.setForeground(new Color(255, 203, 116));

        JButton start = new JButton("Start");
        start.setBounds(750, frame.getHeight()-400, 100, 50);
        contentPane.add(start);
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                startActionPerformed(e);
                frame.dispose();
            }
        });

        JButton exit = new JButton("Exit");
        exit.setBounds(550, frame.getHeight()-400, 100, 50);
        contentPane.add(exit);
        exit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    exitActionPerformed(e);
                }
            });
        
        frame.setVisible(true);

    }

    
    private void exitActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    private void startActionPerformed(ActionEvent e){
        
        GUICharCreate display = new GUICharCreate();
        display.run();
        
    }


}

   