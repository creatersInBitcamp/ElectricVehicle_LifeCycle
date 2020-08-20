package com.bitcamp.team_project_eco.fare;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/fare")
public class FareController {
    private final FareService fareService;

    public FareController(FareService fareService) {
        this.fareService = fareService;
    }

    @GetMapping("/all")
    public List<Fare> search() {
        return null;
    }

    @GetMapping("/csv")
    public boolean readCsv() {
        return fareService.readCsv();
    }

    @GetMapping("/search/{startName}/{arriveName}")
    public List<Fare> search(@PathVariable String startName,
                       @PathVariable String arriveName) {
        System.out.println("출발지 : "+startName+" 도착지 : "+arriveName);
        return fareService.findFare(startName, arriveName);
    }
}
