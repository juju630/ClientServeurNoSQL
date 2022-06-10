package clientServeur.Licence.model.QueryAggregation;

import clientServeur.Licence.dto.QueryAggregation.Pilote_Count_Nationalite_Dto;
import lombok.Data;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;

@Data
@Accessors
public class Pilote_Count_Nationalite {

    private ObjectId id;
    private Integer numberOfPilote;

    public Pilote_Count_Nationalite() {
    }

    public Pilote_Count_Nationalite(Pilote_Count_Nationalite_Dto pilote_count_nationalite_dto) {
        this.id = new ObjectId(pilote_count_nationalite_dto.getId());
        this.numberOfPilote = pilote_count_nationalite_dto.getNumberOfPilote();
    }

}
