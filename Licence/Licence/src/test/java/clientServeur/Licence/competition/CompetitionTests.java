package clientServeur.Licence.competition;

import clientServeur.Licence.service.Competition_Service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CompetitionTests {

    @Autowired
    private Competition_Service competition_service;

    @Test
    void contextLoads() {
    }


}
