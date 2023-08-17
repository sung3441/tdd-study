package com.example.nextstep.baseball1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;

public class StringUtil {

    public static String randomStringNumber(int length) {
        HashSet<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        while (set.size() < length) {
            set.add((int) (Math.random() * 10));
        }

        for (Integer number : set) {
            sb.append(number);
        }

        return sb.toString();
    }

    public static boolean isStringNumber(String str) {
        return Pattern.compile("-?\\d+(\\.\\d+)?")
                .matcher(str)
                .matches();
    }

    public static boolean duplicate(String str) {
        HashSet<String> set = new HashSet<>(Arrays.asList(str.split("")));
        return str.length() != set.size();
    }
}
