package clientServeur.Licence.service;

import clientServeur.Licence.exception.ItemNotFoundException;
import clientServeur.Licence.model.Pilote;
import clientServeur.Licence.model.Podium;
import clientServeur.Licence.repository.Pilote_Repository;
import clientServeur.Licence.repository.Podium_Repository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Podium_Service {

    @Autowired
    Podium_Repository podium_repository;

    @Autowired
    Pilote_Service pilote_service;

    public List<Podium> findAll() {
        return podium_repository.findAll();
    }

    public Podium findById(String idP) {
        try{
            return podium_repository.findById(new ObjectId(idP)).get();
        }catch (Exception e){
            throw new ItemNotFoundException();
        }

    }

    public void create(Podium podium) {

        try{

            podium.setPremier(pilote_service.findByNom(podium.getPremier().getName()));
            podium.setDeuxieme(pilote_service.findByNom(podium.getDeuxieme().getName()));
            podium.setTroisieme(pilote_service.findByNom(podium.getTroisieme().getName()));

        }catch (Exception e){
            e.printStackTrace();
            throw new ItemNotFoundException();
        }
        podium_repository.save(podium);
    }


}
