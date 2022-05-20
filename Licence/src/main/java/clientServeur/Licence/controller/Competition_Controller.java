package clientServeur.Licence.controller;


import clientServeur.Licence.dto.Competition_Dto;
import clientServeur.Licence.model.Competition;
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

    @PostMapping("/")
    public void createCompetition(){
        competition_service.create();
    }
}
