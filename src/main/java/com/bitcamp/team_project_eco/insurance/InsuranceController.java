package com.bitcamp.team_project_eco.insurance;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/insurance")
public class InsuranceController {
    @Autowired EntityManager manager;
    @Autowired InsuranceRepository repository;
}
