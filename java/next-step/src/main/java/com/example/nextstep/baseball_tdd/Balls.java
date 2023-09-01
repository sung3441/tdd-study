package com.example.nextstep.baseball_tdd;

import java.util.Arrays;
import java.util.Objects;

import static com.example.nextstep.baseball_tdd.BallStatus.*;

public class Balls {

    private final Ball[] balls;

    public Balls(Ball ... balls) {
        this.balls = balls;
        validations();
    }

    public BallResult play(Balls playerBalls) {
        BallResult ballResult = new BallResult();

        for (Ball playerBall : playerBalls.balls) {
            ballResult.increment(compareBall(playerBall));
        }

        return ballResult;
    }

    private BallStatus compareBall(Ball playerBall) {
        return Arrays.stream(balls)
                .map(ball -> ball.compareTo(playerBall))
                .filter(status -> !status.equals(OUT))
                .findFirst()
                .orElse(OUT);
    }

    private void validations() {
        nullCheck();
        validationSize();
        validationPosition();
        duplicateBalls();
    }

    private void nullCheck() {
        if (Arrays.stream(balls).anyMatch(Objects::isNull)) {
            throw new RuntimeException("balls has null");
        }
    }

    private void validationSize() {
        if (balls.length != 3) {
            throw new RuntimeException(String.format("invalid balls size : %d", balls.length));
        }
    }

    private void validationPosition() {
        for (int index = 0; index < balls.length; index++) {
            balls[index].validationPosition(index + 1);
        }
    }

    private void duplicateBalls() {
        if (balls[0].compareNumber(balls[1])
                || balls[1].compareNumber(balls[2])
                || balls[0].compareNumber(balls[2])) {
            throw new RuntimeException("duplicate ball number");
        }
    }
}
