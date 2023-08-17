package com.example.nextstep.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"3:1:4", "1:5:6", "0:0:0", "8:9:17"}, delimiter = ':')
    void add(int num1, int num2, int result) {
        assertThat(Calculator.ADD.calculate(num1, num2)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:1:2", "1:5:-4", "0:0:0", "8:9:-1"}, delimiter = ':')
    void sub(int num1, int num2, int result) {
        assertThat(Calculator.SUB.calculate(num1, num2)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:2:6", "1:5:5", "0:0:0", "8:9:72"}, delimiter = ':')
    void mul(int num1, int num2, int result) {
        assertThat(Calculator.MUL.calculate(num1, num2)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"4:1:4", "10:2:5", "1:1:1", "0:1:0"}, delimiter = ':')
    void div(int num1, int num2, int result) {
        assertThat(Calculator.DIV.calculate(num1, num2)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"4:0", "10:0", "1:0"}, delimiter = ':')
    void div_zero(int num1, int num2) {
        assertThrows(RuntimeException.class, () -> Calculator.DIV.calculate(num1, num2));
    }
}