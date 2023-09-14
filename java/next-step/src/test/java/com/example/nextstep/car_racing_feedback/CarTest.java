package com.example.nextstep.car_racing_feedback;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    Car 기본차;

    @BeforeEach
    void setup() {
        기본차 = new Car(
                new Name("test"),
                new Distance()
        );
    }

    @Test
    void 차_생성() {
        assertThat(기본차.getName()).isEqualTo("test");
        assertThat(기본차.getDistance()).isEqualTo(0);
    }

    @Test
    void 한칸_전진() {
        기본차.move(4);

        assertThat(기본차.getDistance()).isEqualTo(1);
    }

    @Test
    void 한칸_전진_실패() {
        기본차.move(3);

        assertThat(기본차.getDistance()).isEqualTo(0);
    }

    @Test
    void 현재_상태_출력() {
        String currentStatus = 기본차.getCurrentStatus();

        assertThat(currentStatus).isEqualTo("test : ");
    }

    @Test
    void 한칸_전진_상태_출력() {
        기본차.move(4);

        String currentStatus = 기본차.getCurrentStatus();

        assertThat(currentStatus).isEqualTo("test : -");
    }
}
