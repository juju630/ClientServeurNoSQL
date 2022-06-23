package clientServeur.Licence.competition;

import clientServeur.Licence.dto.Competition_Dto;
import clientServeur.Licence.model.Competition;
import clientServeur.Licence.model.Podium;
import clientServeur.Licence.repository.Competition_Repository;
import clientServeur.Licence.service.Competition_Service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootTest
public class CompetitionTests {

    @Autowired
    private Competition_Service competition_service;

    @Test
    void testTypeF2() {
        Competition_Dto competition = new Competition_Dto();
        competition.setNom("Competition test F2");
        competition.setAnnee(2023);
        competition.setType(null);
        competition.setPodium(null);
        competition.setEdition(26);
        competition.setOrganisateur(null);
        competition_service.create(competition);
        ArrayList<Competition> liste = new ArrayList<Competition>(competition_service.findAllByName(competition.getNom()));
        for(Competition comp : liste){
            if(comp.getName().equals(competition.getNom()) && Objects.equals(competition.getAnnee(), competition.getAnnee())){
                Assert.isTrue(liste.get(0).getType().equals("F2"));
                competition_service.delete(comp);
            }
        }

    }

    @Test
    void testTypeF1() {
        Competition_Dto competition = new Competition_Dto();
        competition.setNom("Competition test F1");
        competition.setAnnee(2022);
        competition.setType(null);
        competition.setPodium(null);
        competition.setEdition(26);
        competition.setOrganisateur("un organisateur");
        competition_service.create(competition);
        ArrayList<Competition> liste = new ArrayList<Competition>(competition_service.findAllByName(competition.getNom()));
        for(Competition comp : liste){
            if(comp.getName().equals(competition.getNom()) && Objects.equals(competition.getAnnee(), competition.getAnnee())){
                Assert.isTrue(liste.get(0).getType().equals("F1"));
                competition_service.delete(comp);
            }
        }

    }


}
