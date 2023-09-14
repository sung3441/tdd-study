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
        if (!number.isSame(ball.number)) {
            return OUT;
        }

        return position.value == ball.position.value ? STRIKE : BALL;
    }

    public void validationPosition(int index) {
        if (position.value != index) {
            throw new RuntimeException(String.format(
                    "invalid ball position : this[%d], index[%d]",
                    position.value,
                    index
            ));
        }
    }

    public boolean isSameNumber(Ball ball) {
        return this.number.isSame(ball.number);
    }
}
