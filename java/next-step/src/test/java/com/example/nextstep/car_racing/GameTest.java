package com.example.nextstep.car_racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    void 한명_완주() {
        // given
        Game game = new Game();

        // when
        String[] winners = game.play();
    }
}
