package com.edu.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GameConstants {

    public static final int ORIGINAL_TITLE_SIZE = 16;
    public static final int SCALE = 3;
    public static final int TITLE_SIZE = ORIGINAL_TITLE_SIZE * SCALE;


    public static final int MAX_GAME_COL = 16;
    public static final int MAX_GAME_ROW = 12;
    public static final int WINDOW_WIDTH = MAX_GAME_COL * TITLE_SIZE;
    public static final int WINDOW_HEIGHT = MAX_GAME_ROW * TITLE_SIZE;
    public static final int EPS = 60;


}
