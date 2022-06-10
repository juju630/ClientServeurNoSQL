package clientServeur.Licence.dto;

import clientServeur.Licence.model.Pilote;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Pilote_Dto {

    private String id;
    private String nom;
    private Date dateNaissance;
    private String nationalite;

    public Pilote_Dto(Pilote pilote) {
        id = pilote.getId().toHexString();
        nom = pilote.getName();
        dateNaissance = pilote.getDateNaissance();
        nationalite = pilote.getNationalite();
    }
}
