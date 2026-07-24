package com.model;

public class Seatbelt implements Rule {
    private int fees;

    public Seatbelt(int fees) {
        this.fees = fees;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    @Override
    public Violation check(Vehicle vehicle) {
        if (!vehicle.isSeatbeltFastened()) {
            return new Violation("Seatbelt not fastned", fees);
        }
        return null;
    }
}