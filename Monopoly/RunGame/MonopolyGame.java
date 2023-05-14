package Monopoly.RunGame;

import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;


public class MonopolyGame {
        private boolean gameEnd=false;
        private JFrame frame;
        private int bankrupted;
        private final int fwidth=800, fheight=800;
        
    public void setup(){
        frame = new JFrame("Monopoly");
        JButton StartButton = new JButton();
        JPanel menuDisplay = new MenuDisplay(fwidth,fheight);
        menuDisplay.setBounds(0, 0, fwidth, fheight);

        Image image = new ImageIcon("Monopoly/res/startbutton.png").getImage().getScaledInstance(300, 56, java.awt.Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image);
        StartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        StartButton.setIcon(icon);
        frame.setLayout(null);
        frame.getContentPane().setLayout(null);
        StartButton.setBounds(320, 800, 150, 60);
        StartButton.setVisible(true);
        frame.getContentPane().add(menuDisplay);
        frame.getContentPane().add(StartButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(fwidth, fheight+100);
        frame.setVisible(true);
    }
    public boolean getGameEnd(){
        return gameEnd;
    }
    public JFrame getFrame() {
        return frame;
    }
    private void startNewGame() {
        frame.dispose();
        MonopolyGame game = new MonopolyGame();
        game.setup();
    }
    private void startGame(){
        frame.getContentPane().removeAll();
        JPanel gameDisplay = new GameDisplay(fwidth, fheight);
        gameDisplay.setBounds(0, 0, fwidth, fheight);
        Notification notification = new Notification();
        notification.setBounds(800, 0, 600, 420);
        
        
        frame.revalidate();
        frame.repaint();
        frame.setSize(fwidth+600, fheight+40);
        frame.getContentPane().add(notification);
        frame.getContentPane().add(gameDisplay);


        //startNewGame();
    }
}
