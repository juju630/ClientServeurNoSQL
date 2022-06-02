package clientServeur.Licence.controller;


import clientServeur.Licence.dto.Competition_Dto;
import clientServeur.Licence.model.Competition;
import clientServeur.Licence.model.Pilote;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import clientServeur.Licence.service.Competition_Service;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/competition")
public class Competition_Controller {

    @Autowired
    private Competition_Service competition_service;

    @GetMapping("/")
    public List<Competition_Dto> findAll(){
        try{
            ArrayList<Competition_Dto> competition_dtoArrayList = new ArrayList<>();
            for (Competition competition : competition_service.findAll()){
                competition_dtoArrayList.add(new Competition_Dto(competition));
            }
            return competition_dtoArrayList;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/{id}")
    public Competition_Dto findById(@PathVariable String id){
        try{
            return new Competition_Dto(competition_service.findById(new ObjectId(id)));
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/nom/{name}")
    public List<Competition_Dto> findAllByName(@PathVariable String name){
        try{
            List<Competition_Dto> competition_dtoArrayList = new ArrayList<>();
            for (Competition competition : competition_service.findAllByName(name)){
                competition_dtoArrayList.add(new Competition_Dto(competition));
            }
            return competition_dtoArrayList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/annee/{annee}")
    public List<Competition_Dto> findByAnnee(@PathVariable Integer annee){
        try{
            List<Competition_Dto> competition_dtoArrayList = new ArrayList<>();
            for (Competition competition : competition_service.findByAnnee(annee)){
                competition_dtoArrayList.add(new Competition_Dto(competition));
            }
            return competition_dtoArrayList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/create/{nom}/{annee}")
    public void createCompetition(@PathVariable String nom, @PathVariable Integer annee){
        competition_service.create(nom, annee, null);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePilote(@PathVariable ObjectId id){
        competition_service.delete(competition_service.findById(id));
    }

    @PutMapping("/update/{id}")
    public void updatePilote(@PathVariable ObjectId id, @RequestBody Competition competition){
        competition_service.update(id, competition);
    }

    @PutMapping("/setPodium/{id}")
    public void addPilote(@PathVariable ObjectId id, @RequestBody List<Pilote> pilotes){
        competition_service.setPoduim(id, pilotes.get(0), pilotes.get(1), pilotes.get(2));
    }
}
