package com.example.nextstep.coordinate;

public class Sonata extends Car {

    private final int tripDistance;

    private final static int PER_LITER = 10;

    private final static String NAME = "Sonata";

    public Sonata(int tripDistance) {
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
