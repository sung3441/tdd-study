package com.example.nextstep.baseball_tdd;

public class BallResult {

    private int strikeCount = 0;

    private int ballCount = 0;

    private int gameCount = 0;

    public void increment(BallStatus ballStatus) {
        if (gameCount++ >= 3) {
            throw new RuntimeException("over ball count");
        }

        if (BallStatus.STRIKE.equals(ballStatus)) {
            strikeCount++;
        }

        if (BallStatus.BALL.equals(ballStatus)) {
            ballCount++;
        }
    }

    public String print() {
        if (gameCount < 3) {
            throw new RuntimeException(String.format("ball count lack : %d", gameCount));
        }

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
