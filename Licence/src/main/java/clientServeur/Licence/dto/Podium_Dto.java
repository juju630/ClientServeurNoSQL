package clientServeur.Licence.dto;

import clientServeur.Licence.model.Podium;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Podium_Dto {

    private String id;
    private Pilote_Dto premier;
    private Pilote_Dto deuxieme;
    private Pilote_Dto troisieme;

    public Podium_Dto(Podium podium) {
        if(podium.getId() != null) {
            this.id = podium.getId().toHexString();
            if (podium.getPremier() != null) {
                premier = new Pilote_Dto(podium.getPremier());
            } else {
                premier = null;
            }
            if (podium.getDeuxieme() != null) {
                deuxieme = new Pilote_Dto(podium.getDeuxieme());
            } else {
                deuxieme = null;
            }
            if (podium.getTroisieme() != null) {
                troisieme = new Pilote_Dto(podium.getTroisieme());
            } else {
                troisieme = null;
            }
        }
    }
}
