package clientServeur.Licence.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import clientServeur.Licence.service.Competition_Service;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/competition")
public class Competition_Controller {

    @Autowired
    private Competition_Service competition_service;
}
