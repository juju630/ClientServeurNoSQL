package clientServeur.Licence.service;

import clientServeur.Licence.dto.Competition_Dto;
import clientServeur.Licence.dto.Pilote_Dto;
import clientServeur.Licence.model.Competition;
import clientServeur.Licence.model.Pilote;
import clientServeur.Licence.repository.Competition_Repository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public void create(Competition_Dto competition_dto, List<Pilote> podium){
        if(competition_dto.getNom() != null || !competition_dto.getNom().isEmpty()){
            if(podium == null){
                podium = new ArrayList<Pilote>();
            }
            competition_dto.setPodium(podium.stream().map(Pilote_Dto::new).collect(Collectors.toList()));
            competition_repository.save(new Competition(competition_dto));
        }else{
            competition_repository.save(new Competition("a", 2022, null));
        }
    }

    public void delete(Competition competition){
        competition_repository.delete(competition);
    }

    public void update(ObjectId id, Competition newCompetition){
        competition_repository.findById(id)
                .map(competition -> {
                    competition.setName(newCompetition.getName());
                    competition.setAnnee(newCompetition.getAnnee());
                    if(newCompetition.getPodium() != null){
                        competition.setPodium(newCompetition.getPodium());
                    }
                    return competition_repository.save(competition);
                })
                .orElseGet(() -> {
                    newCompetition.setId(id);
                    return competition_repository.save(newCompetition);
                });
    }

    public void setPoduim(ObjectId id, Pilote pilote1, Pilote pilote2, Pilote pilote3){
        competition_repository.findById(id)
                .map(competition -> {
                    competition.getPodium().clear();
                    competition.getPodium().add(pilote1);
                    competition.getPodium().add(pilote2);
                    competition.getPodium().add(pilote3);
                    return competition_repository.save(competition);
                });
    }
}
