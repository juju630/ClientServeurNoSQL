package clientServeur.Licence.repository;

import clientServeur.Licence.model.Competition;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Competition_Repository extends MongoRepository<Competition,Long> {

}
