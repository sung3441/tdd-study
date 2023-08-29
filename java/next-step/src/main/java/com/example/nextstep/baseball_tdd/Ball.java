package com.example.nextstep.baseball_tdd;

import static com.example.nextstep.baseball_tdd.BallStatus.*;

public class Ball {

    private final Number number;

    private final Position position;

    public Ball(final Number number, final Position position) {
        this.number = number;
        this.position = position;
    }

    public BallStatus compareTo(Ball ball) {
        if (number.getNumber() != ball.number.getNumber()) {
            return OUT;
        }

        return position.getPosition() == ball.position.getPosition() ? STRIKE : BALL;
    }
}
