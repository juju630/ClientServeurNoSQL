package clientServeur.Licence.repository;

import clientServeur.Licence.model.Competition;
import clientServeur.Licence.model.Pilote;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface Pilote_Repository extends MongoRepository<Pilote, ObjectId> {

    @Query("{_id:'?0'}")
    Optional<Pilote> findById(ObjectId id);

    @Query("{nationalite:'?0'}")
    List<Pilote> findByNationalite(String nationalite);

    List<Pilote> findByName(String name);

    List<Pilote> findByDateNaissanceAfter(Date dateNaissance);

}
