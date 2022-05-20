package clientServeur.Licence.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;

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
    @Field(value = "podium")
    private ArrayList<Pilote> podium;

    public Competition(String name, Integer annee, ArrayList<Pilote> podium) {
        this.name = name;
        this.annee = annee;
        this.podium = podium;
    }

    public Competition() {
    }
}
