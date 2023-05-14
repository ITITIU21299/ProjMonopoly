package Monopoly;

<<<<<<< HEAD
import Monopoly.RunGame.MonopolyGame;

public class main {
    public static void main(String[] args) {
        MonopolyGame game = new MonopolyGame();
        game.setup();
=======
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Dimension;

import Monopoly.RunGame.Dice;
import Monopoly.RunGame.MenuDisplay;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.Image;

public class main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Monopoly");
        JButton StartButton = new JButton();
        // JPanel ButtonPanel = new JPanel();
        JLabel myLabel = new JLabel();
        // ButtonPanel.setSize(200, 100);
        // ButtonPanel.setLayout(new BorderLayout());
        JPanel menuD = new MenuDisplay();
        menuD.setBounds(0, 0, 1600, 800);

        Image image = new ImageIcon("Monopoly/res/startbutton.png")
                .getImage().getScaledInstance(300, 56, java.awt.Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image);
        // Image startimg = icon.getImage();
        // Image resizedImage = startimg.getScaledInstance(100, 50,
        // java.awt.Image.SCALE_SMOOTH);
        // ImageIcon start_butIcon = new ImageIcon(resizedImage);

        // myLabel.setBounds(700, 700, 200, 100);
        // StartButton.setLayout(new BoxLayout(StartButton, BoxLayout.Y_AXIS));

        // myLabel.add(StartButton);

        StartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                /*
                 * JPanel playerNumberPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                 * JLabel label = new JLabel("Choose number of players:");
                 * JButton twoPButton = new JButton("2 players");
                 * JButton threePButton = new JButton("3 players");
                 * JButton fourPButton = new JButton("4 players");
                 * playerNumberPanel.add(label);
                 * playerNumberPanel.add(twoPButton);
                 * playerNumberPanel.add(threePButton);
                 * playerNumberPanel.add(fourPButton);
                 * playerNumberPanel.setBounds(700, 700, 1600, 100);
                 * frame.getContentPane().setLayout(null);
                 * frame.getContentPane().add(menuD);
                 * frame.getContentPane().add(playerNumberPanel);
                 */
                // Refresh frame to show the new components
                frame.revalidate();
                frame.repaint();
            }
        });

        Dice dButton = new Dice();
        frame.add(dButton);
        StartButton.setIcon(icon);
        //ButtonPanel.add(StartButton);

        frame.setLayout(null);
        // frame.getContentPane().add(myLabel);
        frame.getContentPane().setLayout(null);
        // frame.getContentPane().add(new MenuDisplay(), BorderLayout.CENTER);
        // frame.getContentPane().add(ButtonPanel, BorderLayout.SOUTH);

        StartButton.setBounds(720, 800, 150, 60);
        StartButton.setVisible(true);
        frame.getContentPane().add(menuD);
        frame.getContentPane().add(StartButton);
        // frame.add(myLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 900);
        frame.setVisible(true);
>>>>>>> f6e66f6a12cb0c12adab58363853d07aeab386f0
    }
}
