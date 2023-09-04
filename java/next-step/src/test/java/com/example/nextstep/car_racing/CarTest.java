package com.example.nextstep.car_racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    void 이름_5글자_초과() {
        assertThatThrownBy(() -> new Car("일이삼사오육"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("The name can be up to 5 characters long : 일이삼사오육");
    }

    @Test
    void 이름_공백_NULL() {
        assertThatThrownBy(() -> new Car(null))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("The name is null or empty");

        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("The name is null or empty");
    }

    @Test
    void 초기상태_출력() {
        // given
        Car car = new Car("일이삼사오");

        // when
        String status = car.showCurrentStatus();

        // then
        assertThat(status).isEqualTo("일이삼사오 : -");
    }

    @Test
    void 전진x_상태_출력() {
        // given
        Car car = new Car("일이삼사오");

        // when
        car.move(1);

        // then
        assertThat(car.showCurrentStatus()).isEqualTo("일이삼사오 : -");
    }

    @Test
    void 한칸전진_상태_출력() {
        // given
        Car car = new Car("일이삼사오");

        // when
        car.move(4);

        // then
        assertThat(car.showCurrentStatus()).isEqualTo("일이삼사오 : --");
    }
}
