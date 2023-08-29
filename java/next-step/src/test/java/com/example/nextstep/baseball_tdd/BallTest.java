package com.example.nextstep.baseball_tdd;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class BallTest {

    @ParameterizedTest
    @CsvSource(value = {"1:1:1:1", "2:2:1:1", "9:9:1:1"}, delimiter = ':')
    void strike(int number1, int number2, int position1, int position2) {
        // given
        Ball ball1 = new Ball(new Number(number1), new Position(position1));
        Ball ball2 = new Ball(new Number(number2), new Position(position2));

        // when
        BallStatus status = ball1.compareTo(ball2);

        // then
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1:1:2", "2:2:2:3", "9:9:3:1"}, delimiter = ':')
    void ball(int number1, int number2, int position1, int position2) {
        // given
        Ball ball1 = new Ball(new Number(number1), new Position(position1));
        Ball ball2 = new Ball(new Number(number2), new Position(position2));

        // when
        BallStatus status = ball1.compareTo(ball2);

        // then
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:3:1:2", "1:9:2:2", "5:4:3:1"}, delimiter = ':')
    void out(int number1, int number2, int position1, int position2) {
        // given
        Ball ball1 = new Ball(new Number(number1), new Position(position1));
        Ball ball2 = new Ball(new Number(number2), new Position(position2));

        // when
        BallStatus status = ball1.compareTo(ball2);

        // then
        assertThat(status).isEqualTo(BallStatus.OUT);
    }
}
