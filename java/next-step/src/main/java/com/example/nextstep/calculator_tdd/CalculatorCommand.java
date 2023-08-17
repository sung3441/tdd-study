package com.example.nextstep.calculator_tdd;

public class CalculatorCommand {

    private final CalculatorType calculatorType;
    private final int num1;
    private final int num2;

    public CalculatorCommand(CalculatorType calculatorType, int num1, int num2) {
        this.calculatorType = calculatorType;
        this.num1 = num1;
        this.num2 = num2;
    }

    public CalculatorType getCalculatorType() {
        return this.calculatorType;
    }

    public int calculate() {
        return calculatorType.calculate(num1, num2);
    }
}
