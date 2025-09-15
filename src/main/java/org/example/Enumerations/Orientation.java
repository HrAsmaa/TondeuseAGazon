package org.example.Enumerations;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum Orientation {
    NORD("N"),
    EST("E"),
    SUD("S"),
    OUEST("O");

    private final String code;

    private static final Map<String, Orientation> CODE_MAP = new HashMap<>();

    static {
        for (Orientation o : values()) {
            CODE_MAP.put(o.code, o);
        }
    }

    Orientation(String code) {
        this.code = code;
    }

    public static Orientation fromCode(String code) {
        Orientation orientation = CODE_MAP.get(code.toUpperCase());
        if (orientation == null) {
            throw new IllegalArgumentException("Invalid code for Orientation: " + code);
        }
        return orientation;
    }
}
