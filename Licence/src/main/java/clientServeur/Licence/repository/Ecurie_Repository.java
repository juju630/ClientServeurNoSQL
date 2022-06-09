package clientServeur.Licence.repository;

import clientServeur.Licence.model.Competition;
import clientServeur.Licence.model.Ecurie;
import clientServeur.Licence.model.Pilote;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface Ecurie_Repository extends MongoRepository<Ecurie, ObjectId> {
    @Query("{_id:'?0'}")
    Optional<Ecurie> findById(ObjectId id);

    List<Ecurie> findByNationalite(String nationalite);

    Ecurie findByName(String name);

    @Query("{lieu:'?0'}")
    List<Ecurie> findByLieu(String lieu);
}
