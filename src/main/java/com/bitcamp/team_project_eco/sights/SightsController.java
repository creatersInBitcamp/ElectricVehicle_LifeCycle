package com.bitcamp.team_project_eco.sights;

import com.bitcamp.team_project_eco.chargingStation.ChargingStation;
import com.bitcamp.team_project_eco.electriccar.ElectricCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3306)
@RestController
@RequestMapping("/sights")
public class SightsController {
    @Autowired SightsService sightsService;

    @GetMapping("/csv")
    public void csvRead(){
        sightsService.readCsv();
    }

    @GetMapping("/getall")
    public List<Sights> getAllSights(){
        return (List<Sights>) sightsService.findAll();
    }

    @GetMapping("/getall/{userSeq}")
    public List<? extends Object> getAllSights(@PathVariable String userSeq){
        return sightsService.findAll(userSeq);
    }

    @GetMapping("/getone/{sightsId}")
    public Optional<Sights> getOneSights(@PathVariable String sightsId) {
        return sightsService.findById(sightsId);
    }

    @PostMapping("/insert")
    public void insertSights(@RequestBody Sights sights) {
        sightsService.insertSights(sights);
    }
    @PostMapping("/update")
    public void updateSights(@RequestBody Sights sights) {
        sightsService.updateSights(sights);
    }
    @GetMapping("/delete")
    public void deleteSights(@PathVariable String sightsId) {
        sightsService.delete(sightsId);
    }

}
