package Monopoly.RunGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Icon;
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
        ImageIcon[] dice = new ImageIcon[10];
        Image[] icon = new Image[10];
        Image[] resizedicon = new Image[10];
        Icon[] dIcon = new Icon[10];
        
        dice[1] = new ImageIcon("Monopoly/res/dice1.png");    
        dice[2] = new ImageIcon("Monopoly/res/dice2.png");
        dice[3] = new ImageIcon("Monopoly/res/dice3.png");
        dice[4] = new ImageIcon("Monopoly/res/dice4.png");
        dice[5] = new ImageIcon("Monopoly/res/dice5.png");
        dice[6] = new ImageIcon("Monopoly/res/dice6.png");

        for (int i=1;i<=6;i++) {
            icon[i] = dice[i].getImage();
            resizedicon[i] = icon[i].getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
            dIcon[i] = new ImageIcon(resizedicon[i]);
        }
        //Image image = new ImageIcon("Monopoly/res/rollingDice.gif").getImage().getScaledInstance(178, 125, java.awt.Image.SCALE_SMOOTH);
        //ImageIcon rollingDice = new ImageIcon(image);
        //ImageIcon rollingDice = new ImageIcon("Monopoly/res/rollingDice.gif");

        frame.getContentPane().removeAll();
        
        JPanel gameDisplay = new GameDisplay(fwidth, fheight);
        gameDisplay.setBounds(0, 0, fwidth, fheight);
        
        Notification notification = new Notification();
        notification.setBounds(800, 0, 600, 420);

        DiceLabel label = new DiceLabel();

        Dice diceButton = new Dice();
        diceButton.addActionListener(new ActionListener() {
            Random random = new Random();

            public void actionPerformed(ActionEvent e) {
                int result1 = random.nextInt(6) +1;
                int result2 = random.nextInt(6) +1;
                Dice.setResult(result1, result2);
                label.setIcon(new TwoIcon(dIcon[result1], dIcon[result2]));
            }
        });
        

        JPanel dicePanel = new JPanel();
        dicePanel.setBounds(fwidth+80, fheight/2, 400, fheight/2);
        dicePanel.setLayout(new BorderLayout(0, -150));
        dicePanel.add(diceButton, BorderLayout.SOUTH);
        dicePanel.add(label, BorderLayout.CENTER);



        frame.revalidate();
        frame.repaint();
        frame.setSize(fwidth+600, fheight+40);
        frame.getContentPane().add(notification);
        frame.getContentPane().add(dicePanel);
        frame.getContentPane().add(gameDisplay);


        //startNewGame();
    }
}
