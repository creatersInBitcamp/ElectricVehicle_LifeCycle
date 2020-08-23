package com.bitcamp.team_project_eco.car;

import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/csv")
    public void csvRead(){
        carService.readCsv();
    }

    @GetMapping("/carSearch/{searchWord}")
    public List<Car> searchByWord(@PathVariable String searchWord) {
        System.out.println(searchWord);
        return carService.searchCar(searchWord);
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
