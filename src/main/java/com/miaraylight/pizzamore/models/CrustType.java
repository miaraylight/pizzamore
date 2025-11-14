package com.miaraylight.pizzamore.models;

public enum CrustType {
    THIN("1", "Thin"), REGULAR("2", "Regular"), THICK("3", "Thick"), CAULIFLOWER("4", "Cauliflower");

    private final String code;
    private final String label;

    CrustType(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public static CrustType fromInput(String input) {
        input = input.trim().toUpperCase();

        return switch (input) {
            case "1", "THIN" -> THIN;
            case "2", "REGULAR" -> REGULAR;
            case "3", "THICK" -> THICK;
            case "4", "CAULIFLOWER" -> CAULIFLOWER;
            default -> REGULAR;
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
