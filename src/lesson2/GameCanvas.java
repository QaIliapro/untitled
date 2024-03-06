package lesson2;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {

    int x = 0;

    //@Override
    protected void painComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("Paint component");
        g.drawLine(x++,0,100,100);
        try {
            Thread.sleep(16);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        repaint();
    }
}
