package com.miaraylight.pizzamore.models;

public enum CrustType {
    THIN("1", "Thin"),
    REGULAR("2", "Regular"),
    THICK("3", "Thick"),
    CAULIFLOWER("4", "Cauliflower");

    private String code;
    private String label;

    CrustType(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
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


    @Override
    public String toString() {
        return "CrustType{" +
                "code='" + code + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
