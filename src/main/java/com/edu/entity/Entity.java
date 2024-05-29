package com.edu.entity;


import com.edu.constants.Direction;
import lombok.Data;

import java.awt.image.BufferedImage;

@Data
public class Entity {
    protected int x;
    protected int y;
    protected int speed;
    protected BufferedImage playerActionsImage;
    protected Direction direction = Direction.STAND;
    protected int spriteCounter = 0;
    protected int spriteNum = 1;
}
