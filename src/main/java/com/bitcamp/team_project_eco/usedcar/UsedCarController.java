package com.bitcamp.team_project_eco.usedcar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usedCars")
public class UsedCarController {
    @Autowired UsedCarService usedCarService;
}
