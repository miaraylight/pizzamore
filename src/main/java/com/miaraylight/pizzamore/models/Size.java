package com.miaraylight.pizzamore.models;

public enum Size {
    ONE_SIZE("O", "One size"),
    SMALL("S", "Small"),
    MEDIUM("M", "Medium"),
    LARGE("L", "Large");

    private final String code;
    private final String label;

    Size(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public static Size fromInput(String input) {
        if (input == null) return MEDIUM; // by default set to medium
        input = input.trim().toUpperCase();

        return switch (input) {
            case "O", "ONE_SIZE" -> ONE_SIZE;
            case "S", "SMALL" -> SMALL;
            case "L", "LARGE" -> LARGE;
            default -> MEDIUM;
        };
    }

    @Override
    public String toString() {
        return "Size{" +
                "label='" + label + '\'' +
                '}';
    }
}
