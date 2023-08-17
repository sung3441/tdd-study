package com.example.nextstep.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {

    StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"2 * 1 + 10:12", "1 + 1:2", "10 / 10 * 10:10"}, delimiter = ':')
    void string_calculator(String expression, int result) {
        assertThat(stringCalculator.calculate(expression)).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2* 1 + 10", "1++", "+ 1 + 1"})
    void string_calculator_invalid(String expression) {
        assertThrows(RuntimeException.class, () -> stringCalculator.calculate(expression));
    }


    @AfterEach
    void finish() {
        stringCalculator = null;
    }
}
