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
        if (number.value != ball.number.value) {
            return OUT;
        }

        return position.value == ball.position.value ? STRIKE : BALL;
    }
}
