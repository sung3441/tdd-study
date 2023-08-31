package com.example.nextstep.baseball_tdd;

import java.util.List;

public class Balls {

    private final List<Ball> balls;

    public Balls(List<Ball> balls) {
        this.balls = balls;
        validationSize();
        validationPosition();
        duplicateBalls();
    }

    public BallResult play(Balls playerBalls) {
        for (Ball playerBall : playerBalls.balls) {

        }

        return new BallResult(0, 0);
    }

    private void validationSize() {
        if (balls == null) {
            throw new RuntimeException("balls is null");
        }

        if (balls.size() != 3) {
            throw new RuntimeException(String.format("invalid balls size : %d", balls.size()));
        }
    }

    private void validationPosition() {
        for (int index = 0; index < balls.size(); index++) {
            balls.get(index).validationPosition(index + 1);
        }
    }

    private void duplicateBalls() {
        if (balls.get(0).compareNumber(balls.get(1))
                || balls.get(1).compareNumber(balls.get(2))
                || balls.get(0).compareNumber(balls.get(2))) {
            throw new RuntimeException("duplicate ball number");
        }
    }
}
