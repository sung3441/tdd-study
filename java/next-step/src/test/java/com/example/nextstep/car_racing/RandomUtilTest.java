package com.example.nextstep.car_racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomUtilTest {

    @Test
    void 랜덤생성() {

        for (int i = 0; i < 10; i++) {
            Assertions.assertThat(RandomUtil.createRandom()).isBetween(1, 9);
        }
    }
}
