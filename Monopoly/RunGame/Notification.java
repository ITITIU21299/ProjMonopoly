package Monopoly.RunGame;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Notification extends JPanel{
    public void addNotification(String text) {
        JLabel notificationLabel = new JLabel(text);
        notificationLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        notificationLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(notificationLabel);

        revalidate();
        repaint();
    }
    
}
