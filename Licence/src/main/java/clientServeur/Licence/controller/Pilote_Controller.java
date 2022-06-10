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

    /**
     * @HTTP_Verb GET
     * @Example local : http://localhost:8080/pilote/
     * @return Retourne la list complète de toutes les compétitions
     */
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

    /**
     * @HTTP_Verb GET
     * @Example local : http://localhost:8080/pilote/629859a76dee6a05ce365a10
     * @return Retourne le pilote recherché
     * @param id ID du pilote que l'on recherche
     */
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

    /**
     * @HTTP_Verb GET
     * @Example local : http://localhost:8080/pilote/nation/Français
     * @return Retourne les pilote recherchés
     * @param nationalite Nationalité des pilote que l'on recherche
     */
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

    /**
     * @HTTP_Verb GET
     * @Example local : http://localhost:8080/pilote/naissance/?day=12&month=6&years=2000
     * @return Retourne les pilote recherchés
     * @param jour : jour de naissance
     * @param mois : mois de naissance
     * @param annee : annee de naissance
     */
    @GetMapping("/naissance")
    public List<Pilote_Dto> findAllByDateNaissance(@RequestParam("day") Integer jour, @RequestParam("month")  Integer mois, @RequestParam("years")  Integer annee){
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


    /**
     * @HTTP_Verb POST
     * @Example http://localhost:8080/pilote/
     * @param pilote_dto  Objet Pilote DTO passé dans les paramètres du Body
     */
    @PostMapping
    public void createPilote(@RequestBody Pilote_Dto pilote_dto) throws ParseException {
        pilote_service.create(new Pilote(pilote_dto));
    }

    /**
     * @HTTP_Verb DELETE
     * @Example local : http://localhost:8080/pilote/629859a76dee6a05ce365a10
     * @param id ID du pilote que l'on veux supprimer
     */
    @DeleteMapping("/{id}")
    public void deletePilote(@PathVariable ObjectId id){
        pilote_service.delete(pilote_service.findById(id));
    }

    /**
     * @HTTP_Verb PUT
     * @Example local : http://localhost:8080/pilote/629859a76dee6a05ce365a10
     * @param id ID du pilote que l'on veux mettre à jour
     * @param pilote  Objet Pilote DTO passé dans les params du Body
     */
    @PutMapping("/{id}")
    public void updatePilote(@PathVariable ObjectId id, @RequestBody Pilote_Dto pilote){
        pilote_service.update(id,new Pilote(pilote));
    }
}
