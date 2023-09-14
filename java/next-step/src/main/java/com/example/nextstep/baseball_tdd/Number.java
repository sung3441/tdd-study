package com.example.nextstep.baseball_tdd;

public class Number {

    public final int value;

    public Number(final int number) {
        if (number < 1 || number > 9) {
            throw new RuntimeException(String.format("invalid number : %d", number));
        }
        this.value = number;
    }

    public boolean isSame(Number number) {
        return value == number.value;
    }
}
