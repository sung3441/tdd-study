package com.example.nextstep.baseball_tdd;

public class Position {

    public final int value;

    public Position(final int position) {
        if (position < 1 || position > 3) {
            throw new RuntimeException(String.format("invalid position : %d", position));
        }
        this.value = position;
    }
}
