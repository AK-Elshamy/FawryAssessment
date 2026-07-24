package com.model;

import java.util.List;


public class Fine {
    private final String plateNumber;
    private final List<Violation> violations;
    private final int totalAmount;

    public Fine(String plateNumber, List<Violation> violations) {
        this.plateNumber = plateNumber;
        this.violations = violations;
        int sum = 0;
        for (Violation v : violations) {
            sum += v.getFees();
        }
        this.totalAmount = sum;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public List<Violation> getViolations() {
        return violations;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("Traffic fine for car ").append(plateNumber).append("\n");
        sb.append("Total amount: ").append(totalAmount).append(" EGP\n");
        sb.append("Violations:\n");
        for (Violation v : violations) {
            sb.append("- ").append(v.getDescription()).append(" : ").append(v.getFees()).append(" EGP\n");
        }
        System.out.print(sb);
    }
}