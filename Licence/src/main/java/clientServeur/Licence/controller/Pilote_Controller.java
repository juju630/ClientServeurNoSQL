package clientServeur.Licence.controller;


import clientServeur.Licence.dto.Pilote_Dto;
import clientServeur.Licence.exception.InternalErrorException;
import clientServeur.Licence.exception.ItemNotFoundException;
import clientServeur.Licence.model.Pilote;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import clientServeur.Licence.service.Pilote_Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    @GetMapping("/naissance/{jour}/{mois}/{annee}")
    public List<Pilote_Dto> findAllByDateNaissance(@PathVariable int jour, @PathVariable int mois, @PathVariable int annee){
        try{
            String date_string = jour+"-"+mois+"-"+annee;
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date dateNaissance = formatter.parse(date_string);
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


    @PostMapping("/create/{nom}/{jour}/{mois}/{annee}/{nationalite}")
    public void createPilote(@PathVariable String nom, @PathVariable int jour,@PathVariable int mois,@PathVariable int annee, @PathVariable String nationalite) throws ParseException {
        String date_string = jour+"-"+mois+"-"+annee;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date dateNaissance = formatter.parse(date_string);
        System.out.println(dateNaissance);
        pilote_service.create(nom, dateNaissance, nationalite);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePilote(@PathVariable ObjectId id){
        pilote_service.delete(pilote_service.findById(id));
    }

    @PutMapping("/update/{id}")
    public void updatePilote(@PathVariable ObjectId id, @RequestBody Pilote pilote){
        pilote_service.update(id, pilote);
    }
}
