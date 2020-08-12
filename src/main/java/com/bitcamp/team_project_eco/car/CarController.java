package com.bitcamp.team_project_eco.car;

import com.bitcamp.team_project_eco.chargingStation.ChargingStation;
import com.bitcamp.team_project_eco.post.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired CarService carService;

    @GetMapping("/csv")
    public void csvRead(){
        carService.readCsv();
    }

    @GetMapping("/getall")
    public List<Car> getAllChargingStation(){
        return (List<Car>) carService.findAll();
    }

    @GetMapping("/getone/{carId}")
    public Optional<Car> getOneChargingStation(@PathVariable String carId) {
        return carService.findById(carId);
    }

    @PostMapping("/insert")
    public void insertCar(@RequestBody Car car) {
        carService.insertCar(car);
    }
    @PostMapping("/update")
    public void updateCar(@RequestBody Car car) {
        carService.updateCar(car);
    }

    @GetMapping("/delete")
    public void deleteChargingStation(@PathVariable String carId) {
        carService.delete(carId);
    }
}
