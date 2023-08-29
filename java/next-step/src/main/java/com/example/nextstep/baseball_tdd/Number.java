package com.example.nextstep.baseball_tdd;

public class Number {

    private final int number;

    public Number(final int number) {
        if (number < 1 || number > 9) {
            throw new RuntimeException(String.format("invalid number : %d", number));
        }
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
