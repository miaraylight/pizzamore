package com.miaraylight.pizzamore.models;

public enum SauceType {
    MARINARA("1", "Marinara"),
    ALFREDO("2", "Alfredo"),
    PESTO("3", "Pesto"),
    BBQ("4", "BBQ"),
    BUFFALO("5", "Buffalo"),
    OLIVE_OIL("6", "Olive Oil");

    private final String code;
    private final String label;

    SauceType(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public static SauceType fromInput(String input) {
        if (input == null) return MARINARA;
        input = input.trim().toUpperCase();

        return switch (input) {
            case "1", "MARINARA" -> MARINARA;
            case "2", "ALFREDO" -> ALFREDO;
            case "3", "PESTO" -> PESTO;
            case "4", "BBQ" -> BBQ;
            case "5", "BUFFALO" -> BUFFALO;
            case "6", "OLIVE OIL", "OLIVEOIL", "OLIVE_OIL" -> OLIVE_OIL;
            default -> MARINARA; // fallback
        };
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }
}
