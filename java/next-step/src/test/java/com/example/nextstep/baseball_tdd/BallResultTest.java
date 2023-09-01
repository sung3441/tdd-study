package com.example.nextstep.baseball_tdd;

import org.junit.jupiter.api.Test;

import static com.example.nextstep.baseball_tdd.BallStatus.*;
import static org.assertj.core.api.Assertions.*;

public class BallResultTest {

    @Test
    void 공_너무_많이_던짐() {
        BallResult ballResult = new BallResult();
        ballResult.increment(BALL);
        ballResult.increment(BALL);
        ballResult.increment(BALL);

        assertThatThrownBy(() -> ballResult.increment(BALL))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("over ball count");
    }

    @Test
    void 공_덜던졌는데_print호출() {
        BallResult ballResult = new BallResult();
        ballResult.increment(BALL);
        ballResult.increment(BALL);

        assertThatThrownBy(ballResult::print)
                .isInstanceOf(RuntimeException.class)
                .hasMessage("ball count lack : 2");
    }

    @Test
    void 스트라이크2_볼1() {
        BallResult ballResult = new BallResult();
        ballResult.increment(STRIKE);
        ballResult.increment(STRIKE);
        ballResult.increment(BALL);

        assertThat(ballResult.print()).isEqualTo("2 스트라이크 1 볼 ");
    }

    @Test
    void 볼3() {
        BallResult ballResult = new BallResult();
        ballResult.increment(BALL);
        ballResult.increment(BALL);
        ballResult.increment(BALL);

        assertThat(ballResult.print()).isEqualTo("3 볼 ");
    }

    @Test
    void 스트라이크3() {
        BallResult ballResult = new BallResult();
        ballResult.increment(BALL);
        ballResult.increment(OUT);
        ballResult.increment(OUT);

        assertThat(ballResult.print()).isEqualTo("1 볼 ");
    }

    @Test
    void 게임종료() {
        BallResult ballResult = new BallResult();
        ballResult.increment(STRIKE);
        ballResult.increment(STRIKE);
        ballResult.increment(STRIKE);

        assertThat(ballResult.print()).isEqualTo("게임 종료");
    }

    @Test
    void 낫싱() {
        BallResult ballResult = new BallResult();
        ballResult.increment(OUT);
        ballResult.increment(OUT);
        ballResult.increment(OUT);

        assertThat(ballResult.print()).isEqualTo("낫싱");
    }
}
