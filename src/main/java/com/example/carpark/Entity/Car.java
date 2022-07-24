package com.example.carpark.Entity;

public class Car {

    String id;
    String vehicleNumber;
    String vehicleType;

    public Car(String id, String vehicleNumber, String vehicleType) {

        this.id = id;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getVehicleNumber() {

        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {

        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {

        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {

        this.vehicleType = vehicleType;
    }
}
