package clientServeur.Licence.dto;

import clientServeur.Licence.model.Ecurie;
import clientServeur.Licence.model.Pilote;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Ecurie_Dto {

    private String id;
    private String nom;
    private String lieu;
    private String nationalite;
    private List<Pilote_Dto> pilotes;

    public Ecurie_Dto(Ecurie ecurie) {
        id = ecurie.getId().toHexString();
        nom = ecurie.getName();
        lieu = ecurie.getLieu();
        nationalite = ecurie.getNationalite();
        if (ecurie.getPilotes() != null){
            pilotes = ecurie.getPilotes().stream().map(Pilote_Dto::new).collect(Collectors.toList());
        } else {
            pilotes = null;
        }
    }
}
