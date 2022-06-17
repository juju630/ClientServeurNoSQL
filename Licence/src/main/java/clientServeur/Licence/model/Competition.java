package clientServeur.Licence.model;

import clientServeur.Licence.dto.Competition_Dto;
import lombok.Data;
import lombok.experimental.Accessors;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
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
    @Indexed(name = "annee_index", direction = IndexDirection.DESCENDING)
    @Field(value = "annee")
    private Integer annee;
    @DBRef
    @Field(value = "podium")
    private Podium podium;
    @Field(value = "type")
    private String type;
    @Field(value = "edition")
    private int edition;
    @Field(value = "organisateur")
    private String organisateur;


    public Competition(String name, Integer annee, Podium podium, String type, int edition, String organisateur) {
        this.name = name;
        this.annee = annee;
        this.podium = podium;
        this.type = type;
        this.edition = edition;
        this.organisateur = organisateur;
    }

    public Competition() {
    }

    public Competition(Competition_Dto competition_dto) {
        this.name = competition_dto.getNom();
        this.annee = competition_dto.getAnnee();
        this.podium = new Podium(competition_dto.getPodium());
        this.type = competition_dto.getType();
        this.edition = competition_dto.getEdition();;
        this.organisateur = competition_dto.getOrganisateur();
    }
}

    /**/
