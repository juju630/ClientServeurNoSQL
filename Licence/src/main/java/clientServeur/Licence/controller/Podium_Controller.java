package clientServeur.Licence.controller;

import clientServeur.Licence.dto.Podium_Dto;
import clientServeur.Licence.model.Podium;
import clientServeur.Licence.service.Podium_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/podium")
public class Podium_Controller {

    @Autowired
    private Podium_Service podium_service;

    /**
     * @HTTP_Verb GET
     * @Example local : http://localhost:8080/podium/
     * @return Retourne la list complète de toutes les podium
     */
    @GetMapping("/")
    public List<Podium_Dto> findAll(){
        try{
            ArrayList<Podium_Dto> podium_dtoArrayList = new ArrayList<>();
            for (Podium podium : podium_service.findAll()){
                podium_dtoArrayList.add(new Podium_Dto(podium));
            }
            return podium_dtoArrayList;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @HTTP_Verb GET
     * @Example http://localhost:8080/podium/62986b1487be757e3ba1e905
     * @param id ID du podium recherché
     * @return Retourne le podium recherché
     */
    @GetMapping("/{id}")
    public Podium_Dto findById(@PathVariable String id){
        try{
            return new Podium_Dto(podium_service.findById(id));
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @HTTP_Verb POST
     * @Example local : http://localhost:8080/podium/
     * @param podium_dto  Objet Podium DTO passé dans les paramètres du Body
     */
    @PostMapping
    public void createPodium(@RequestBody Podium_Dto podium_dto){
        podium_service.create(new Podium(podium_dto));
    }

}
