package com.example.nextstep.baseball_tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BallsTest {

    @Test
    void 널로_초기화() {
        assertThatThrownBy(() -> new Balls((Ball) null))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("balls has null");
    }

    @Test
    void 공_두개() {
        assertThatThrownBy(
                () -> new Balls(
                        new Ball(new Number(1), new Position(1)),
                        new Ball(new Number(2), new Position(2))
                ))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("invalid balls size : 2");
    }

    @Test
    void 포지션_유효하지_않은_공() {
        assertThatThrownBy(
                () -> new Balls(
                        new Ball(new Number(1), new Position(1)),
                        new Ball(new Number(2), new Position(2)),
                        new Ball(new Number(4), new Position(2))
                ))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("invalid ball position : this[2], index[3]");
    }

    @Test
    void 중복되는_수_있음() {
        assertThatThrownBy(
                () -> new Balls(
                        new Ball(new Number(1), new Position(1)),
                        new Ball(new Number(2), new Position(2)),
                        new Ball(new Number(1), new Position(3))
                ))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("duplicate ball number");
    }

    @Test
    void 게임종료() {
        Balls computer = new Balls(
                new Ball(new Number(1), new Position(1)),
                new Ball(new Number(4), new Position(2)),
                new Ball(new Number(7), new Position(3))
        );

        Balls player = new Balls(
                new Ball(new Number(1), new Position(1)),
                new Ball(new Number(4), new Position(2)),
                new Ball(new Number(7), new Position(3))
        );

        BallResult result = computer.play(player);

        assertThat(result.print()).isEqualTo("게임 종료");
    }

    @Test
    void 낫싱() {
        Balls computer = new Balls(
                new Ball(new Number(1), new Position(1)),
                new Ball(new Number(4), new Position(2)),
                new Ball(new Number(7), new Position(3))
        );

        Balls player = new Balls(
                new Ball(new Number(3), new Position(1)),
                new Ball(new Number(5), new Position(2)),
                new Ball(new Number(8), new Position(3))
        );

        BallResult result = computer.play(player);

        assertThat(result.print()).isEqualTo("낫싱");
    }

    @Test
    void 스트라이크1_볼2() {
        Balls computer = new Balls(
                new Ball(new Number(1), new Position(1)),
                new Ball(new Number(4), new Position(2)),
                new Ball(new Number(7), new Position(3))
        );

        Balls player = new Balls(
                new Ball(new Number(1), new Position(1)),
                new Ball(new Number(7), new Position(2)),
                new Ball(new Number(4), new Position(3))
        );

        BallResult result = computer.play(player);

        assertThat(result.print()).isEqualTo("1 스트라이크 2 볼 ");
    }

    @Test
    void 볼3() {
        Balls computer = new Balls(
                new Ball(new Number(1), new Position(1)),
                new Ball(new Number(4), new Position(2)),
                new Ball(new Number(7), new Position(3))
        );

        Balls player = new Balls(
                new Ball(new Number(4), new Position(1)),
                new Ball(new Number(7), new Position(2)),
                new Ball(new Number(1), new Position(3))
        );

        BallResult result = computer.play(player);

        assertThat(result.print()).isEqualTo("3 볼 ");
    }
}
