package com.miaraylight.pizzamore.models;

public enum SauceType {
    MARINARA("Marinara"),
    ALFREDO("Alfredo"),
    PESTO("Pesto"),
    BBQ("BBQ"),
    BUFFALO("Buffalo"),
    OLIVE_OIL("Olive Oil");

    private final String label;

    SauceType(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "SauceType{" +
                "label='" + label + '\'' +
                '}';
    }
}
