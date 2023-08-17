package com.example.nextstep.calculator_tdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTypeTest {

    @ParameterizedTest
    @CsvSource(value = {"3:7:10", "0:0:0", "1:0:1"}, delimiter = ':')
    void add(int num1, int num2, int result) {
        assertThat(CalculatorType.ADD.calculate(num1, num2)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:7:-4", "0:0:0", "1:0:1"}, delimiter = ':')
    void sub(int num1, int num2, int result) {
        assertThat(CalculatorType.SUB.calculate(num1 , num2)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:7:21", "0:0:0", "1:0:0", "-1:-1:1"}, delimiter = ':')
    void mul(int num1, int num2, int result) {
        assertThat(CalculatorType.MUL.calculate(num1 , num2)).isEqualTo(result);
    }

    @Test
    void symbol_to_calculator_type() {
        assertThat(CalculatorType.getCalculatorType("+")).isEqualTo(CalculatorType.ADD);
        assertThat(CalculatorType.getCalculatorType("-")).isEqualTo(CalculatorType.SUB);
        assertThat(CalculatorType.getCalculatorType("*")).isEqualTo(CalculatorType.MUL);
        assertThat(CalculatorType.getCalculatorType("/")).isEqualTo(CalculatorType.DIV);
        assertThatThrownBy(() -> CalculatorType.getCalculatorType("^"));
    }
}
