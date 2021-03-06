package practice.soccer;

import javax.swing.*;
import java.awt.event.*;

public class Game extends JFrame {

    public Game() {
        setSize(655, 520);
        setTitle("Soccer");
        setDefaultCloseOperation(
                WindowConstants.EXIT_ON_CLOSE);

        final Scene scene = new Scene(640, 480);
        add(scene);

        final boolean[] keys = new boolean[4];

        Timer timer = new Timer(30, new ActionListener() {

            long lastTime = System.currentTimeMillis();

            @Override
            public void actionPerformed(ActionEvent e) {

                long currentTime = System.currentTimeMillis();
                long timeElapsed = currentTime - lastTime;
                lastTime = currentTime;

                float time = timeElapsed/1000F;

                //TODO
                float v = scene.getPlayer().getSpeed();
                int x = 0;
                int y = 0;

                if(keys[0]) y-=v*time;
                if(keys[1]) x+=v*time;
                if(keys[2]) y+=v*time;
                if(keys[3]) x-=v*time;

                scene.getPlayer().move(x,y);

                //System.out.println(timeElapsed);

                scene.update(time);

                //scene.repaint();
            }
        });

        timer.start();

        addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        keys[0] = false;
                        break;
                    case KeyEvent.VK_RIGHT:
                        keys[1] = false;
                        break;
                    case KeyEvent.VK_DOWN:
                        keys[2] = false;
                        break;
                    case KeyEvent.VK_LEFT:
                        keys[3] = false;
                        break;
                    case KeyEvent.VK_SPACE:

                        Point p = scene.getPlayer().getPosition();
                        Point b = scene.getBall().getPosition();

                        float dist = scene.distance(p,b);

                        float rB = scene.getBall().getRadius();
                        float rH = scene.getPlayer().getHitRadius();

                        if(dist < rB+rH ) {
                            float dx = b.getX() - p.getX();
                            float dy = b.getY() - p.getY();

                            float speed = 500;

                            scene.getBall().setVelocityX(speed * (dx / dist));
                            scene.getBall().setVelocityY(speed * (dy / dist));
                        }

                        scene.getPlayer().setHit(false);
                        break;
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        keys[0] = true;
                        break;
                    case KeyEvent.VK_RIGHT:
                        keys[1] = true;
                        break;
                    case KeyEvent.VK_DOWN:
                        keys[2] = true;
                        break;
                    case KeyEvent.VK_LEFT:
                        keys[3] = true;
                        break;
                    case KeyEvent.VK_SPACE:
                        scene.getPlayer().setHit(true);
                        break;
                }
            }

        });

    }

    public void start() {
        setVisible(true);
    }

}
