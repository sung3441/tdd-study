package com.example.nextstep.car_racing_feedback;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    List<Car> cars;

    public Cars(String cars) {
        this.cars = Arrays.stream(cars.split(","))
                .map(name -> new Car(new Name(name), new Distance()))
                .collect(Collectors.toList());
    }

    public void racing() {
        for (Car car : cars) {
            car.move(RandomUtil.randomNum());
        }
    }

    public String getCurrentAllStatus() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getCurrentStatus()).append("\n");
        }
        return sb.toString();
    }

    public String[] findWinners() {
        int max = getMaxDistance();

        return cars.stream()
                .filter(car -> car.isWinner(max))
                .map(Car::getName)
                .toArray(String[]::new);
    }

    private int getMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow();
    }
}
