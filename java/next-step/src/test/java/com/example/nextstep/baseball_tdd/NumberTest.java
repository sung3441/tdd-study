package com.example.nextstep.baseball_tdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {

    @Test
    void 유효한_숫자() {
        Number number1 = new Number(1);
        Number number9 = new Number(9);

        assertThat(number1.getNumber()).isEqualTo(1);
        assertThat(number9.getNumber()).isEqualTo(9);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void 유효하지_않은_숫자(int num) {
        assertThatThrownBy(() -> new Number(num))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(String.format("invalid number : %d", num));
    }
}
