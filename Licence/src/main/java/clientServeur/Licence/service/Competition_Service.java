package clientServeur.Licence.service;

import clientServeur.Licence.model.Competition;
import clientServeur.Licence.model.Pilote;
import clientServeur.Licence.repository.Competition_Repository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Competition_Service {

    @Autowired
    private Competition_Repository competition_repository;


    public List<Competition> findAll(){
        List<Competition> competitionList;
        competitionList = competition_repository.findAll();
        return competitionList;
    }

    public Competition findById(ObjectId id){
        Optional<Competition> optionalCompetition;
        optionalCompetition = competition_repository.findById(id);
        return optionalCompetition.get();
    }

    public List<Competition> findAllByName(String name){
        List<Competition> competitionList;
        competitionList = competition_repository.findByName(name);
        return competitionList;
    }

    public List<Competition> findByAnnee(Integer annee){
        List<Competition> competitionList;
        competitionList = competition_repository.findByAnnee(annee);
        return competitionList;
    }

    /*public void create(String nom, Integer annee, List<Pilote> podium){
        if(nom != null || !nom.isEmpty()){
            competition_repository.save(new Competition(nom, annee, podium));
        }else{
            competition_repository.save(new Competition("a", 2022, null));
        }
    }*/

    public void create(){
        competition_repository.save(new Competition("a", 2022, null));
    }
}
