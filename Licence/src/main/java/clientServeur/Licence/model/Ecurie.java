package clientServeur.Licence.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;
import java.util.List;

@Data
@Accessors
@Document(collection = "Ecurie")
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
    private List<Pilote> pilotes;

    public Ecurie(String name, String lieu, String nationalite, List<Pilote> pilotes) {
        this.name = name;
        this.lieu = lieu;
        this.nationalite = nationalite;
        this.pilotes = pilotes;
    }

    public Ecurie() {
    }
}
