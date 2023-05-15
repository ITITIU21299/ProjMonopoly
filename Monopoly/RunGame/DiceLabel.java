package Monopoly.RunGame;

import javax.swing.JLabel;

public class DiceLabel extends JLabel{

    public DiceLabel() {
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
        revalidate();
        repaint();
    }
}
