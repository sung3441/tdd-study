package com.example.nextstep.baseball_tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BallResultTest {

    @Test
    void 스트라이크2_볼1() {
        BallResult ballResult = new BallResult(2, 1);

        assertThat(ballResult.print()).isEqualTo("2 스트라이크 1 볼 ");
    }

    @Test
    void 볼3() {
        BallResult ballResult = new BallResult(0, 3);

        assertThat(ballResult.print()).isEqualTo("3 볼 ");
    }

    @Test
    void 스트라이크3() {
        BallResult ballResult = new BallResult(0, 3);

        assertThat(ballResult.print()).isEqualTo("3 볼 ");
    }

    @Test
    void 게임종료() {
        BallResult ballResult = new BallResult(3, 0);

        assertThat(ballResult.print()).isEqualTo("게임 종료");
    }

    @Test
    void 낫싱() {
        BallResult ballResult = new BallResult(0, 0);

        assertThat(ballResult.print()).isEqualTo("낫싱");
    }
}
