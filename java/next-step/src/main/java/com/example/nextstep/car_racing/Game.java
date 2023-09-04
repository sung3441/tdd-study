package com.example.nextstep.car_racing;

import static com.example.nextstep.car_racing.PrintUtil.*;

public class Game {

    private Cars cars;

    private int tryCount;

    public String[] play() {
        init();
        move();
        return rank();
    }

    private void init() {
        cars = new Cars(InputUtil.inputCarNames());
        tryCount = InputUtil.inputTryCount();
    }

    private void move() {
        PrintUtil.printMoveResult();
        for (int i = 0; i < tryCount; i++) {
            cars.moves();
            print(cars.showCurrentStatus());
        }
    }

    private String[] rank() {
        String[] winners = cars.getWinners(tryCount);
        PrintUtil.printWinnerResult(winners);
        return winners;
    }
}
