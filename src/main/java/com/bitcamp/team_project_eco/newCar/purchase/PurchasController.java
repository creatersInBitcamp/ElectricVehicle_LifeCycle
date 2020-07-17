package com.bitcamp.team_project_eco.newCar.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
//@RequestMapping("/purchas")
public class PurchasController {
    @Autowired EntityManager manager;
    @Autowired PurchasRepository repository;
}
