package com.edu.constants;

import java.util.Map;

public enum Direction {
    STAND,
    WALK,
    RUN,

    HIT;

    public static Map<Direction, Integer> getDirectionMap() {
        return Map.of(
                STAND, 0,
                WALK, 1,
                RUN, 2,
                HIT, 4
        );
    }

    public static Map<Direction, Integer> getDirectionMapImage() {
        return Map.of(
                STAND, 4,
                WALK, 5,
                RUN, 2,
                HIT, 2
        );
    }
}
