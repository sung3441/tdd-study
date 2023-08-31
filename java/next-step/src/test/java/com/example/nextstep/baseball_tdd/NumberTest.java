package com.example.nextstep.baseball_tdd;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 9})
    void 유효한_숫자(int num) {
        assertThat(new Number(num).value).isEqualTo(num);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void 유효하지_않은_숫자(int num) {
        assertThatThrownBy(() -> new Number(num))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(String.format("invalid number : %d", num));
    }
}
