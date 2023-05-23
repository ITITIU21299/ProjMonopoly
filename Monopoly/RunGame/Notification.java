package Monopoly.RunGame;

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
        notificationLabel.setHorizontalAlignment(SwingConstants.LEFT);
<<<<<<< HEAD
        Font labelFont = new Font("Arial ", Font.BOLD, 17);
=======
        Font labelFont = new Font("Arial", Font.BOLD, 13);
>>>>>>> d936ba10d3c7fd04048c77a4d75642b10fe853ae
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
