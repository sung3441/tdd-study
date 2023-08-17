package com.example.nextstep.baseball1;

import java.util.Scanner;

import static com.example.nextstep.baseball1.StringUtil.*;

public class Game {

    private boolean isFinished;

    private final int numberLength;

    private final Scanner sc;

    public Game(int numberLength) {
        this.isFinished = false;
        this.numberLength = numberLength;
        this.sc = new Scanner(System.in);
    }

    public void play() {
        String gameNumber = randomStringNumber(numberLength);
        while (!isFinished) {
            System.out.print("숫자를 입력해 주세요 : ");
            // 값 입력 받기
            String input = sc.next();

            // 입력 유효성 검사
            invalidInput(input);

            // 사용자가 입력한 값 Ball 객체로 생성
            Ball ball = new Ball(input, gameNumber);

            // 결과 출력
            ball.print();

            isFinished = ball.success();
        }
        // 성공 출력
        System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료%n", numberLength);
        System.out.println("게임을 새로 시작하려면 1,  종료하려면 2를 입력하세요.");

        // 입력 받기
        if (sc.nextInt() == 1) {
            restart();
            return;
        }
        close();
    }

    public void restart() {
        isFinished = false;
        play();
    }

    public void close() {
        sc.close();
    }

    public void invalidInput(String input) {
        if (!isStringNumber(input)) {
            throw new RuntimeException("숫자만 입력 가능합니다.");
        }
        if (input.length() != numberLength) {
            throw new RuntimeException(String.format("%d자리로 입력 해주세요.", numberLength));
        }
        if (duplicate(input)) {
            throw new RuntimeException("중복 되지 않은 수를 입력 해주세요.");
        }
    }

    public static void main(String[] args) {
        Game game = new Game(3);
        game.play();
    }
}
