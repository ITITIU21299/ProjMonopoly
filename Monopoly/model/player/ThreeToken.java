package Monopoly.model.player;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class ThreeToken {
    private BufferedImage img1;
    private BufferedImage img2;
    private BufferedImage img3;
    public ThreeToken(BufferedImage a, BufferedImage b, BufferedImage c) {
        img1=a;
        img2=b;
        img3=c;
        get3tokens();
    }
    public BufferedImage get3tokens() {
        
        int offset = 2;
        int width = 50;
        int height = 50;

        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = newImage.createGraphics();
        Color oldColor = g2.getColor();
        g2.setPaint(Color.WHITE);
        g2.fillRect(0, 0, width, height/2);
        g2.fillRect(13, 25, width/2, height/2);
        g2.setColor(oldColor);
        g2.drawImage(img1, null, 0, 0);
        g2.drawImage(img2, null, img1.getWidth() + offset, 0);
        g2.drawImage(img3, null, (img1.getWidth() + offset)/2, img1.getHeight() + offset);
        g2.dispose();
        return newImage;
    } 
}
