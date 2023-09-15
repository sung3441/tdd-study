package com.example.nextstep.coordinate;

import java.util.ArrayList;

public class Cars {

    private static final String NEW_LINE = System.getProperty("line.separator");

    private final ArrayList<Car> cars = new ArrayList<>();

    public void add(Car car) {
        cars.add(car);
    }

    public String getAllCarInfo() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getCarInfo()).append(NEW_LINE);
        }
        return sb.toString();
    }
}
