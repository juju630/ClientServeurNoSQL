package clientServeur.Licence.controller;


import clientServeur.Licence.dto.Pilote_Dto;
import clientServeur.Licence.model.Pilote;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import clientServeur.Licence.service.Pilote_Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/pilote")
public class Pilote_Controller {

    @Autowired
    private Pilote_Service pilote_service;

    @GetMapping("/{id}")
    public Pilote_Dto findByID(@PathVariable String id){
        try{
            return new Pilote_Dto(pilote_service.findById(new ObjectId(id)));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/")
    public List<Pilote_Dto> findAll(){
        try{
            ArrayList<Pilote_Dto> pilote_dtoArrayList = new ArrayList<>();
            for (Pilote pilote : pilote_service.findAll()) {
                pilote_dtoArrayList.add(new Pilote_Dto(pilote));
            }
            return pilote_dtoArrayList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/nation/{nationalite}")
    public List<Pilote_Dto> findAllByNationalite(@PathVariable String nationalite){
        try{
            ArrayList<Pilote_Dto> pilote_dtoArrayList = new ArrayList<>();
            for (Pilote pilote : pilote_service.findAllByNationalite(nationalite)){
                pilote_dtoArrayList.add(new Pilote_Dto(pilote));
            }
            return  pilote_dtoArrayList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/naissance/{dateNaissance}")
    public List<Pilote_Dto> findAllByDateNaissance(@PathVariable Date dateNaissance){
        try{
            ArrayList<Pilote_Dto> pilote_dtoArrayList = new ArrayList<>();
            for (Pilote pilote : pilote_service.findAllByAfterDateNaissance(dateNaissance)){
                pilote_dtoArrayList.add(new Pilote_Dto(pilote));
            }
            return  pilote_dtoArrayList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }



    @PostMapping("/")
    public void createPilote(){
        pilote_service.create();
    }

}
