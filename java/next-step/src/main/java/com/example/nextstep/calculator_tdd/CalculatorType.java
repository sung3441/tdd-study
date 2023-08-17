package com.example.nextstep.calculator_tdd;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum CalculatorType {
    ADD("+", (num1, num2) -> num1 + num2),
    SUB("-", (num1, num2) -> num1 - num2),
    MUL("*", (num1, num2) -> num1 * num2),
    DIV("/", (num1, num2) -> num1 / num2);

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> function;

    CalculatorType(String symbol, BiFunction<Integer, Integer, Integer> function) {
        this.symbol = symbol;
        this.function = function;
    }

    public int calculate(int num1, int num2) {
        if (this == DIV && num2 == 0) {
            throw new RuntimeException("0으로 나눌 수 없습니다.");
        }
        return function.apply(num1, num2);
    }

    public static CalculatorType getCalculatorType(String expression) {
        return Arrays.stream(CalculatorType.values())
                .filter(c -> c.symbol.equals(expression))
                .findAny()
                .orElseThrow(RuntimeException::new);
    }
}
