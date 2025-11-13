package com.miaraylight.pizzamore.models;

public enum CrustType {
    THIN("Thin"),
    REGULAR("Regular"),
    THICK("Thick"),
    CAULIFLOWER("Cauliflower");

    private String label;

    CrustType(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "CrustType{" +
                "label='" + label + '\'' +
                '}';
    }
}
