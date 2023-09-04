package com.example.nextstep.car_racing;

import java.util.Objects;

public class Car {
    private final String name;

    private int moveCount;

    public Car(String name) {
        this.name = name;
        this.moveCount = 1;
        validationName();
    }

    private void validationName() {

        if (Objects.isNull(name) || name.isEmpty()) {
            throw new RuntimeException("The name is null or empty");
        }

        if (name.length() > 5) {
            throw new RuntimeException(String.format("The name can be up to 5 characters long : %s", name));
        }
    }

    public String showCurrentStatus() {
        return String.format("%s : %s\n", name, "-".repeat(moveCount));
    }

    public void move(int random) {
        if (random >= 4) {
            moveCount++;
        }
    }
}
