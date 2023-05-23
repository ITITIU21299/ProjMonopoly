package Monopoly.RunGame;

import Monopoly.RunGame.GameRule.Player;
import Monopoly.RunGame.GameRule.Board;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

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
        
        notification.setBounds(800, 0, 600, 320);

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

        pMoney[0].setBounds(800, 320, 600, 35);
        pMoney[1].setBounds(800, 360, 600, 35);
        pMoney[2].setBounds(800, 400, 600, 35);
        pMoney[3].setBounds(800, 440, 600, 35);

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
                        if (currentplayer.hasGetOutOfJailCard()){
                            currentplayer.useGetOutOfJailCard();
                        }
                        PlayTurn(currentplayer);
                    }
               }
            });

        JPanel dicePanel = new JPanel();
        dicePanel.setBounds(fwidth+80, 500, 400, 300);
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
    public void PlayTurn(Player CPlayer){
        if (CPlayer.getBalance()<=0){
            CurrentPlayerIndex++;
            if (CurrentPlayerIndex==4)
            CurrentPlayerIndex=0;
            return;
        }
        CPlayer.setHasRollDouble(false);
        int result1 = random.nextInt(6) +1;
        int result2 = random.nextInt(6) + 1;
        Dice.setResult(result1, result2);
        label.setIcon(new TwoIcon(dIcon[result1], dIcon[result2]));

        if (result1==result2) {
            CPlayer.setHasRollDouble(true);
        }

        if (CPlayer.isInJail()&&!CPlayer.hasRolledDouble()){
            CurrentPlayerIndex++;
            if (CurrentPlayerIndex==4)
            CurrentPlayerIndex=0;
            return;
        }
        if (CPlayer.isInJail()&&CPlayer.hasRolledDouble()){
            CPlayer.releaseFromJail();
        }

        
        int result=result1+result2;
        
        //Player player = CPlayer;
        if (count==7){
            notification.RemoveNotification();
            count=0;
        }
        notification.setForeground(CPlayer.getColor());
        notification.addNotification("                               "+CPlayer.getName()+" move "+ result + " steps                                      ");
        count++;
        //notification.RemoveNotification();

        board.movePlayer(CPlayer, result);
        
        gameDisplay.setTokenPosition(CPlayer);

        pMoney[0].updateMoney();
        pMoney[1].updateMoney();
        pMoney[2].updateMoney();
        pMoney[3].updateMoney();
        
        CPlayer.setRollDice(result);
        notification.addNotification(board.Notify());
        if (CPlayer.getPosition()==10 && CPlayer.isInJail() && CPlayer.JailCheck()){
            gameDisplay.setTokenPosition(CPlayer);
            CPlayer.setJailCheck(false);
        }
        if (CPlayer.getPosition()==0 && CPlayer.getchanceCardGO()){
            gameDisplay.setTokenPosition(CPlayer);
            CPlayer.setchanceCardGO(false);
        }
        
        if (CPlayer.getBalance()<=0){
            bankrupted++;
        }

        if (bankrupted==3){
            gameEnd=true;
        }

        CurrentPlayerIndex++;
        if (CurrentPlayerIndex==4)
            CurrentPlayerIndex=0;
    }
    
}
