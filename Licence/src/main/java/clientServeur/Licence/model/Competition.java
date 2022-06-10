package clientServeur.Licence.model;

import clientServeur.Licence.dto.Competition_Dto;
import lombok.Data;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Accessors
@Document(collection = "Competition")
public class Competition {

    @Id
    @MongoId
    private ObjectId id;

    @Field(value = "name")
    private String name;
    @Field(value = "annee")
    private Integer annee;
    @DBRef
    @Field(value = "podium")
    private Podium podium;

    public Competition(String name, Integer annee, Podium podium) {
        this.name = name;
        this.annee = annee;
        this.podium = podium;
    }

    public Competition() {
    }

    public Competition(Competition_Dto competition_dto) {
        this.name = competition_dto.getNom();
        this.annee = competition_dto.getAnnee();
        this.podium = new Podium(competition_dto.getPodium());
    }
}

    /**/
