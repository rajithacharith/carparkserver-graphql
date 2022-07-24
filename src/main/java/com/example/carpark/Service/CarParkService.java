package com.example.carpark.Service;

import com.example.carpark.Entity.Car;

import java.util.ArrayList;
import java.util.List;

public class CarParkService {

    private static CarParkService instance;
    private List<Car> parkedCars = new ArrayList<>();

    private CarParkService() {
        Car car = new Car("test", "KJ-50990", "Toyota");
        parkedCars.add(car);
    }

    public static CarParkService getInstance() {
        if (instance == null){
            instance = new CarParkService();
        }
        return instance;
    }

    public Car parkCar(Car car) {
        parkedCars.add(car);
        return car;
    }

    public List<Car> getParkedCars() {
        return parkedCars;
    }

}
