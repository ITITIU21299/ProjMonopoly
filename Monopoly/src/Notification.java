package Monopoly.src;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Notification extends JPanel{
    JLabel notificationLabel;
    public void addNotification(Color color, String text) {
        
        notificationLabel = new JLabel(text);
        notificationLabel.setForeground(color);
        notificationLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        notificationLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        Font labelFont = new Font("Arial ", Font.BOLD, 14);
        notificationLabel.setFont(labelFont);
        add(notificationLabel);

        revalidate();
        repaint();
    }
    public void RemoveNotification(){
        Component[] components = getComponents();
        for (Component component : components) {
            if (component instanceof JLabel) {
                remove(component);
            }
    }  
        revalidate();
        repaint();
    }
}
