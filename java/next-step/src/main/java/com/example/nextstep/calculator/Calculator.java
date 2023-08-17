package com.example.nextstep.calculator;

import java.util.Arrays;

public enum Calculator {
    ADD("+") {
        @Override
        public int calculate(int a, int b) {
            return a + b;
        }
    },
    SUB("-") {
        @Override
        public int calculate(int a, int b) {
            return a - b;
        }
    },
    MUL("*") {
        @Override
        public int calculate(int a, int b) {
            return a * b;
        }
    },
    DIV("/") {
        @Override
        public int calculate(int a, int b) {
            if (b == 0) {
                throw new RuntimeException("0으로 나눌 수 없습니다.");
            }
            return a / b;
        }
    };

    Calculator(String type) {
        this.type = type;
    }

    private final String type;
    public abstract int calculate(int a, int b);
    public static Calculator generatorCalculator(String type) {
        return Arrays.stream(Calculator.values())
                .filter(c -> c.type.equals(type))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Unsupported type %s.", type)));
    }
}
