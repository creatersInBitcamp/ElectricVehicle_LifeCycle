package com.bitcamp.team_project_eco.electriccar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/electriccar")
public class ElectricCarController {
    @Autowired
    EntityManager manager;
    @Autowired ElectricCarRepository repository;
}
