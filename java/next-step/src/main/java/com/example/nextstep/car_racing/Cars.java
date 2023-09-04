package com.example.nextstep.car_racing;

import java.util.Arrays;
import java.util.OptionalInt;

import static com.example.nextstep.car_racing.RandomUtil.*;

public class Cars {

    private final Car[] cars;

    public Cars(String stringCars) {
        cars = map(stringCars);
        if (cars.length < 2) {
            throw new RuntimeException(String.format("cars length must be at least 2 : %d", cars.length));
        }
    }

    public int length() {
        return cars.length;
    }

    private Car[] map(String stringCars) {
        return Arrays.stream(stringCars.split(","))
                .map(Car::new)
                .toArray(Car[]::new);
    }

    public String showCurrentStatus() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(cars)
                .forEach(car -> sb.append(car.showCurrentStatus()));
        return sb.toString();
    }

    public void moves() {
        Arrays.stream(cars)
                .forEach(c -> c.move(createRandom()));
    }

    public String[] getWinners(int tryCount) {
        int max = Arrays.stream(cars)
                .mapToInt(Car::getMoveDistance)
                .max()
                .getAsInt();

        return Arrays.stream(cars)
                .filter(car -> car.getMoveDistance() == max)
                .map(car -> car.name)
                .toArray(String[]::new);
    }
}