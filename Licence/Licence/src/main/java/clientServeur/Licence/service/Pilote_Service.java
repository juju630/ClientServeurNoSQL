package clientServeur.Licence.service;

import clientServeur.Licence.exception.ItemNotFoundException;
import clientServeur.Licence.model.Pilote;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import clientServeur.Licence.repository.Pilote_Repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class Pilote_Service {

    @Autowired
    private Pilote_Repository pilote_repository;

    public List<Pilote> findAll() {
        List<Pilote> piloteList;
        piloteList = pilote_repository.findAll();
        return piloteList;
    }

    public Pilote findById(ObjectId id) throws ItemNotFoundException{
        Optional<Pilote> optionalPilote;
        optionalPilote =  pilote_repository.findById(id);
        if(optionalPilote.isEmpty()){
            throw new ItemNotFoundException();
        }
        return optionalPilote.get();
    }

    public List<Pilote> findAllByNationalite(String nationalite) {
        return pilote_repository.findByNationalite(nationalite);
    }

    public List<Pilote> findAllByAfterDateNaissance(Date dateNaissance) {
        return pilote_repository.findByDateNaissanceAfter(dateNaissance);
    }

    public void create(Pilote pilote) {
        if(pilote.getName() != null || !pilote.getName().isEmpty()){
            pilote_repository.save(pilote);
        }else{
            pilote_repository.save(new Pilote("Defaut",new Date(),"Français"));
        }
    }

    public void delete(Pilote pilote){
        pilote_repository.delete(pilote);
    }

    public void update(ObjectId id, Pilote newPilote){
        pilote_repository.findById(id)
                .map(pilote -> {
                    pilote.setName(newPilote.getName());
                    pilote.setNationalite(newPilote.getNationalite());
                    pilote.setDateNaissance(newPilote.getDateNaissance());
                    return pilote_repository.save(pilote);
                })
                .orElseGet(() -> {
                    newPilote.setId(id);
                    return pilote_repository.save(newPilote);
                });
    }
}
