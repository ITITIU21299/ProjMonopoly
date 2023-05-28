package Monopoly.src;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class TwoToken {
    private BufferedImage img1;
    private BufferedImage img2;
    public TwoToken(BufferedImage a, BufferedImage b) {
        img1=a;
        img2=b;
        get2tokens();
    }
    public BufferedImage get2tokens() {
        
        int offset = 2;
        int width = 50;
        int height = Math.max(img1.getHeight(), img2.getHeight()) + offset;

        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = newImage.createGraphics();
        Color oldColor = g2.getColor();
        g2.setPaint(Color.BLACK);
        g2.fillRect(0, 0, width, height);
        g2.setColor(oldColor);
        g2.drawImage(img1, null, 0, 0);
        g2.drawImage(img2, null, img1.getWidth() + offset, 0);
        g2.dispose();
        return newImage;
    } 
}
