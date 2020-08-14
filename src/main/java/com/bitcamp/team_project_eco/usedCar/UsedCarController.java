package com.bitcamp.team_project_eco.usedCar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/usedCars")
public class UsedCarController {
    @Autowired UsedCarService usedCarService;

    @GetMapping("/csv")
    public void readCsv(){usedCarService.readCsv();}

    @PostMapping("/register")
    public boolean register(@RequestBody UsedCarVO usedCar) {
        return usedCarService.insert(usedCar);
    }

    @GetMapping("/getall")
    public Iterable<UsedCar> getAllUsedCar () {
        return usedCarService.findAll();
    }

    @GetMapping("/delete/{usedCarId}")
    public boolean update(@PathVariable Long usedCarId) {
        return usedCarService.deleteCar(usedCarId);
    }
}