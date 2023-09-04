package com.example.nextstep.car_racing;

import java.util.Scanner;

public class InputUtil {

    private final static Scanner sc = new Scanner(System.in);

    public static String inputCarNames() {
        PrintUtil.printInputCarNames();
        return sc.nextLine();
    }

    public static int inputTryCount() {
        PrintUtil.printInputTryCount();
        return Integer.parseInt(sc.nextLine());
    }
}
