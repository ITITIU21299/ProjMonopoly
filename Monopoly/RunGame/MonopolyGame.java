package Monopoly.RunGame;

import Monopoly.RunGame.GameRule.Player;
import Monopoly.RunGame.GameRule.Board;
import Monopoly.RunGame.GameRule.Card;
import Monopoly.RunGame.GameRule.JailSquare;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
        ImageIcon[] tokenImage = new ImageIcon[5];
        Color[] ptextcolor = new Color[5];

        int CurrentPlayerIndex = 0;
        
        Notification notification = new Notification();
        
        int count=0;

        
        Player[] players = {new Player("Player 1",1000,0,"Monopoly/res/token_car.png", new Color(255, 0, 0), 0),
        new Player("Player 2",1000,0,"Monopoly/res/token_dog.png", new Color(30, 144, 255), 1),
        new Player("Player 3",1000,0,"Monopoly/res/token_hat.png", new Color(255, 0, 255), 2),
        new Player("Player 4",1000,0,"Monopoly/res/token_ship.png", new Color(0, 0, 0), 3)};

        GameDisplay gameDisplay = new GameDisplay(fwidth, fheight);

        Board board = new Board();

        PlayerMoney[] pMoney = new PlayerMoney[4];

        

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
        gameDisplay.setInitialTokenPosition(players[0]);
        gameDisplay.setInitialTokenPosition(players[1]);
        gameDisplay.setInitialTokenPosition(players[2]);
        gameDisplay.setInitialTokenPosition(players[3]);
        
        notification.setBounds(800, 0, 600, 360);

        dice[1] = new ImageIcon("Monopoly/res/dice1.png");    
        dice[2] = new ImageIcon("Monopoly/res/dice2.png");
        dice[3] = new ImageIcon("Monopoly/res/dice3.png");
        dice[4] = new ImageIcon("Monopoly/res/dice4.png");
        dice[5] = new ImageIcon("Monopoly/res/dice5.png");
        dice[6] = new ImageIcon("Monopoly/res/dice6.png");

        tokenImage[0]= new ImageIcon("Monopoly/res/token_car.png");
        tokenImage[1]= new ImageIcon("Monopoly/res/token_dog.png");
        tokenImage[2]= new ImageIcon("Monopoly/res/token_hat.png");
        tokenImage[3]= new ImageIcon("Monopoly/res/token_ship.png");

        ptextcolor[1] = new Color(255, 0, 0);
        ptextcolor[1] = new Color(255, 0, 0);
        ptextcolor[1] = new Color(255, 0, 0);
        ptextcolor[1] = new Color(255, 0, 0);

        for (int i = 0; i < 4; i++) 
        {
            pMoney[i] = new PlayerMoney(players[i], tokenImage[i]);
        }

        pMoney[0].setBounds(800, 350, 600, 33);
        pMoney[1].setBounds(800, 390, 600, 33);
        pMoney[2].setBounds(800, 430, 600, 33);
        pMoney[3].setBounds(800, 470, 600, 33);

        for (int i=1;i<=6;i++) {
            icon[i] = dice[i].getImage();
            resizedicon[i] = icon[i].getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
            dIcon[i] = new ImageIcon(resizedicon[i]);
        }       

        gameEnd=false;
            diceButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (!gameEnd){
                        if (CurrentPlayerIndex % 4 ==0){
                            notification.RemoveNotification();
                            CurrentPlayerIndex=0;
                        }

                        Player currentplayer = players[CurrentPlayerIndex];
                        int result1 = random.nextInt(6) + 1;
                        int result2 = random.nextInt(6) + 1;

                        currentplayer.setRollDice(result1, result2);
                        label.setIcon(new TwoIcon(dIcon[result1], dIcon[result2]));

                        if (currentplayer.isInJail()) {
                                board.movePlayer(currentplayer, 0);
                                notification.addNotification(currentplayer.getColor(), board.Notify());
                                //System.out.println(currentplayer.getName());

                                if (currentplayer.isInJail() ) {
                                    if (currentplayer.hasGetOutOfJailCard() == true) {
                                        //notification.addNotification(currentplayer.getColor(), currentplayer.getName() + " has been in jail for " + currentplayer.getJailRollCount() + " turn(s)");
                                    }
                                    result1=0;
                                    result2=0;
                                }   
                        }
                        
                        PlayTurn(currentplayer,result1,result2);

                        CurrentPlayerIndex = (CurrentPlayerIndex + 1) % 4;
                    }
                }
            });

        JPanel dicePanel = new JPanel();
        dicePanel.setBounds(fwidth+80, 550, 400, 250);
        dicePanel.setLayout(new BorderLayout(0, -150));
        dicePanel.add(diceButton, BorderLayout.SOUTH);
        dicePanel.add(label, BorderLayout.CENTER);

        frame.revalidate();
        frame.repaint();
        frame.setSize(fwidth+600, fheight+40);
        frame.getContentPane().add(pMoney[0]);
        frame.getContentPane().add(pMoney[1]);
        frame.getContentPane().add(pMoney[2]);
        frame.getContentPane().add(pMoney[3]);
        frame.getContentPane().add(notification);
        frame.getContentPane().add(dicePanel);
        frame.getContentPane().add(gameDisplay);

        //startNewGame();
    }
    public void PlayTurn(Player player, int result1, int result2){
        int result = result1 + result2;
        //player.addChanceCard(new Card("Get Out of Jail Free.", Card.CardType.CHANCE));
        //players[1].addGetOutOfJailCard(new Card("Get Out of Jail Free.", Card.CardType.CHANCE));
        //players[2].addGetOutOfJailCard(new Card("Get Out of Jail Free.", Card.CardType.CHANCE));

        for (int i=0;i<=3;i++) {
            pMoney[i].updateMoney();
        }

        if (result!=0) {
            board.movePlayer(player, result);
            notification.addNotification(player.getColor(),"                               "+player.getName()+" move "+ result + " steps                                      ");
            notification.addNotification(player.getColor(),board.Notify());
        }
        gameDisplay.setTokenPosition(player);

        if (bankrupted==3){
            gameEnd=true;
        }
    }
}
