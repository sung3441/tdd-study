package com.example.nextstep.car_racing_feedback;

import java.util.Objects;

public class Name {

    private final static int MAX_NAME = 5;

    private final String name;

    public Name(String name) {
        if (Objects.isNull(name) || name.isEmpty()) {
            throw new RuntimeException("이름은 null 또는 공백일 수 없습니다.");
        }

        if (name.length() > MAX_NAME) {
            throw new RuntimeException("이름은 5자를 초과할 수 없습니다.");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
