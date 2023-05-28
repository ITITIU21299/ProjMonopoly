package Monopoly.src;

import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Icon;

public class TwoIcon implements Icon {

    private final int iconGap = 2;
    private final Icon icon1;
    private final Icon icon2;

    public TwoIcon(final Icon icon1, final Icon icon2) {
        this.icon1 = icon1;
        this.icon2 = icon2;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        int mid = getIconHeight() / 2;
        int y1 = y + mid - icon1.getIconHeight() / 2-75;
        int y2 = y + mid - icon2.getIconHeight() / 2-75;
        icon1.paintIcon(c, g, x, y1);
        icon2.paintIcon(c, g, x + icon1.getIconWidth() + iconGap, y2);
    }

    @Override
    public int getIconWidth() {
        return icon1.getIconWidth() + icon2.getIconWidth() + iconGap;
    }

    @Override
    public int getIconHeight() {
        return Math.max(icon1.getIconHeight(), icon2.getIconHeight());
    }
}