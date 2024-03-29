package lesson2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainCircles extends JFrame {
    private  static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WIDOW_HEIGHT = 600;

    private Sprite[] sprites = new Sprite[1];
    private int spritesCount;

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

        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() ==MouseEvent.BUTTON1)
                    addSprite(new Ball(e.getX(), e.getY()));
                else if (e.getButton() == MouseEvent.BUTTON3)
                    removeSprite();

            }
        });
        setVisible(true);
    }
    private void addSprite(Sprite s) {
        if (spritesCount == sprites.length) {
            Sprite[] temp = new Sprite[sprites.length * 2];
            System.arraycopy(sprites,0, temp,0, sprites.length);
            sprites = temp;
        }
        sprites[spritesCount++] = s;
    }

    private void removeSprite() {
        if (spritesCount > 1) spritesCount--;
    }

    private void iniApplication() {
        addSprite(new Background());
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
