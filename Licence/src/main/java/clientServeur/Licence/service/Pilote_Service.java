package clientServeur.Licence.service;

import clientServeur.Licence.model.Pilote;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import clientServeur.Licence.repository.Pilote_Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class Pilote_Service {

    @Autowired
    private Pilote_Repository pilote_repository;

    public Pilote findById(ObjectId id) {
        Optional<Pilote> optionalPilote;
        optionalPilote =  pilote_repository.findById(id);
        return optionalPilote.get();
    }

    public List<Pilote> findAll() {
        List<Pilote> piloteList;
        piloteList = pilote_repository.findAll();
        return piloteList;
    }

    public void create() {
        Pilote pilote = new Pilote("Defaut",new Date(),"Français");
        pilote_repository.save(pilote);
    }

    public List<Pilote> findAllByNationalite(String nationalite) {
        List<Pilote> piloteList;
        piloteList = pilote_repository.findByNationalite(nationalite);
        return  piloteList;
    }
}
