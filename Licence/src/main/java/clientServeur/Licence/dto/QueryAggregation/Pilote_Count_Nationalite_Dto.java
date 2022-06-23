package clientServeur.Licence.dto.QueryAggregation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Pilote_Count_Nationalite_Dto {

    private Integer numberOfPilote;
    private String nationalite;

}
