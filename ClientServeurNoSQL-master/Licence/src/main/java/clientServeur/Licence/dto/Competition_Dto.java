package clientServeur.Licence.dto;

import clientServeur.Licence.model.Competition;
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
    private String name;
    private Integer annee;
    private List<Pilote_Dto> podium;

    public Competition_Dto(Competition competition) {
        id = competition.getId().toHexString();
        name = competition.getName();
        annee = competition.getAnnee();
        if (competition.getPodium() != null){
            podium = competition.getPodium().stream().map(Pilote_Dto::new).collect(Collectors.toList());
        } else {
            podium = null;
        }
    }
}
