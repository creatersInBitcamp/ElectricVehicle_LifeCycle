package com.bitcamp.team_project_eco.chargingStation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/chargingstations")
public class ChargingStationController {
    @Autowired ChargingStationService chargingStationService;

    @GetMapping("/readcsv")
    public void csvRead(){
        chargingStationService.readCsv();
    }

    @GetMapping("/getall")
    public List<ChargingStation> getAllChargingStation(){
        return (List<ChargingStation>) chargingStationService.findAll();
    }

    @GetMapping("/getone/{chargingStationId}")
    public Optional<ChargingStation> getOneChargingStation(@PathVariable String chargingStationId) {
        return chargingStationService.findById(chargingStationId);
    }

    @GetMapping("/delete")
    public void deleteChargingStation(@PathVariable String chargingStationId) {
        chargingStationService.delete(chargingStationId);
    }


}
