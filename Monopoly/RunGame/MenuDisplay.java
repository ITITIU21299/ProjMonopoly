package Monopoly.RunGame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuDisplay extends JPanel {
    private BufferedImage image;

    public MenuDisplay() {
        try {
            // Load the image from file
            image = ImageIO.read(new File("Monopoly/res/menuimage.jpg"));
            int width = 1600;
            int height = 1100;
            BufferedImage resizedImage = new BufferedImage(width, height, image.getType());

            // Draw the original image onto the new image with the desired size using Graphics2D
            Graphics2D g2d = resizedImage.createGraphics();
            g2d.drawImage(image, 0, 0, 1600, 800, null);
            g2d.dispose();

            // Set the new resized image as the image to be displayed
            image = resizedImage;
            setPreferredSize(new Dimension(image.getWidth(), image.getHeight())); // set preferred size of the panel
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the image on the panel
        g.drawImage(image, 0, 0, this);
    }
}