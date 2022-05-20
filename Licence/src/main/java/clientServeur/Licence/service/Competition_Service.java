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

    public Competition findById(ObjectId id){
        Optional<Competition> optionalCompetition;
        optionalCompetition = competition_repository.findById(id);
        return optionalCompetition.get();
    }

    public List<Competition> findAll(){
        List<Competition> competitionList;
        competitionList = competition_repository.findAll();
        return competitionList;
    }

    public List<Competition> findByAnnee(Integer annee){
        List<Competition> competitionList;
        competitionList = competition_repository.findByAnnee(annee);
        return competitionList;
    }

    public void create(){
        Competition competition = new Competition("Default", 2022, null);
        competition_repository.save(competition);
    }
}
