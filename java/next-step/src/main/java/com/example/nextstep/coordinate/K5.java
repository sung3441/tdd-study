package com.example.nextstep.coordinate;

public class K5 extends Car {
    private final int tripDistance;

    private final static int PER_LITER = 13;

    private final static String NAME = "K5";

    public K5(int tripDistance) {
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
