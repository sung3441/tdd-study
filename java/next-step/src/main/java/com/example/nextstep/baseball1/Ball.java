package com.example.nextstep.baseball1;

public class Ball {

    private final String number;
    private int strikeCount = 0;
    private int ballCount = 0;

    public Ball(String number, String gameNumber) {
        this.number = number;
        stringToCount(gameNumber);
    }

    public void stringToCount(String gameNumber) {
        for (int i = 0; i < gameNumber.length(); i++) {
            count(gameNumber.charAt(i), i);
        }
    }

    public void count(char num, int numIndex) {
        int index = number.indexOf(String.valueOf(num));
        if (index == -1) {
            return;
        }

        if (index == numIndex) {
            increaseStrikeCount();
            return;
        }

        increaseBallCount();
    }

    public boolean isOut() {
        return strikeCount == 0 && ballCount == 0;
    }

    public boolean success() {
        return strikeCount == number.length();
    }

    public void print() {
        if (isOut()) {
            System.out.println("아웃입니다.");
            return;
        }
        System.out.println(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (ballCount != 0) {
            sb.append(ballCount).append("볼").append(" ");
        }
        if (strikeCount != 0) {
            sb.append(strikeCount).append("스트라이크");
        }
        return sb.toString();
    }

    public void increaseBallCount() {
        ballCount++;
    }

    public void increaseStrikeCount() {
        strikeCount++;
    }
}
