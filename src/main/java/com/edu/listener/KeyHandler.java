package com.edu.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.VK_A;
import static java.awt.event.KeyEvent.VK_D;
import static java.awt.event.KeyEvent.VK_S;
import static java.awt.event.KeyEvent.VK_W;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("pressed: " + e.getKeyChar());
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case VK_A -> leftPressed = true;
            case VK_D -> rightPressed = true;
            case VK_S -> downPressed = true;
            case VK_W -> upPressed = true;
            default -> System.out.println();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case VK_A -> leftPressed = false;
            case VK_D -> rightPressed = false;
            case VK_S -> downPressed = false;
            case VK_W -> upPressed = false;
            default -> System.out.println();
        }
    }
}
