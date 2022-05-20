package clientServeur.Licence.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@Data
@Accessors
@Document(collection = "Pilote")
public class Pilote {

    @Id
    @MongoId
    private ObjectId id;

    @Field(value = "name")
    private String name;
    @Field(value = "dateNaissance")
    private Date dateNaissance;
    @Field(value = "nationalite")
    private String nationalite;

    public Pilote(String name, Date dateNaissance, String nationalite) {
        this.name = name;
        this.dateNaissance = dateNaissance;
        this.nationalite = nationalite;
    }

    public Pilote() {
    }
}
