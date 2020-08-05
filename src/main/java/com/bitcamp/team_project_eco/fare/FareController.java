package com.bitcamp.team_project_eco.fare;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/fare")
public class FareController {

    @GetMapping("/all")
    public List<Fare> search() {
        return null;
    }
}
