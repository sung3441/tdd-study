package com.example.nextstep.baseball_tdd;

public class Position {

    private final int position;

    public Position(final int position) {
        if (position < 1 || position > 3) {
            throw new RuntimeException(String.format("invalid position : %d", position));
        }
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
