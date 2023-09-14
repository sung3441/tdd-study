package com.example.nextstep.car_racing_feedback;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {

    @Test
    void 이름_공백() {
        assertThatThrownBy(() -> new Cars(""))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("이름은 null 또는 공백일 수 없습니다.");

        assertThatThrownBy(() -> new Cars(",car1"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("이름은 null 또는 공백일 수 없습니다.");
    }
}
