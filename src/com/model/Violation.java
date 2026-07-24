package com.model;

public class Violation {
    private String description;
    private int fees;

    public Violation(String description, int fees) {
        this.description = description;
        this.fees = fees;
    }

    public String getDescription() {
        return description;
    }

    public int getFees() {
        return fees;
    }
}