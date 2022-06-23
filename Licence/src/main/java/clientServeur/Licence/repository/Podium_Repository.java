package clientServeur.Licence.repository;

import clientServeur.Licence.model.Podium;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Podium_Repository  extends MongoRepository<Podium, ObjectId> {


}
