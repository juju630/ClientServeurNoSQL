package clientServeur.Licence.service;

import clientServeur.Licence.dto.Competition_Dto;
import clientServeur.Licence.dto.Pilote_Dto;
import clientServeur.Licence.dto.Podium_Dto;
import clientServeur.Licence.model.Competition;
import clientServeur.Licence.model.Pilote;
import clientServeur.Licence.model.Podium;
import clientServeur.Licence.repository.Competition_Repository;
import clientServeur.Licence.repository.Pilote_Repository;
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
    @Autowired
    private Pilote_Repository pilote_repository;
    @Autowired
    private Podium_Service podium_service;


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

    public void create(Competition_Dto competition_dto){
        if(competition_dto.getNom() != null || !competition_dto.getNom().isEmpty()){
            
            if(competition_dto.getOrganisateur() == null){
                competition_dto.setType("F2");
            }else{
                competition_dto.setType("F1");
            }
            competition_repository.save(new Competition(competition_dto));
        }else{
            competition_repository.save(new Competition("a", 2022, null, null, 0, null));
        }
    }

    public void delete(Competition competition){
        competition_repository.delete(competition);
    }

    public void update(ObjectId id, Competition newCompetition){
        competition_repository.findById(id)
                .map(competition -> {
                    if(newCompetition.getName() != null){
                        competition.setName(newCompetition.getName());
                    }
                    if(newCompetition.getAnnee() != null){
                        competition.setAnnee(newCompetition.getAnnee());
                    }
                    if(newCompetition.getPodium() != null){
                        competition.setPodium(newCompetition.getPodium());
                    }
                    return competition_repository.save(competition);
                })
                .orElseGet(() -> {
                    //newCompetition.setId(id);
                    return competition_repository.save(newCompetition);
                });
    }

    public void setPoduim(ObjectId id, String idP){
        competition_repository.findById(id)
                .map(competition -> {
                    competition.setPodium(podium_service.findById(idP));
                    return competition_repository.save(competition);
                });
    }
}
