package com.example.nextstep.coordinate;

public abstract class Car {

    /**
     * 리터당 이동 거리, 연비
     */
    abstract double getDistancePerLiter();

    /**
     * 여행 거리
     */
    abstract double getTripDistance();

    abstract String getName();

    /**
     * 주입 해야 되는 연료량
     */
    double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }

    String getCarInfo() {
        return String.format("%s : %.0f리터", getName(), getChargeQuantity());
    }
}
