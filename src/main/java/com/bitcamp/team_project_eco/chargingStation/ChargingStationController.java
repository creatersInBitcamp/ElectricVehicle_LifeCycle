package com.bitcamp.team_project_eco.chargingStation;

import com.bitcamp.team_project_eco.car.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/chargingstations")
public class ChargingStationController {
    @Autowired ChargingStationService chargingStationService;

    @GetMapping("/csv")
    public void csvRead(){
        chargingStationService.readCsv();
    }

    @GetMapping("/getall")
    public List<ChargingStation> getAllChargingStation(){
        return (List<ChargingStation>) chargingStationService.findAll();
    }

    @GetMapping("/getall/{userSeq}")
    public List<? extends Object> getAllChargingStation(@PathVariable String userSeq){
        return chargingStationService.findAll(userSeq);
    }

    @GetMapping("/getmycar/{eccarId}/{userSeq}")
    public List<? extends Object> getMycarChargingStation(@PathVariable String eccarId, @PathVariable String userSeq){
        return chargingStationService.getMycarChargingStation(eccarId,userSeq);
    }

    @GetMapping("/getone/{chargingStationId}")
    public Optional<ChargingStation> getOneChargingStation(@PathVariable String chargingStationId) {
        return chargingStationService.findById(chargingStationId);
    }

    @PostMapping("/insert")
    public void insertPost(@RequestBody ChargingStation chargingStation) {
        chargingStationService.insertChargingStation(chargingStation);
    }
    @PostMapping("/update")
    public void updatePost(@RequestBody ChargingStation chargingStation) {
        chargingStationService.updateChargingStation(chargingStation);
    }

    @GetMapping("/delete")
    public void deleteChargingStation(@PathVariable String chargingStationId) {
        chargingStationService.delete(chargingStationId);
    }


}
