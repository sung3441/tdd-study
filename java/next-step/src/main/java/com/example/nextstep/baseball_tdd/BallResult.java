package com.example.nextstep.baseball_tdd;

public class BallResult {

    private final int strikeCount;

    private final int ballCount;

    public BallResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public String print() {
        if (isOut()) {
            return "낫싱";
        }

        if (strikeCount == 3) {
            return "게임 종료";
        }

        String result = "";
        if (strikeCount != 0) {
            result += String.format("%d 스트라이크 ", strikeCount);
        }

        if (ballCount != 0) {
            result += String.format("%d 볼 ", ballCount);
        }

        return result;
    }

    private boolean isOut() {
        return strikeCount == 0 && ballCount == 0;
    }
}
