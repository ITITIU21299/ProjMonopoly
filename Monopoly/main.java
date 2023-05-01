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

public class main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Monopoly");
        JPanel StartButton = new JPanel();
        StartButton.setLayout(new BoxLayout(StartButton, BoxLayout.Y_AXIS));

        JButton button = new JButton("Start Game");
        button.setAlignmentX(JButton.CENTER_ALIGNMENT);
        button.setPreferredSize(new Dimension(100, 50)); // Set button size
        button.addActionListener(new ActionListener() {
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

        StartButton.add(button);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(new MenuDisplay(), BorderLayout.CENTER);
        frame.getContentPane().add(StartButton, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setVisible(true);
    }
}
