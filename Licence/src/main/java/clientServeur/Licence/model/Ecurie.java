package clientServeur.Licence.model;

import clientServeur.Licence.dto.Ecurie_Dto;
import lombok.Data;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Accessors
@Document(collection = "Ecurie")
@CompoundIndex(def = "{'lieu':1, 'nationalite':1}", name = "compound_index")
public class Ecurie {

    @Id
    @MongoId
    private ObjectId id;

    @Field(value = "name")
    private String name;
    @Field(value = "lieu")
    private String lieu;
    @Field(value = "nationalite")
    private String nationalite;
    @Field(value = "pilotes")
    @DBRef
    private List<Pilote> pilotes;

    public Ecurie(String name, String lieu, String nationalite, List<Pilote> pilotes) {
        this.name = name;
        this.lieu = lieu;
        this.nationalite = nationalite;
        this.pilotes = pilotes;
    }

    public Ecurie() {
    }

    public Ecurie(Ecurie_Dto ecurie_dto){
        this.name = ecurie_dto.getNom();
        this.lieu = ecurie_dto.getLieu();
        this.nationalite = ecurie_dto.getNationalite();
        if(ecurie_dto.getPilotes() != null)
            this.pilotes = ecurie_dto.getPilotes().stream().map(Pilote::new).collect(Collectors.toList());
    }
}
