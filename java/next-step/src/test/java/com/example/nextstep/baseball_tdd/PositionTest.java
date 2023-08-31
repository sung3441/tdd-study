package com.example.nextstep.baseball_tdd;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 유효한_포지션(int number) {
        Position position = new Position(number);
        assertThat(position.value).isEqualTo(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 4})
    void 유효하지_않은_포지션(int number) {
        assertThatThrownBy(() -> new Position(number))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(String.format("invalid position : %d", number));
    }
}
