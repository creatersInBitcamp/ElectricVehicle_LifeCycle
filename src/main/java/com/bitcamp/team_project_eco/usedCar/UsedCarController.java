package com.bitcamp.team_project_eco.usedCar;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/usedCars")
public class UsedCarController {
    private final UsedCarService usedCarService;

    public UsedCarController(UsedCarService usedCarService) {
        this.usedCarService = usedCarService;
    }

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

    @GetMapping("/getAllMyCar/{userSeq}")
    public List<CarInfo> getAllMyCar(@PathVariable String userSeq) {
        return usedCarService.getMyCar(userSeq);
    }

    @GetMapping("/deleteMyCar/{usedCarId}")
    public boolean deleteMyCar(@PathVariable Long usedCarId) {
        return usedCarService.deleteCar(usedCarId);
    }

}