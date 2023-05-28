package Monopoly.src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.Font;


import javax.swing.Icon;
import javax.swing.ImageIcon;


public class MonopolyGame{
        private boolean gameEnd=false;
        private JFrame frame;
        private int bankrupted;
        private final int fwidth=800, fheight=800;
        DiceLabel diceLabel = new DiceLabel();

        Random random = new Random();

        Dice diceButton = new Dice();
        ImageIcon[] dice = new ImageIcon[10];
        Image[] icon = new Image[10];
        Image[] resizedicon = new Image[10];
        Icon[] dIcon = new Icon[10];
        ImageIcon[] tokenImage = new ImageIcon[5];
        Color[] ptextcolor = new Color[5];

        int currentPlayerIndex = 0;
        
        Notification notification = new Notification();
        
        int count=0;
        int winnerIndex;
        int notificationCount;

        
        Player[] players = {new Player("Player 1",1000,0,"Monopoly/res/token_car.png", new Color(255, 0, 0), 0),
        new Player("Player 2",1000,0,"Monopoly/res/token_dog.png", new Color(30, 144, 255), 1),
        new Player("Player 3",1000,0,"Monopoly/res/token_hat.png", new Color(255, 0, 255), 2),
        new Player("Player 4",1000,0,"Monopoly/res/token_ship.png", new Color(0, 0, 0), 3)};

        GameDisplay gameDisplay = new GameDisplay(fwidth, fheight);

        Board board = new Board();

        PlayerMoney[] pMoney = new PlayerMoney[4];
        
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
        frame.setLocationRelativeTo(null);
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
                    if (!gameEnd) {
                        Player currentPlayer = players[currentPlayerIndex];
                        if (bankrupted==3){
                            gameEnd=true;
                        }
                        if (gameEnd==true){
                            JDialog dialog = new JDialog();
                            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                            dialog.setSize(400, 200);
                            dialog.setLocationRelativeTo(null);
                            dialog.setModal(true);
                            
                            

                            for (int i=0; i<4; i++){
                                if (players[i].getBalance()>0){
                                    winnerIndex=i;
                                }
                            }

                            JLabel label = new JLabel(players[winnerIndex].getName()+" won the game!");
                            label.setFont(new Font("Arial", Font.BOLD, 20));
                            label.setHorizontalAlignment(SwingConstants.CENTER);
                            dialog.add(label);
                
                            JButton restartButton = new JButton("Restart");
                
                            restartButton.addActionListener(e2 -> {
                                dialog.dispose();
                                startNewGame();
                            });

                            JPanel buttonPanel = new JPanel();
                            buttonPanel.setLayout(new FlowLayout());
                            buttonPanel.add(restartButton);
                
                            dialog.add(buttonPanel, BorderLayout.SOUTH);
                            dialog.setVisible(true);
                        }

                        if (notificationCount==6){
                            notification.RemoveNotification();
                            notificationCount=0;
                        }

                        if (currentPlayer.getBalance()<=0){
                            currentPlayerIndex = (currentPlayerIndex + 1) % 4;
                            notification.addNotification(currentPlayer.getColor(),"                          " + currentPlayer.getName() + " is bankrupted.                          ");
                            return;
                        }
                       
                        int result1 = random.nextInt(6) + 1;
                        int result2 = random.nextInt(6) + 1;

                        currentPlayer.setRollDice(result1, result2);
                        diceLabel.setIcon(new TwoIcon(dIcon[result1], dIcon[result2]));

                        if (currentPlayer.isInJail()) {
                                board.movePlayer(currentPlayer, 0);
                                notification.addNotification(currentPlayer.getColor(), board.Notify());
                                if (currentPlayer.isInJail() ) {
                                    result1=0;
                                    result2=0;
                                }   
                        }
                        
                        PlayTurn(currentPlayer,result1,result2);

                        currentPlayerIndex = (currentPlayerIndex + 1) % 4;
                    }
                }
            });

        JPanel dicePanel = new JPanel();
        dicePanel.setBounds(fwidth+180, 550, 255, 250);
        dicePanel.setLayout(new BorderLayout(0, -150));
        dicePanel.add(diceButton, BorderLayout.SOUTH);
        dicePanel.add(diceLabel, BorderLayout.CENTER);

        frame.revalidate();
        frame.repaint();
        frame.setSize(fwidth+600, fheight+40);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().add(pMoney[0]);
        frame.getContentPane().add(pMoney[1]);
        frame.getContentPane().add(pMoney[2]);
        frame.getContentPane().add(pMoney[3]);
        frame.getContentPane().add(notification);
        frame.getContentPane().add(dicePanel);
        frame.getContentPane().add(gameDisplay);

    }
    public void PlayTurn(Player player, int result1, int result2){
        int result = result1 + result2;
    
        if (result!=0) {
            board.movePlayer(player, result);
            notification.addNotification(player.getColor(),"                                  " + player.getName()+" move "+ result + " steps                                         ");
            notification.addNotification(player.getColor(),board.Notify());
        }

        notificationCount++;
        
        gameDisplay.setTokenPosition(player);

        for (int i=0;i<=3;i++) {
            pMoney[i].updateMoney();
        }
        if (player.getBalance() <= 0) {
            player.setIsBankrupted(true);
            gameDisplay.removePlayer(player);
            bankrupted++;
        }
        
    }
}
