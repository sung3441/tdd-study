package com.example.nextstep.string_add_calculator;

import org.junit.jupiter.api.Test;

import static com.example.nextstep.string_add_calculator.StringAddCalculator.*;
import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    void 빈문자열_또는_null입력() {
        int result = calculate("");
        assertThat(result).isEqualTo(0);

        result = calculate(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 숫자_하나() {
        int result = calculate("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 쉼표_구분자() {
        int result = calculate("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 콜론_구분자() {
        int result = calculate("1:2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 쉼표_또는_콜론_구분자() {
        int result = calculate("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 사용자정의_구분자_언더바() {
        int result = calculate("//_\n1_2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 사용자정의_구분자_물음표() {
        int result = calculate("//?\n1?2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 음수_하나() {
        assertThatThrownBy(() -> calculate("-1"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("-1 is negative");
    }

    @Test
    void 음수_쉼표_구분자() {
        assertThatThrownBy(() -> calculate("1,-1"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("-1 is negative");
    }

    @Test
    void 음수_사용자정의_구분자() {
        assertThatThrownBy(() -> calculate("//_\n10_-10"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("-10 is negative");
    }
}
