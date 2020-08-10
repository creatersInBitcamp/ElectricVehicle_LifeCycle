package com.bitcamp.team_project_eco.usedCar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usedCars")
public class UsedCarController {
    @Autowired UsedCarService usedCarService;

    @GetMapping("/csv")
    public void readCsv(){usedCarService.readCsv();}

    @GetMapping("/insert")
    public void insertUsedCar(@RequestBody UsedCar usedCar) {usedCarService.insertUsedCar(usedCar);}
}