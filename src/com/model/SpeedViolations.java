package com.model;

import com.enums.VehicleType;

public class SpeedViolations implements Rule {
    private int fees;
    private int maxSpeedTruck;
    private int maxSpeedPrivate;

    public SpeedViolations(int maxSpeedTruck, int maxSpeedPrivate, int fees) {
        this.maxSpeedTruck = maxSpeedTruck;
        this.maxSpeedPrivate = maxSpeedPrivate;
        this.fees = fees;
    }

    public int getMaxSpeedTruck() {
        return maxSpeedTruck;
    }

    public void setMaxSpeedTruck(int maxSpeedTruck) {
        this.maxSpeedTruck = maxSpeedTruck;
    }

    public int getMaxSpeedPrivate() {
        return maxSpeedPrivate;
    }

    public void setMaxSpeedPrivate(int maxSpeedPrivate) {
        this.maxSpeedPrivate = maxSpeedPrivate;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    @Override
    public Violation check(Vehicle vehicle) {
        int maxSpeed;

        if (vehicle.getVehicleType() == VehicleType.PRIVATE) {
            maxSpeed = maxSpeedPrivate;
        } else if (vehicle.getVehicleType() == VehicleType.TRUCK) {
            maxSpeed = maxSpeedTruck;
        } else {
            return null;
        }

        if (vehicle.getSpeed() > maxSpeed) {
            String description = "speed of " + vehicle.getSpeed() + " exceeded max allowed " + maxSpeed;
            return new Violation(description, fees);
        }

        return null;
    }
}