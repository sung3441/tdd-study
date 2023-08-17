package com.example.nextstep.calculator;

import java.util.Arrays;

public class StringCalculator {

    int result = 0;
    
    public int calculate(String expression) {

        if (invalidExpression(expression)) {
            throw new RuntimeException(String.format("유효하지 않은 식입니다. : %s", expression));
        }

        String[] expressions = expression.split(" ");
        String[] operators = Arrays.stream(expressions)
                .filter("+-*/"::contains)
                .toArray(String[]::new);

        int[] numbers = Arrays.stream(expressions)
                .filter(s -> Character.isDigit(s.charAt(0)))
                .mapToInt(Integer::parseInt)
                .toArray();

        result = numbers[0];
        for (int i = 0; i < operators.length; i++) {
            result = Calculator.generatorCalculator(operators[i])
                    .calculate(result, numbers[i + 1]);
        }

        return result;
    }

    public boolean invalidExpression(String expression) {
        if (expression == null || expression.isEmpty()) {
            return false;
        }

        String pattern = "^\\d+(\\s+[+\\-*/]\\s+\\d+)*$";

        return !expression.matches(pattern);
    }
}
