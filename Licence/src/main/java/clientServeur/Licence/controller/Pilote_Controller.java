package clientServeur.Licence.controller;


import clientServeur.Licence.model.Pilote;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import clientServeur.Licence.service.Pilote_Service;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/pilote")
public class Pilote_Controller {

    @Autowired
    private Pilote_Service pilote_service;

    @GetMapping("/{id}")
    public Pilote findByID(@PathVariable ObjectId id){
        try{
            return pilote_service.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/")
    public List<Pilote> findAll(){
        try{
            return pilote_service.findAll().stream().map(pilote -> {pilote.setId(null); return pilote;}).collect(Collectors.toList());

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
