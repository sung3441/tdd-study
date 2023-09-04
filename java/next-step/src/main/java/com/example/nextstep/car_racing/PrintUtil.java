package com.example.nextstep.car_racing;

public class PrintUtil {

    public static void printInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분.");
    }

    public static void printInputTryCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
    }

    public static void printMoveResult() {
        System.out.println("실행 결과");
    }

    public static void printWinnerResult(String[] winners) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < winners.length; i++) {
            sb.append(winners[i]);
            if (i != winners.length - 1) {
                sb.append(", ");
            }
        }
        System.out.println(sb.append("가 최종 우승 했습니다."));
    }

    public static void print(String string) {
        System.out.println(string);
    }
}
