package com.bitcamp.team_project_eco.electriccar;

import com.bitcamp.team_project_eco.car.Car;
import com.bitcamp.team_project_eco.chargingStation.ChargingStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/electriccars")
public class ElectricCarController {
    @Autowired ElectricCarService electricCarService;

    @GetMapping("/csv")
    public void csvRead(){
        electricCarService.readCsv();
    }

    @GetMapping("/getall")
    public List<ElectricCar> getAllElectriccar(){
        return (List<ElectricCar>) electricCarService.findAll();
    }

    @GetMapping("/findall")
    public List<ElectricCarVO> findAllElectriccar(){
        return electricCarService.getAll();
    }

    @GetMapping("/getone/{eccarId}")
    public Optional<ElectricCar> getOneElectriccar(@PathVariable String eccarId) {
        return electricCarService.findById(eccarId);
    }

    @PostMapping("/insert")
    public void insertElectricCar(@RequestBody ElectricCar electricCar) {
        electricCarService.insertElectricCar(electricCar);
    }
    @PostMapping("/update")
    public void updateElectricCar(@RequestBody ElectricCar electricCar) {
        electricCarService.updateElectricCar(electricCar);
    }

    @GetMapping("/delete")
    public void deleteElectriccar(@PathVariable String eccarId) {
        electricCarService.delete(eccarId);
    }

}
