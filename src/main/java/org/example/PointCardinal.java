package org.example;

public enum PointCardinal {
    NORD("N"),
    EST("E"),
    SUD("S"),
    OUEST("O");

    private final String code;

    PointCardinal(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
