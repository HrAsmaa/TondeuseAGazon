package org.example.Enumerations;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum Direction {
    DROITE("D"),
    GAUCHE("G"),
    AVANCER("A");

    private final String code;

    private static final Map<String, Direction> CODE_MAP = new HashMap<>();

    static {
        for (Direction d : values()) {
            CODE_MAP.put(d.code, d);
        }
    }

    Direction(String code) {
        this.code = code;
    }

    public static Direction fromCode(String code) {
        Direction direction = CODE_MAP.get(code.toUpperCase());
        if (direction == null) {
            throw new IllegalArgumentException("Invalid code for Orientation: " + code);
        }
        return direction;
    }
}
