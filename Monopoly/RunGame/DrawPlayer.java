package Monopoly.RunGame;

import Monopoly.RunGame.GameRule.Player;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class DrawPlayer extends JPanel {
    private BufferedImage token;
    private int x,y;
    public DrawPlayer(Player player, int position){
        try{
            token = ImageIO.read(new File(player.getToken()));
            BufferedImage resizedImage = new BufferedImage(50, 50, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = resizedImage.createGraphics();
            g2d.drawImage(token, 0, 0, 50, 50, null);
            g2d.dispose();
            token = resizedImage;
            setPreferredSize(new Dimension(token.getWidth(), token.getHeight()));
        } catch (IOException e){
            e.printStackTrace();
        }
        if (position==0){
            x=750;
            y=750;
        }
    }
    public void ReDraw(){
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        //Image token Image = 
        g.drawImage(token,x,y,this);
    }
}
