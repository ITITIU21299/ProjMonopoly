package Monopoly.model.game;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MenuDisplay extends JPanel {
    private BufferedImage image;
    public MenuDisplay(int width, int height) {
        try {
            image = ImageIO.read(new File("Monopoly/res/menuimage.jpg"));
            
            BufferedImage resizedImage = new BufferedImage(width, height, image.getType());

            Graphics2D g2d = resizedImage.createGraphics();
            g2d.drawImage(image, 0, 0, width, height, null);
            g2d.dispose();

            image = resizedImage;
            setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}