package com.example.nextstep.coordinate;

public class RentCompany {

    private final Cars cars = new Cars();

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public String generateReport() {
        return cars.getAllCarInfo();
    }
}
