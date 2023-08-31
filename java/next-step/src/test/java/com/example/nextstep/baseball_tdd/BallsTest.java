package com.example.nextstep.baseball_tdd;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class BallsTest {

    @Test
    void 널로_초기화() {
        assertThatThrownBy(() -> new Balls(null))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("balls is null");
    }

    @Test
    void 공_두개() {
        assertThatThrownBy(
                () -> new Balls(Arrays.asList(
                        new Ball(new Number(1), new Position(1)),
                        new Ball(new Number(2), new Position(2))
                )))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("invalid balls size : 2");
    }

    @Test
    void 중복되는_수_있음() {
        assertThatThrownBy(
                () -> new Balls(Arrays.asList(
                        new Ball(new Number(1), new Position(1)),
                        new Ball(new Number(2), new Position(2)),
                        new Ball(new Number(1), new Position(3))
                )))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("duplicate ball number");
    }
}
