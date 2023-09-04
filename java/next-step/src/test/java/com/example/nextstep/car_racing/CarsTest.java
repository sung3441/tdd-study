package com.example.nextstep.car_racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {

    @Test
    void 자동차_수량_2미만() {
        assertThatThrownBy(() -> new Cars("Car1"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("cars length must be at least 2 : 1");

        assertThatThrownBy(() -> new Cars("Car1,"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("cars length must be at least 2 : 1");

        assertThatThrownBy(() -> new Cars(","))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("cars length must be at least 2 : 0");
    }

    @Test
    void 자동차_하나_생성() {
        Cars cars = new Cars("Car1,Car2");

        assertThat(cars.length()).isEqualTo(2);
    }

    @Test
    void 자동차_이름길이_초과() {
        assertThatThrownBy(() -> new Cars("Car1,Cars11"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("The name can be up to 5 characters long : Cars11");
    }

    @Test
    void 자동차_이름_공백_NULL() {
        assertThatThrownBy(() -> new Cars(",Car1"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("The name is null or empty");
    }

    @Test
    void 자동차_세개_초기상태_출력() {
        Cars cars = new Cars("Car1,Car2,Car3");

        String status = cars.showCurrentStatus();

        assertThat(status).isEqualTo("Car1 : -\nCar2 : -\nCar3 : -\n");
    }
}
