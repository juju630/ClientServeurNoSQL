package clientServeur.Licence.repository;

import clientServeur.Licence.model.Competition;
import clientServeur.Licence.model.Pilote;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface Competition_Repository extends MongoRepository<Competition,ObjectId> {
    @Query("{_id:'?0'}")
    public Optional<Competition> findById(ObjectId id);

    List<Competition> findByName(String name);

    List<Competition> findByAnnee(Integer annee);


}
