package com.example.nextstep.coordinate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RentCompanyTest {

    private static final String NEW_LIEN = System.getProperty("line.separator");

    @Test
    public void report() {
        /*
        차량별 연비는 다음과 같다.
            Sonata : 10km/리터
            Avante : 15km/리터
            K5 : 13km/리터
         */
        RentCompany company = RentCompany.create();
        company.addCar(new Sonata(150));
        company.addCar(new K5(260));
        company.addCar(new Sonata(120));
        company.addCar(new Avante(300));
        company.addCar(new K5(390));

        String report = company.generateReport();
        Assertions.assertThat(report).isEqualTo(
                "Sonata : 15리터" + NEW_LIEN +
                        "K5 : 20리터" + NEW_LIEN +
                        "Sonata : 12리터" + NEW_LIEN +
                        "Avante : 20리터" + NEW_LIEN +
                        "K5 : 30리터" + NEW_LIEN
        );
    }
}
