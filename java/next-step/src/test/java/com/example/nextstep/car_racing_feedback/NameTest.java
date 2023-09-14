package com.example.nextstep.car_racing_feedback;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class NameTest {

    @Test
    void 이름_null_empty() {
        assertThatThrownBy(() -> new Name(null))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("이름은 null 또는 공백일 수 없습니다.");

        assertThatThrownBy(() -> new Name(""))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("이름은 null 또는 공백일 수 없습니다.");

    }

    @Test
    void 이름_5자_초과() {
        assertThatThrownBy(() -> new Name("123456"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    void 정상생성() {
        Name name = new Name("il");

        assertThat(name.getName()).isEqualTo("il");
    }
}
