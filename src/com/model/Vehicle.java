package com.model;

import com.enums.VehicleType;
import java.util.Date;

public class Vehicle {
    private int speed;
    private String plateNumber;
    private boolean seatbelt;
    private VehicleType vehicleType;
    private Date date;

    public Vehicle() {
    }

    public Vehicle(int speed, String plateNumber, boolean seatbelt, VehicleType vehicleType, Date date) {
        this.speed = speed;
        this.plateNumber = plateNumber;
        this.seatbelt = seatbelt;
        this.vehicleType = vehicleType;
        this.date = date;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public boolean isSeatbeltFastened() {
        return seatbelt;
    }

    public void setSeatbelt(boolean seatbelt) {
        this.seatbelt = seatbelt;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}