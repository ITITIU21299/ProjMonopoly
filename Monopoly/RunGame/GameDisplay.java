package Monopoly.RunGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import Monopoly.RunGame.GameRule.Player;

public class GameDisplay extends JPanel{
    HashMap <Integer, Player> playersMap = new HashMap<Integer, Player>();
    Optional<Integer> firstKey = playersMap.keySet().stream().findFirst();
    private int[] key = new int[5];

    private BufferedImage image;
    private BufferedImage[] tokenImage;
    private BufferedImage resizedtoken;
    private Graphics2D g2;
    private static int[] tokenX;
    private static int[] tokenY;
    private static int cnt=-1;
    private int playerIndex;
    SquareToDrawn[] squareToDrawn = new SquareToDrawn[200];
    Player[] players = new Player[5];
    int check =0;
    private BufferedImage[] newToken = new BufferedImage[5];

    int coor;
    public GameDisplay(int width, int height) {
        try {
            image = ImageIO.read(new File("Monopoly/res/board.jpg"));
            tokenImage = new BufferedImage[4];
            tokenX = new int[4];
            tokenY = new int[4];
            tokenImage[0] = ImageIO.read(new File("Monopoly/res/token_car.png"));
            tokenImage[1] = ImageIO.read(new File("Monopoly/res/token_dog.png"));
            tokenImage[2] = ImageIO.read(new File("Monopoly/res/token_hat.png"));
            tokenImage[3] = ImageIO.read(new File("Monopoly/res/token_ship.png"));
            BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = resizedImage.createGraphics();
            g2d.drawImage(image, 0, 0, width, height, null);
            g2d.dispose();

            image = resizedImage;
            setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
            for (int i = 0; i < 4; i++) {
                resizedtoken = new BufferedImage(50, 50, BufferedImage.TYPE_INT_RGB);
                g2 = resizedtoken.createGraphics();
                g2.drawImage(tokenImage[i], 0, 0, 50, 50, null);
                g2.dispose();
                tokenImage[i] = resizedtoken;
            }
            for (int i=0;i<=42;i++) {
                squareToDrawn[i] = new SquareToDrawn();
            }
            for (int i=0; i<4; i++) {
                newToken[i] = resize(tokenImage[i], 24, 24);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /* public void addPlayerToCoor (int playerIndex, int coor) {
        cnt++;
        boardCoor[coor][cnt] = playerIndex;
    }
    public void removePlayerFromCoor (int playerIndex, int coor) {
        cnt--;
        boardCoor[coor][cnt] = -1;
    } */
    public void setInitialTokenPosition (Player player) {
        tokenX[player.getIndex()] = 725;
        tokenY[player.getIndex()] = 725;
        squareToDrawn[0].addPlayer(player);
    }
    public static BufferedImage resize(BufferedImage img, int newW, int newH) { 
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
    
        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
    
        return dimg;
    }  
    public void setTokenPosition(Player player) {
        //tokenX[0] = 725;
        //tokenY[0] = 725;
        //tokenX[1] = 725;
        //tokenY[1] = 725;
        //tokenX[2] = 725;
        //tokenY[2] = 725;
        //tokenX[3] = 725;
        //tokenY[3] = 725;
                
        coor = player.getPosition() % 40;
        playerIndex = player.getIndex();
        //System.out.println(coor);
        
        squareToDrawn[player.getPrevPosition()].removePlayer(player);
        squareToDrawn[coor].addPlayer(player);
        
        //playersMap = squareToDrawn[player.getPosition()].getMap();

        //System.out.println(coor + " " + squareToDrawn[coor].getCoor());
        
        if (coor == 0) {
            tokenX[playerIndex] = 725;
            tokenY[playerIndex] = 725;
        }
        if (coor == 1) {
            tokenX[playerIndex] = 635;
            tokenY[playerIndex] = 725;
        }
        if (coor == 2) {
            tokenX[playerIndex] = 570;
            tokenY[playerIndex] = 725;
        }
        if (coor == 3) {
            tokenX[playerIndex] = 505;
            tokenY[playerIndex] = 725;
        }
        if (coor == 4) {
            tokenX[playerIndex] = 440;
            tokenY[playerIndex] = 725;
        }
        if (coor == 5) {
            tokenX[playerIndex] = 375;
            tokenY[playerIndex] = 725;
        }
        if (coor == 6) {
            tokenX[playerIndex] = 310;
            tokenY[playerIndex] = 725;
        }
        if (coor == 7) {
            tokenX[playerIndex] = 245;
            tokenY[playerIndex] = 725;
        }
        if (coor == 8) {
            tokenX[playerIndex] = 180;
            tokenY[playerIndex] = 725;
        }
        if (coor == 9) {
            tokenX[playerIndex] = 115;
            tokenY[playerIndex] = 725;
        }
        if (coor == 10) {
            tokenX[playerIndex] = 35;
            tokenY[playerIndex] = 725;
        }
        /*
         * if (coor>=1 || coor <=9){
         * tokenX[playerIndex] = 725-coor*65;
         * tokenY[playerIndex] = 725;
         * }
         */
        // Left
        if (coor == 11) {
            tokenX[playerIndex] = 20;
            tokenY[playerIndex] = 635;
        }
        if (coor == 12) {
            tokenX[playerIndex] = 20;
            tokenY[playerIndex] = 570;
        }
        if (coor == 13) {
            tokenX[playerIndex] = 20;
            tokenY[playerIndex] = 505;
        }
        if (coor == 14) {
            tokenX[playerIndex] = 20;
            tokenY[playerIndex] = 440;
        }
        if (coor == 15) {
            tokenX[playerIndex] = 20;
            tokenY[playerIndex] = 375;
        }
        if (coor == 16) {
            tokenX[playerIndex] = 20;
            tokenY[playerIndex] = 310;
        }
        if (coor == 17) {
            tokenX[playerIndex] = 20;
            tokenY[playerIndex] = 245;
        }
        if (coor == 18) {
            tokenX[playerIndex] = 20;
            tokenY[playerIndex] = 180;
        }
        if (coor == 19) {
            tokenX[playerIndex] = 20;
            tokenY[playerIndex] = 115;
        }
        if (coor == 20) {
            tokenX[playerIndex] = 30;
            tokenY[playerIndex] = 30;
        }
        // Top
        if (coor == 21) {
            tokenX[playerIndex] = 115;
            tokenY[playerIndex] = 35;
        }
        if (coor == 22) {
            tokenX[playerIndex] = 180;
            tokenY[playerIndex] = 35;
        }
        if (coor == 23) {
            tokenX[playerIndex] = 245;
            tokenY[playerIndex] = 35;
        }
        if (coor == 24) {
            tokenX[playerIndex] = 310;
            tokenY[playerIndex] = 35;
        }
        if (coor == 25) {
            tokenX[playerIndex] = 375;
            tokenY[playerIndex] = 35;
        }
        if (coor == 26) {
            tokenX[playerIndex] = 440;
            tokenY[playerIndex] = 35;
        }
        if (coor == 27) {
            tokenX[playerIndex] = 505;
            tokenY[playerIndex] = 35;
        }
        if (coor == 28) {
            tokenX[playerIndex] = 570;
            tokenY[playerIndex] = 35;
        }
        if (coor == 29) {
            tokenX[playerIndex] = 635;
            tokenY[playerIndex] = 35;
        }
        if (coor == 30) {
            tokenX[playerIndex] = 725;
            tokenY[playerIndex] = 30;
        }
        // Right
        if (coor == 31) {
            tokenX[playerIndex] = 730;
            tokenY[playerIndex] = 115;
        }
        if (coor == 32) {
            tokenX[playerIndex] = 730;
            tokenY[playerIndex] = 180;
        }
        if (coor == 33) {
            tokenX[playerIndex] = 730;
            tokenY[playerIndex] = 245;
        }
        if (coor == 34) {
            tokenX[playerIndex] = 730;
            tokenY[playerIndex] = 310;
        }
        if (coor == 35) {
            tokenX[playerIndex] = 730;
            tokenY[playerIndex] = 375;
        }
        if (coor == 36) {
            tokenX[playerIndex] = 730;
            tokenY[playerIndex] = 440;
        }
        if (coor == 37) {
            tokenX[playerIndex] = 730;
            tokenY[playerIndex] = 505;
        }
        if (coor == 38) {
            tokenX[playerIndex] = 730;
            tokenY[playerIndex] = 570;
        }
        if (coor == 39) {
            tokenX[playerIndex] = 730;
            tokenY[playerIndex] = 635;
        }
        repaint();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
        cnt=-1;
        for (SquareToDrawn std : squareToDrawn) {
            if (std != null && std.getNoPlayer()!=0) {
                playersMap = std.getMap();
                
                for (int i=0; i<=3; i++) {
                    if (playersMap.get(i)!=null) {
                        cnt++;
                        key[cnt]=i;
                    }
                }
                cnt=-1;

                if (std.getNoPlayer() == 1) {
                    g.drawImage(tokenImage[key[0]], tokenX[key[0]], tokenY[key[0]], this);
                }

                if (std.getNoPlayer() == 2) {
                    TwoToken twoToken = new TwoToken(newToken[key[0]], newToken[key[1]]);
                    BufferedImage finalToken = twoToken.get2tokens();
                    g.drawImage(finalToken, tokenX[key[0]], tokenY[key[0]], this);
                }

                if (std.getNoPlayer() == 3) {
                    ThreeToken threeToken = new ThreeToken(newToken[key[0]], newToken[key[1]], newToken[key[2]]);
                    BufferedImage finalToken = threeToken.get3tokens();
                    g.drawImage(finalToken, tokenX[key[0]], tokenY[key[0]], this);
                }

                if (std.getNoPlayer() == 4) {
                    FourToken fourtToken = new FourToken(newToken[key[0]], newToken[key[1]], newToken[key[2]], newToken[key[4]]);
                    BufferedImage finalToken = fourtToken.get4tokens();
                    g.drawImage(finalToken, tokenX[key[0]], tokenY[key[0]], this);
                }
            }
        } 
        if (check <=4)
        for (int i = 0; i < 4; i++) {
            //g.drawImage(tokenImage[i], tokenX[i], tokenY[i], this);
            check++;
        }
    }
}
