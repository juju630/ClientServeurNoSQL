package clientServeur.Licence.controller;

import clientServeur.Licence.dto.Competition_Dto;
import clientServeur.Licence.dto.Ecurie_Dto;
import clientServeur.Licence.model.Competition;
import clientServeur.Licence.model.Ecurie;
import clientServeur.Licence.service.Competition_Service;
import clientServeur.Licence.service.Ecurie_Service;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/ecurie")
public class Ecurie_Controller {

    @Autowired
    private Ecurie_Service ecurie_service;

    @GetMapping("/")
    public List<Ecurie_Dto> findAll(){
        try{
            List<Ecurie_Dto> ecurie_dtoList = new ArrayList<>();
            for (Ecurie ecurie: ecurie_service.findAll()) {
                ecurie_dtoList.add(new Ecurie_Dto(ecurie));
            }
            return ecurie_dtoList;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/{id}")
    public Ecurie_Dto findById(@PathVariable String id){
        try{
            return new Ecurie_Dto(ecurie_service.findById(new ObjectId(id)));
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/name/{name}")
    public Ecurie_Dto findByName(@PathVariable String name){
        try{
            return new Ecurie_Dto(ecurie_service.findByName(name));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/nationalite/{nationalite}")
    public List<Ecurie_Dto> findByNationalite(@PathVariable String nationalite){
        try{
            List<Ecurie_Dto> ecurie_dtoList = new ArrayList<>();
            for (Ecurie ecurie: ecurie_service.findByNationalite(nationalite)) {
                ecurie_dtoList.add(new Ecurie_Dto(ecurie));
            }
            return ecurie_dtoList;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/lieu/{lieu}")
    public List<Ecurie_Dto> findByLieu(@PathVariable String lieu){
        try{
            List<Ecurie_Dto> ecurie_dtoList = new ArrayList<>();
            for (Ecurie ecurie: ecurie_service.findByLieu(lieu)) {
                ecurie_dtoList.add(new Ecurie_Dto(ecurie));
            }
            return ecurie_dtoList;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /*@PostMapping("/create/{nom}/{lieu}/{nationalite}")
    public void createCompetition(@PathVariable String nom,@PathVariable String lieu, @PathVariable String nationalite){
        ecurie_service.create(nom, lieu, nationalite, null);
    }*/

    @PostMapping("/")
    public void createCompetition(){
        ecurie_service.create();
    }
}
