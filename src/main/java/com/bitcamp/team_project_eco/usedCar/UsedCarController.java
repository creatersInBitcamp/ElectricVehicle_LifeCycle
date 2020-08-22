package com.bitcamp.team_project_eco.usedCar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/usedCars")
public class UsedCarController {
    @Autowired UsedCarService usedCarService;

    @GetMapping("/csv")
    public void readCsv(){usedCarService.readCsv();}

    @GetMapping("/count")
    public int count(){
        return usedCarService.count();
    }

    @PostMapping("/register")
    public boolean register(@RequestBody UsedCarVO usedCar) {
        return usedCarService.insert(usedCar);
    }

    @GetMapping("/getall")
    public Iterable<UsedCar> getAllUsedCar () {
        return usedCarService.findAll();
    }

    @GetMapping("/getAllCarInfo")
    public List<CarInfo> getAllCarInfo () {
        return null;
    }

    @GetMapping("/delete/{usedCarId}")
    public boolean delete(@PathVariable Long usedCarId) {
        return usedCarService.deleteCar(usedCarId);
    }

    @GetMapping("/usedVO")
    public List<UsedCarVO> detail() {
        return usedCarService.detail();
    }

    @GetMapping("/carInfo")
    public List<CarInfo> carInfo() {
        return usedCarService.carInfo();
    }

    @GetMapping("/getOne/{usedCarId}")
    public Optional<UsedCar> getOneUsedCar(@PathVariable Long usedCarId) {
        return usedCarService.getOneById(usedCarId);
    }

    @GetMapping("/getDetail/{usedCarId}")
    public List<CarInfo> getDetail(@PathVariable String usedCarId) {
        return usedCarService.getDetail(usedCarId);
    }

    @PostMapping("/update")
    public void updateUsedCar(@RequestBody UsedCarVO usedCar) {
        usedCarService.update(usedCar);
    }

}