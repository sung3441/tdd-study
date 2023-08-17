package com.example.nextstep.calculator_tdd;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorCommandTest {

    @Test
    void add() {
        CalculatorCommand command = new CalculatorCommand(CalculatorType.ADD, 3, 1);
        Assertions.assertThat(command.calculate()).isEqualTo(4);
    }

    @Test
    void sub() {
        CalculatorCommand command = new CalculatorCommand(CalculatorType.SUB, 3, 1);
        Assertions.assertThat(command.calculate()).isEqualTo(2);
    }

    @Test
    void mul() {
        CalculatorCommand command = new CalculatorCommand(CalculatorType.MUL, 3, 1);
        Assertions.assertThat(command.calculate()).isEqualTo(3);
    }

    @Test
    void div() {
        CalculatorCommand command = new CalculatorCommand(CalculatorType.DIV, 3, 1);
        Assertions.assertThat(command.calculate()).isEqualTo(3);
    }
}
