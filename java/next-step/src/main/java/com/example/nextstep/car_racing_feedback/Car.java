package com.example.nextstep.car_racing_feedback;

public class Car {

    private final static int MIN_RANDOM_NUM = 4;

    private final Name name;

    private final Distance distance;

    public Car(Name name, Distance distance) {
        this.name = name;
        this.distance = distance;
    }

    public void move(int random) {
        if (random >= MIN_RANDOM_NUM) {
            distance.increment();
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getDistance() {
        return distance.getDistance();
    }

    public String getCurrentStatus() {
        return String.format("%s : %s", getName(), "-".repeat(getDistance()));
    }

    public boolean isWinner(int maxDistance) {
        return this.getDistance() == maxDistance;
    }
}
