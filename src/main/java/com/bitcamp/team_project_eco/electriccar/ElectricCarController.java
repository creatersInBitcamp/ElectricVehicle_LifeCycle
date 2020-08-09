package com.bitcamp.team_project_eco.electriccar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/electriccar")
public class ElectricCarController {
}
