package com.edu.entity;

import com.edu.constants.Direction;
import com.edu.listener.KeyHandler;
import com.edu.listener.MouseInputs;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;


public class Player extends Entity {
    KeyHandler keyHandler;
    MouseInputs mouseInputs;

    public Player(KeyHandler keyHandler, MouseInputs mouseInputs) {
        this.keyHandler = keyHandler;
        this.mouseInputs = mouseInputs;

        setDefaultProperties();
        loadImage();

    }

    public void setDefaultProperties() {
        this.setX(100);
        this.setY(100);
        this.setSpeed(4);
    }

    public void update() {
        if (keyHandler.downPressed) {
            y += speed;
            direction = Direction.WALK;
        } else if (keyHandler.upPressed) {
            y -= speed;
            direction = Direction.WALK;

        } else if (keyHandler.leftPressed) {
            direction = Direction.WALK;

            x -= speed;
        } else if (keyHandler.rightPressed) {
            x += speed;
            direction = Direction.WALK;
        } else {
            direction = Direction.STAND;
        }
        if (mouseInputs.clicked) {
            direction = Direction.HIT;
        }
        spriteCounter++;
        int maxSpriteCounter = Direction.HIT.equals(direction) ? 10 : 15;
        if (spriteCounter > maxSpriteCounter) {
            if (spriteNum < Direction.getDirectionMapImage().get(direction)) {
                spriteNum++;
            } else {
                spriteNum = 0;
            }
            spriteCounter = 0;
        }
    }

    public void draw(Graphics graphics) {
        int imageY = Direction.getDirectionMap().get(direction);
        Graphics2D gr2d = (Graphics2D) graphics;
        gr2d.drawImage(playerActionsImage.getSubimage(spriteNum * 64, imageY * 40, 64, 40), x, y, 96, 60, null);
    }

    private void loadImage() {
        try {
            playerActionsImage = ImageIO
                    .read(Objects.requireNonNull(getClass()
                            .getResourceAsStream("/imgs/player/player.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
