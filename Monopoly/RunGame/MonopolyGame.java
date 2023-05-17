package Monopoly.RunGame;

import Monopoly.RunGame.GameRule.Player;
import Monopoly.RunGame.GameRule.Board;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;


public class MonopolyGame{
        private boolean gameEnd=false;
        private JFrame frame;
        private int bankrupted;
        private final int fwidth=800, fheight=800;
        private boolean isPlayerTurn;
        DiceLabel label = new DiceLabel();

        Random random = new Random();

        Dice diceButton = new Dice();
        ImageIcon[] dice = new ImageIcon[10];
        Image[] icon = new Image[10];
        Image[] resizedicon = new Image[10];
        Icon[] dIcon = new Icon[10];
        
        int CurrentPlayerIndex = 0;
        
        Notification notification = new Notification();
        
        int count=0;

        Player[] players = {new Player("Player 1",1000,0,"Monopoly/res/token_car.png"),
        new Player("Player 2",1000,0,"Monopoly/res/token_dog.png"),
        new Player("Player 3",1000,0,"Monopoly/res/token_hat.png"),
        new Player("Player 4",1000,0,"Monopoly/res/token_ship.png")};

        GameDisplay gameDisplay = new GameDisplay(fwidth, fheight);

        Board board = new Board();

        //private List<MonopolySquare> squares;
        
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
    private void startNewGame() {
        frame.dispose();
        MonopolyGame game = new MonopolyGame();
        game.setup();
    }
    private void startGame(){
        
        //Image image = new ImageIcon("Monopoly/res/rollingDice.gif").getImage().getScaledInstance(178, 125, java.awt.Image.SCALE_SMOOTH);
        //ImageIcon rollingDice = new ImageIcon(image);
        //ImageIcon rollingDice = new ImageIcon("Monopoly/res/rollingDice.gif");

        frame.getContentPane().removeAll();
        
        
        gameDisplay.setBounds(0, 0, fwidth, fheight);
        gameDisplay.setTokenPosition(0,0);
        gameDisplay.setTokenPosition(1,0);
        gameDisplay.setTokenPosition(2,0);
        gameDisplay.setTokenPosition(3,0);
        
        notification.setBounds(800, 0, 600, 420);

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
        gameEnd=false;
            diceButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (!gameEnd){
                        Player currentplayer = players[CurrentPlayerIndex];
                        PlayTurn(currentplayer);
                    }
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
    public void PlayTurn(Player CPlayer){
        int result1 =random.nextInt(6) +1;
        int result2 =random.nextInt(6) +1;
        Dice.setResult(result1, result2);
        label.setIcon(new TwoIcon(dIcon[result1], dIcon[result2]));
        int result=result1+result2;
        

        if (count==12){
            notification.RemoveNotification();
            count=0;
        }

        notification.addNotification("                               "+CPlayer.getName()+" move "+ result + " steps                                      ");
        count++;
        //notification.RemoveNotification();
        //CPlayer.setPosition(CPlayer.getPosition()+result);
        
        //int currentPosition = CPlayer.getPosition();
        board.movePlayer(CPlayer, result);
        CPlayer.setRollDice(result);
        //System.out.println(CPlayer.getPosition());
        notification.addNotification(board.Notify());
        gameDisplay.setTokenPosition(CurrentPlayerIndex, CPlayer.getPosition());
        


        if (bankrupted==3){
            gameEnd=true;
        }

        CurrentPlayerIndex++;
        if (CurrentPlayerIndex==4)
            CurrentPlayerIndex=0;
    }
    
}
