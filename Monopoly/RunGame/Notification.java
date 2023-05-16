package Monopoly.RunGame;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Notification extends JPanel{
    JLabel notificationLabel;
    public void addNotification(String text) {
        
        notificationLabel = new JLabel(text);
        notificationLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        notificationLabel.setHorizontalAlignment(SwingConstants.LEFT);
        Font labelFont = new Font("Arial", Font.BOLD, 20);
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
