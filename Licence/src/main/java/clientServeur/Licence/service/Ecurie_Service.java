package clientServeur.Licence.service;

import clientServeur.Licence.exception.ItemNotFoundException;
import clientServeur.Licence.model.Competition;
import clientServeur.Licence.model.Ecurie;
import clientServeur.Licence.model.Pilote;
import clientServeur.Licence.repository.Ecurie_Repository;
import clientServeur.Licence.repository.Pilote_Repository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Ecurie_Service {

    @Autowired
    private Ecurie_Repository ecurie_Repository;

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

    /*public void create(String nom, String lieu, String nationalite, List<Pilote> pilotes){
        if(nom != null || !nom.isEmpty()){
            ecurie_Repository.save(new Ecurie(nom, lieu, nationalite, pilotes));
        }else{
            Ecurie ecurie =
            ecurie_Repository.save(new Ecurie("ecurie1", "lieu1", "nationalite1", null));
        }
    }*/
    public void create(){
        ecurie_Repository.save(new Ecurie("ecurie1", "lieu1", "nationalite1", null));
    }
}
