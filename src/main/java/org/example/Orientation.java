package org.example;

public enum Orientation {
    NORD("N"),
    EST("E"),
    SUD("S"),
    OUEST("O");

    private final String code;

    Orientation(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
