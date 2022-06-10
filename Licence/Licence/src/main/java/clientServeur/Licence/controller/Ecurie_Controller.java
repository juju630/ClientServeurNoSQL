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

    /**
     * @HTTP_Verb GET
     * @Example Local : http://localhost:8080/ecurie/
     * @return Retourne la liste de toutes les écuries
     */
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

    /**
     * @HTTP_Verb GET
     * @Example http://localhost:8080/ecurie/62986b1487be757e3ba1e905
     * @param id ID de l'écurie recherchée
     * @return Retourne l'écurie recherchée
     */
    @GetMapping("/{id}")
    public Ecurie_Dto findById(@PathVariable String id){
        try{
            return new Ecurie_Dto(ecurie_service.findById(new ObjectId(id)));
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @HTTP_Verb GET
     * @Example Local : http://localhost:8080/ecurie/name/Mercedes
     * @param name Nom de l'écurie recherché
     * @return retourne l'écurie recherché
     */
    @GetMapping("/name/{name}")
    public Ecurie_Dto findByName(@PathVariable String name){
        try{
            return new Ecurie_Dto(ecurie_service.findByName(name));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    /**
     * @HTTP_Verb GET
     * @Example http://localhost:8080/ecurie/nationalite/Allemande
     * @param nationalite Nationalité des écuries recherchées
     * @return retourne la listes des écuries avec la nationalité fournis
     */
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


    /**
     * @HTTP_Verb GET
     * @Example http://localhost:8080/ecurie/lieu/Berlin
     * @param lieu Lieu des écuries recherchées
     * @return retourne la listes des écuries avec le lieu recherchés
     */
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

    /**
     * @HTTP_Verb POST
     * @Example http://localhost:8080/ecurie/
     * @param ecurie  Objet Ecurie DTO passé dans les paramètres du Body
     */
    @PostMapping
    public void createCompetition(@RequestBody Ecurie_Dto ecurie){
        ecurie_service.create(new Ecurie(ecurie),null);
    }

    /**
     * @HTTP_Verb DELETE
     * @Example http://localhost:8080/ecurie/6299cd652ed4b1751c16146c
     * @param id ID du pilote que l'on souhaite supprimer de la base de donnée.
     */
    @DeleteMapping("/{id}")
    public void deletePilote(@PathVariable ObjectId id){
        ecurie_service.delete(ecurie_service.findById(id));
    }

    /**
     * @HTTP_Verb PUT
     * @Example
     * @param id
     * @param ecurie
     */
    @PutMapping("/{id}")
    public void update(@PathVariable ObjectId id, @RequestBody Ecurie_Dto ecurie){
        ecurie_service.update(id,new Ecurie(ecurie));
    }

    /**
     * @HTTP_Verb PUT
     * @Example http://localhost:8080/ecurie/addPilote/62986b1487be757e3ba1e905/6298598d6dee6a05ce365a0e
     * @param id ID de l'écurie
     * @param idPilote ID du pilote que l'on souhaite ajouter à l'écurie
     */
    @PutMapping("/addPilote/{id}/{idPilote}")
    public void addPilote(@PathVariable ObjectId id, @PathVariable ObjectId idPilote){
        ecurie_service.addPilote(id, idPilote);
    }
}
