package com.bitcamp.team_project_eco.variants;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/variants")
public class VariantsController {
    private final VariantsService variantsService;

    public VariantsController(VariantsService variantsService) {
        this.variantsService = variantsService;
    }

    @GetMapping("/csv")
    public void csvRead(){
        variantsService.readCsv();
    }

    @GetMapping("/getall")
    public List<Variants> getAllElectriccar(){
        return (List<Variants>) variantsService.findAll();
    }

    @GetMapping("/getone/{variantsId}")
    public Optional<Variants> getOneElectriccar(@PathVariable String variantsId) {
        return variantsService.findById(variantsId);
    }

    @PostMapping("/insert")
    public void insertElectricCar(@RequestBody Variants variants) {
        variantsService.insertElectricCar(variants);
    }
    @PostMapping("/update")
    public void updateElectricCar(@RequestBody Variants variants) {
        variantsService.updateElectricCar(variants);
    }

    @GetMapping("/delete")
    public void deleteElectriccar(@PathVariable String variantsId) {
        variantsService.delete(variantsId);
    }

}
