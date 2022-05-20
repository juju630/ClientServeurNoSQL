package clientServeur.Licence.dto;

import clientServeur.Licence.model.Pilote;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@AllArgsConstructor
@Getter
@Setter
public class Pilote_Dto {

    private String id;
    private String name;
    private Date dateNaissance;
    private String nationalite;

    public Pilote_Dto() {
    }

    public Pilote_Dto(Pilote pilote) {
        id = pilote.getId().toHexString();
        name = pilote.getName();
        dateNaissance = pilote.getDateNaissance();
        nationalite = pilote.getNationalite();
    }
}
