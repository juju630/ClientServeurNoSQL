package clientServeur.Licence.dto;

import clientServeur.Licence.model.Competition;
import clientServeur.Licence.model.Podium;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Field;

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
    private String type;
    private int edition;
    private String organisateur;

    public Competition_Dto(Competition competition) {
        id = competition.getId().toHexString();
        nom = competition.getName();
        annee = competition.getAnnee();
        type = competition.getType();
        edition = competition.getEdition();;
        organisateur = competition.getOrganisateur();
        if (competition.getPodium() != null){
            podium = new Podium_Dto(competition.getPodium());
        } else {
            podium = null;
        }
    }
}

