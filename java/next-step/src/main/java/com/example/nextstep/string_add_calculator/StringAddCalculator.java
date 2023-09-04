package com.example.nextstep.string_add_calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int calculate(String text) {

        if (isNullOrEmpty(text)) {
            return 0;
        }

        return sum(splitBySeparator(text));
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            checkNegative(number);
            sum += number;
        }

        return sum;
    }

    private static int[] splitBySeparator(String text) {
        Pattern pattern = Pattern.compile("//(.)\n(.*)");
        Matcher matcher = pattern.matcher(text);
        String separator = "[:,]";
        if (matcher.find()) {
            text = matcher.group(2);
            separator = String.format("[%s]", matcher.group(1));
        }
        return map(text.split(separator));
    }

    private static int[] map(String[] strings) {
        return Arrays.stream(strings)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static void checkNegative(int number) {
        if (number < 0) {
            throw new RuntimeException(String.format("%d is negative", number));
        }
    }
}
