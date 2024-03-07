package lesson2;

import javax.swing.*;
import java.awt.*;

public class MainCircles extends JFrame {
    private  static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WIDOW_HEIGHT = 600;

    Sprite[] sprites = new Sprite[10];

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();
            }
        });
    }

    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WIDOW_HEIGHT);
        GameCanvas canvas = new GameCanvas(this);
        
        iniApplication();
        add(canvas);
        setTitle("Circles");
        setVisible(true);
    }

    private void iniApplication() {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }

    void onDrawFlame(GameCanvas canvas, Graphics g,float deltaTime) {
        update(canvas, deltaTime);
        render(canvas,g);
    }

    private void update(GameCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas,deltaTime);
        }
    }

    private  void  render (GameCanvas canvas,Graphics g){
        for(int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas,g);
        }
    }
}
