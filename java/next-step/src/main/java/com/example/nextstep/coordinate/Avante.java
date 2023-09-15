package com.example.nextstep.coordinate;

public class Avante extends Car {
    private final int tripDistance;

    private final static int PER_LITER = 15;

    private final static String NAME = "Avante";

    public Avante(int tripDistance) {
        this.tripDistance = tripDistance;
    }

    @Override
    double getDistancePerLiter() {
        return PER_LITER;
    }

    @Override
    double getTripDistance() {
        return tripDistance;
    }

    @Override
    String getName() {
        return NAME;
    }
}
