package clientServeur.Licence.controller;

import clientServeur.Licence.dto.Competition_Dto;
import clientServeur.Licence.dto.Ecurie_Dto;
import clientServeur.Licence.model.Competition;
import clientServeur.Licence.model.Ecurie;
import clientServeur.Licence.model.Pilote;
import clientServeur.Licence.service.Competition_Service;
import clientServeur.Licence.service.Ecurie_Service;
import com.fasterxml.jackson.annotation.JsonFormat;
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

    @PostMapping
    public void createCompetition(@RequestBody Ecurie_Dto ecurie){
        ecurie_service.create(new Ecurie(ecurie),null);
    }

    @DeleteMapping("/{id}")
    public void deletePilote(@PathVariable ObjectId id){
        ecurie_service.delete(ecurie_service.findById(id));
    }

    @PutMapping("/{id}")
    public void updatePilote(@PathVariable ObjectId id, @RequestBody Ecurie_Dto ecurie){
        ecurie_service.update(id,new Ecurie(ecurie));
    }

    @PutMapping("/addPilote/{id}/{idPilote}")
    public void addPilote(@PathVariable ObjectId id, @PathVariable ObjectId idPilote){
        ecurie_service.addPilote(id, idPilote);
    }
}
