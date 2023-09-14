package com.example.nextstep.car_racing_feedback;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class DistanceTest {

    @Test
    void 생성() {
        Distance distance = new Distance();

        assertThat(distance.getDistance()).isEqualTo(0);
    }

    @Test
    void 거리_증가() {
        // given
        Distance distance = new Distance();

        // when
        distance.increment();

        // then
        assertThat(distance.getDistance()).isEqualTo(1);
    }
}
