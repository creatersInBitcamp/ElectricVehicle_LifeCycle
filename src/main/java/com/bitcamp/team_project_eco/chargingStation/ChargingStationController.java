package com.bitcamp.team_project_eco.chargingStation;

import com.bitcamp.team_project_eco.usedCar.UsedCarServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/chargingstations")
public class ChargingStationController {
    private final ChargingStationService chargingStationService;
    private final UsedCarServiceImpl usedCarService;

    public ChargingStationController(ChargingStationService chargingStationService, UsedCarServiceImpl usedCarService) {
        this.chargingStationService = chargingStationService;
        this.usedCarService = usedCarService;
    }

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
        if(usedCarService.getFirstCar(userSeq).isEmpty()){
            return chargingStationService.findAll(userSeq);
        }else{
            Long eccarId = usedCarService.getFirstCar(userSeq).get(0).getEccarId();
            return chargingStationService.getMycarChargingStation(eccarId,userSeq);
        }
    }

    @GetMapping("/getmycar/{eccarId}/{userSeq}")
    public List<? extends Object> getMycarChargingStation(@PathVariable Long eccarId, @PathVariable String userSeq){
        return chargingStationService.getMycarChargingStation(eccarId,userSeq);
    }

    @GetMapping("/getone/{chargingStationId}")
    public Optional<ChargingStation> getOneChargingStation(@PathVariable String chargingStationId) {
        return chargingStationService.findById(chargingStationId);
    }

    @PostMapping("/insert")
    public void insertChargingStation(@RequestBody ChargingStaionAdminVO chargingStaionAdminVO) {
        chargingStationService.insertChargingStation(chargingStaionAdminVO);
    }

    @PostMapping("/update")
    public void updateChargingStation(@RequestBody ChargingStation chargingStation) {
        chargingStationService.updateChargingStation(chargingStation);
    }

    @PostMapping("/allUpdate")
    public void allUpdate(@RequestBody List<ChargingStation> chargingStationList){
        chargingStationService.allUpdate(chargingStationList);
    }

    @GetMapping("/delete/{chargingStationId}")
    public void deleteChargingStation(@PathVariable String chargingStationId) {
        chargingStationService.delete(chargingStationId);
    }


}
