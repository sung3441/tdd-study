package com.example.nextstep.coordinate;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Nested
    class K5Test {

        private final static int PER_LITER = 13;

        @Test
        void 생성자() {
            K5 k5 = new K5(10);

            assertThat(k5.getName()).isEqualTo("K5");
            assertThat(k5.getTripDistance()).isEqualTo(10);
            assertThat(k5.getDistancePerLiter()).isEqualTo(PER_LITER);
            assertThat(k5.getChargeQuantity()).isEqualTo((double) 10 / PER_LITER);
        }
    }

    @Nested
    class SonataTest {

        private final static int PER_LITER = 10;

        @Test
        void 생성자() {
            Sonata sonata = new Sonata(10);

            assertThat(sonata.getName()).isEqualTo("Sonata");
            assertThat(sonata.getTripDistance()).isEqualTo(10);
            assertThat(sonata.getDistancePerLiter()).isEqualTo(PER_LITER);
            assertThat(sonata.getChargeQuantity()).isEqualTo((double) 10 / PER_LITER);
        }
    }

    @Nested
    class AvanteTest {

        private final static int PER_LITER = 15;

        @Test
        void 생성자() {
            Avante avante = new Avante(10);

            assertThat(avante.getName()).isEqualTo("Avante");
            assertThat(avante.getTripDistance()).isEqualTo(10);
            assertThat(avante.getDistancePerLiter()).isEqualTo(PER_LITER);
            assertThat(avante.getChargeQuantity()).isEqualTo((double) 10 / PER_LITER);
        }
    }
}
