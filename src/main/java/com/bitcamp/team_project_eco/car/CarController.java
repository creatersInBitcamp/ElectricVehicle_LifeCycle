package com.bitcamp.team_project_eco.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/car")
public class CarController {
//    @Autowired CarService carService;

//    @GetMapping("/carAll")
//    public List<Car> searchAll() { return carService.findAll(); }

//    @GetMapping("/carSearch/{carName}")
//    public Car[] select(@PathVariable String carName) {
//        String car = "%"+carName+"%";
//        System.out.println(car);
//        return carService.searchByCarName(car);
//    }
}
