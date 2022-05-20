package clientServeur.Licence.controller;


import clientServeur.Licence.dto.Pilote_Dto;
import clientServeur.Licence.exception.InternalErrorException;
import clientServeur.Licence.exception.ItemNotFoundException;
import clientServeur.Licence.model.Pilote;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import clientServeur.Licence.service.Pilote_Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/pilote")
public class Pilote_Controller {

    @Autowired
    private Pilote_Service pilote_service;

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
            throw new InternalErrorException();
        }
    }

    @GetMapping("/{id}")
    public Pilote_Dto findByID(@PathVariable String id){
        try{
            return new Pilote_Dto(pilote_service.findById(new ObjectId(id)));
        }catch (ItemNotFoundException | IllegalArgumentException e){
            throw new ItemNotFoundException();
        }catch (Exception e){
            e.printStackTrace();
            throw new InternalErrorException();
        }
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
            throw new InternalErrorException();
        }
    }

    @GetMapping("/naissance/{annee}")
    public List<Pilote_Dto> findAllByDateNaissance(@RequestParam int annee){
        try{
            int mois = 05;
            int jour = 12;
            Date dateNaissance = new Date(annee-1900,mois,jour);
            ArrayList<Pilote_Dto> pilote_dtoArrayList = new ArrayList<>();

            for (Pilote pilote : pilote_service.findAllByAfterDateNaissance(dateNaissance)){
                pilote_dtoArrayList.add(new Pilote_Dto(pilote));
            }
            return  pilote_dtoArrayList;
        }catch (Exception e){
            e.printStackTrace();
            throw new InternalErrorException();
        }
    }



    /*@PostMapping("/create/{nom}/{annee}/{mois}/{jour}/{nationalite}")
    public void createPilote(@RequestParam String nom, @RequestParam int annee,@RequestParam int mois,@RequestParam int jour, @RequestParam String nationalite){
        try{
            Date dateNaissance = new Date(annee-1900,mois,jour);
            pilote_service.create(nom, dateNaissance, nationalite);
        }catch (Exception e){
            e.printStackTrace();
            throw new InternalErrorException();
        }
    }*/
    @PostMapping("/")
    public void createPilote(){
        try{
            pilote_service.create();
        }catch (Exception e){
            e.printStackTrace();
            throw new InternalErrorException();
        }
    }
}
