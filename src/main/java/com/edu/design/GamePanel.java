package com.edu.design;

import com.edu.constants.GameConstants;
import com.edu.entity.Player;
import com.edu.listener.KeyHandler;
import com.edu.listener.MouseInputs;

import javax.swing.*;
import java.awt.*;

import static com.edu.constants.GameConstants.WINDOW_HEIGHT;
import static com.edu.constants.GameConstants.WINDOW_WIDTH;

public class GamePanel extends JPanel implements Runnable {
    KeyHandler keyHandler = new KeyHandler();
    MouseInputs mouseInputs = new MouseInputs();

    Thread gameThread;
    Player player = new Player(keyHandler, mouseInputs);


    public GamePanel() {
        this.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        this.setBackground(Color.BLACK);
        this.requestFocus();
        this.addKeyListener(keyHandler);
        this.addMouseListener(mouseInputs);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000d / GameConstants.EPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        while (gameThread != null) {
            player.update();
            repaint();
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                if (remainingTime < 0) {
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime / 1000000);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        player.draw(g);
    }
}
