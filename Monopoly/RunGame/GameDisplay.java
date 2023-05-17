package Monopoly.RunGame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GameDisplay extends JPanel {
    private BufferedImage image;
    private BufferedImage[] tokenImage;
    private int[] tokenX;
    private int[] tokenY;

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
                BufferedImage resizedtoken = new BufferedImage(50, 50, BufferedImage.TYPE_INT_RGB);
                Graphics2D g2 = resizedtoken.createGraphics();
                g2.drawImage(tokenImage[i], 0, 0, 50, 50, null);
                g2.dispose();
                tokenImage[i] = resizedtoken;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setTokenPosition(int playerIndex, int coor) {
        //tokenX[0] = 725;
        //tokenY[0] = 725;
        //tokenX[1] = 725;
        //tokenY[1] = 725;
        //tokenX[2] = 725;
        //tokenY[2] = 725;
        //tokenX[3] = 725;
        //tokenY[3] = 725;
        // Bottom
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
        for (int i = 0; i < 4; i++) {
            g.drawImage(tokenImage[i], tokenX[i], tokenY[i], this);
        }
    }
}
