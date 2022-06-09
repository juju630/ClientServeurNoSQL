package clientServeur.Licence.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;

@Getter
@Setter
@ToString
public class Podium {
    private String premier;
    private String deuxieme;
    private String troisieme;

    public Podium(String premier, String deuxieme, String troisieme){
        this.premier = premier;
        this.deuxieme = deuxieme;
        this.troisieme = troisieme;
    }
    public Podium(){

    }
}
