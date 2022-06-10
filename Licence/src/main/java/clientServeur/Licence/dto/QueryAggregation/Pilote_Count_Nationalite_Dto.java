package clientServeur.Licence.dto.QueryAggregation;

import clientServeur.Licence.model.QueryAggregation.Pilote_Count_Nationalite;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Pilote_Count_Nationalite_Dto {

    private String id;
    private Integer numberOfPilote;

    public Pilote_Count_Nationalite_Dto(Pilote_Count_Nationalite numberOfPiloteWithNationalite) {
        this.id = numberOfPiloteWithNationalite.getId().toHexString();
        this.numberOfPilote = numberOfPiloteWithNationalite.getNumberOfPilote();
    }
}
