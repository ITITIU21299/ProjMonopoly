package Monopoly;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Dimension;
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
        JPanel ButtonPanel = new JPanel();
        ButtonPanel.setSize(1600, 100);
        ButtonPanel.setLayout(new BorderLayout());

        ImageIcon icon = new ImageIcon("res/startbutton.png");

        Image startimg = icon.getImage();
        Image resizedImage = startimg.getScaledInstance(1600, 100, java.awt.Image.SCALE_SMOOTH);
        ImageIcon start_butIcon = new ImageIcon(resizedImage);
        
        StartButton.setLayout(new BoxLayout(StartButton, BoxLayout.Y_AXIS));

        StartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                JPanel playerNumberPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                JLabel label = new JLabel("Choose number of players:");
                JButton twoPButton = new JButton("2 players");
                JButton threePButton = new JButton("3 players");
                JButton fourPButton = new JButton("4 players");
                playerNumberPanel.add(label);
                playerNumberPanel.add(twoPButton);
                playerNumberPanel.add(threePButton);
                playerNumberPanel.add(fourPButton);
                frame.getContentPane().setLayout(new BorderLayout());
                frame.getContentPane().add(new MenuDisplay(), BorderLayout.CENTER);
                frame.getContentPane().add(playerNumberPanel, BorderLayout.SOUTH);
        
                // Refresh frame to show the new components
                frame.revalidate();
                frame.repaint();
            }
        });

        StartButton.setIcon(start_butIcon);
        ButtonPanel.add(StartButton);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(new MenuDisplay(), BorderLayout.CENTER);
        frame.getContentPane().add(ButtonPanel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 900);
        frame.setVisible(true);
    }
}
