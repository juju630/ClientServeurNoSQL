package clientServeur.Licence.dto;

import clientServeur.Licence.model.Competition;
import clientServeur.Licence.model.Podium;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Competition_Dto {

    private String id;
    private String nom;
    private Integer annee;
    private Podium_Dto podium;

    public Competition_Dto(Competition competition) {
        id = competition.getId().toHexString();
        nom = competition.getName();
        annee = competition.getAnnee();
        if (competition.getPodium() != null){
            podium = new Podium_Dto(competition.getPodium());
        } else {
            podium = null;
        }
    }
}

