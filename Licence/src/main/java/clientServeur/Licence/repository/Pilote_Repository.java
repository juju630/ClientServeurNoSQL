package clientServeur.Licence.repository;

import clientServeur.Licence.model.Pilote;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;


public interface Pilote_Repository extends MongoRepository<Pilote, ObjectId> {

    @Query("{_id:'?0'}")
    public Optional<Pilote> findById(ObjectId id);
}
