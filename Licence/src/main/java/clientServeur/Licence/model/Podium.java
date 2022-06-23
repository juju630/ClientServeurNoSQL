package clientServeur.Licence.model;

import clientServeur.Licence.dto.Podium_Dto;
import lombok.Data;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Accessors
@Document(collection = "Podium")
public class Podium {
    @Id
    @MongoId
    private ObjectId id;

    @DBRef
    @Field(value = "premier")
    private Pilote premier;

    @DBRef
    @Field(value = "deuxieme")
    private Pilote deuxieme;

    @DBRef
    @Field(value = "troisieme")
    private Pilote troisieme;

    public Podium(Pilote premier, Pilote deuxieme, Pilote troisieme){
        this.premier = premier;
        this.deuxieme = deuxieme;
        this.troisieme = troisieme;
    }
    public Podium(){

    }

    public Podium(Podium_Dto podium_dto) {
        if(podium_dto.getPremier() != null)
            this.premier = new Pilote(podium_dto.getPremier());
        if(podium_dto.getDeuxieme() != null)
            this.deuxieme = new Pilote(podium_dto.getDeuxieme());
        if(podium_dto.getTroisieme() != null)
            this.troisieme = new Pilote(podium_dto.getTroisieme());
    }
}
