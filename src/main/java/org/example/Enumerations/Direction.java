package org.example.Enumerations;

public enum Direction {
    DROITE("D"),
    GAUCHE("G"),
    AVANCER("A");

    private final String code;

    Direction(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
