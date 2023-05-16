package Monopoly.RunGame;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Notification extends JPanel{
    JLabel notificationLabel;
    public void addNotification(String text) {
        
        notificationLabel = new JLabel(text);
        notificationLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        notificationLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        add(notificationLabel);

        revalidate();
        repaint();
    }
    public void RemoveNotification(){
        //remove(notificationLabel);
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
