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

    /**
     * @HTTP_Verb GET
     * @Example local : http://localhost:8080/competition/
     * @return Retourne la list complète de toutes les compétitions
     */
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

    /**
     * @HTTP_Verb GET
     * @Example Local : http://localhost:8080/competition/629859a76dee6a05ce365a10
     * @param id : ID de la competition recherchée
     * @return retourne la competition recherchée
     */
    @GetMapping("/{id}")
    public Competition_Dto findById(@PathVariable String id){
        try{
            return new Competition_Dto(competition_service.findById(new ObjectId(id)));
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @HTTP_Verb GET
     * @Example Local : http://localhost:8080/competition/nom/LeMans
     * @param name : Nom de la competition recherchée
     * @return Retourne la liste des compétitions recherchées avec le même nom.
     */
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

    /**
     * @HTTP_Verb GET
     * @Example Local : http://localhost:8080/competition/annee/2021
     * @param annee : Annee de recherche pour les competitions
     * @return Retourne la liste des competitions qui on eu lieu pendant l'année donnée.
     */
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

    /**
     * @HTTP_Verb POST
     * @Example Local : http://localhost:8080/competition/
     * @param competition_dto : Objet competition DTO passé dans les paramètres du Body
     */
    @PostMapping
    public void createCompetition(@RequestBody Competition_Dto competition_dto){
        competition_service.create(competition_dto);
    }

    /**
     * @HTTP_Verb POST
     * @Example Local : http://localhost:8080/competition/62986c830c858276ddfcead5
     * @param id : ID de la competition recherchée
     */
    @DeleteMapping("/{id}")
    public void deletePilote(@PathVariable ObjectId id){
        competition_service.delete(competition_service.findById(id));
    }

    /**
     * @HTTP_Verb PUT
     * @Example Local : http://localhost:8080/competition/62986c830c858276ddfcead5
     * @param id : ID de la competition recherchée
     */
    @PutMapping("/{id}")
    public void updatePilote(@PathVariable ObjectId id, @RequestBody Competition competition){
        competition_service.update(id, competition);
    }

    /**
     * @HTTP_Verb PUT
     * @Example Local : http://localhost:8080/competition/setPodium/62986c830c858276ddfcead5
     * @param id : ID de la competition recherchée
     */
    @PutMapping("/setPodium/{id}")
    public void addPilote(@PathVariable ObjectId id, @RequestBody List<ObjectId> pilotes){
        competition_service.setPoduim(id, pilotes.get(0), pilotes.get(1), pilotes.get(2));
    }
}
