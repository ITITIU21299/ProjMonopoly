package Monopoly;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
                JFrame difficultyFrame = new JFrame("Choose Difficulty");
                JPanel difficultyPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                JButton easyButton = new JButton("Easy");
                JButton mediumButton = new JButton("Medium");
                JButton hardButton = new JButton("Hard");
                difficultyPanel.add(easyButton);
                difficultyPanel.add(mediumButton);
                difficultyPanel.add(hardButton);
                difficultyFrame.getContentPane().add(difficultyPanel);
                difficultyFrame.pack();
                
                difficultyFrame.setLocationRelativeTo(button.getParent());
                difficultyFrame.setVisible(true);
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
