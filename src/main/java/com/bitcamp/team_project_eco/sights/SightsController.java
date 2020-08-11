package com.bitcamp.team_project_eco.sights;

import com.bitcamp.team_project_eco.chargingStation.ChargingStation;
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

    @GetMapping("/getone/{sightsId}")
    public Optional<Sights> getOneSights(@PathVariable String sightsId) {
        return sightsService.findById(sightsId);
    }

    @GetMapping("/delete")
    public void deleteSights(@PathVariable String sightsId) {
        sightsService.delete(sightsId);
    }

}
