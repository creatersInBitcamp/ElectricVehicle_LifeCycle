package com.bitcamp.team_project_eco.electriccar;

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

    @GetMapping("/readcsv")
    public void csvRead(){
        electricCarService.readCsv();
    }

    @GetMapping("/getall")
    public List<ElectricCar> getAllElectriccar(){
        return (List<ElectricCar>) electricCarService.findAll();
    }

    @GetMapping("/getone/{eccarId}")
    public Optional<ElectricCar> getOneElectriccar(@PathVariable String eccarId) {
        return electricCarService.findById(eccarId);
    }

    @GetMapping("/delete")
    public void deleteElectriccar(@PathVariable String eccarId) {
        electricCarService.delete(eccarId);
    }

}
