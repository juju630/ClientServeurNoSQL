package clientServeur.Licence.service;

import clientServeur.Licence.dto.Ecurie_Dto;
import clientServeur.Licence.exception.ItemNotFoundException;
import clientServeur.Licence.model.Competition;
import clientServeur.Licence.model.Ecurie;
import clientServeur.Licence.model.Pilote;
import clientServeur.Licence.repository.Ecurie_Repository;
import clientServeur.Licence.repository.Pilote_Repository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Ecurie_Service {

    @Autowired
    private Ecurie_Repository ecurie_Repository;

    @Autowired
    private Pilote_Repository pilote_Repository;

    public Ecurie findById(ObjectId id){
        Optional<Ecurie> optionalEcurie;
        optionalEcurie = ecurie_Repository.findById(id);
        if(optionalEcurie.isEmpty()){
            throw new ItemNotFoundException();
        }
        return optionalEcurie.get();
    }

    public List<Ecurie> findAll(){
        List<Ecurie> ecurieList;
        ecurieList = ecurie_Repository.findAll();
        return ecurieList;
    }

    public Ecurie findByName(String name){
        Ecurie ecurie;
        ecurie = ecurie_Repository.findByName(name);
        return ecurie;
    }

    public List<Ecurie> findByNationalite(String nationalite){
        List<Ecurie> ecurieList;
        ecurieList = ecurie_Repository.findByNationalite(nationalite);
        return ecurieList;
    }

    public List<Ecurie> findByLieu(String lieu){
        List<Ecurie> ecurieList;
        ecurieList = ecurie_Repository.findByLieu(lieu);
        return ecurieList;
    }

    public void create(Ecurie ecurie, List<Pilote> pilotes){
        if(ecurie.getName() != null || !ecurie.getName().isEmpty()){
            if(pilotes == null){
                pilotes = new ArrayList<Pilote>();
            }
            ecurie.setPilotes(pilotes);
            ecurie_Repository.save(ecurie);
        }else{
            Ecurie ecurieDefault =
            ecurie_Repository.save(new Ecurie("ecurie1", "lieu1", "nationalite1", null));
        }
    }

    public void delete(Ecurie ecurie){
        ecurie_Repository.delete(ecurie);
    }

    public void update(ObjectId id, Ecurie newEcurie){
        ecurie_Repository.findById(id)
                .map(ecurie -> {
                    ecurie.setName(newEcurie.getName());
                    ecurie.setLieu(newEcurie.getLieu());
                    ecurie.setNationalite(newEcurie.getNationalite());
                    if(newEcurie.getPilotes() != null){
                        ecurie.setPilotes(newEcurie.getPilotes());
                    }
                    return ecurie_Repository.save(ecurie);
                })
                .orElseGet(() -> {
                    newEcurie.setId(id);
                    return ecurie_Repository.save(newEcurie);
                });
    }

    public void addPilote(ObjectId id, ObjectId idPilote){
        ecurie_Repository.findById(id)
                .map(ecurie -> {
                    ecurie.getPilotes().add(pilote_Repository.findById(idPilote).get());
                    return ecurie_Repository.save(ecurie);
                });
    }

}
