package com.example.nextstep.string_add_calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    void 빈문자열_또는_null입력() {
        int result = StringAddCalculator.calculate("");
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.calculate(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 숫자_하나() {
        int result = StringAddCalculator.calculate("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 쉼표_구분자() {
        int result = StringAddCalculator.calculate("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 콜론_구분자() {
        int result = StringAddCalculator.calculate("1:2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 쉼표_또는_콜론_구분자() {
        int result = StringAddCalculator.calculate("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 사용자_정의_구분자() {
        int result = StringAddCalculator.calculate("//_\n1_2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 음수() {
        // TODO
    }
}
