package com.bitcamp.team_project_eco.electriccar;

import com.bitcamp.team_project_eco.user.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/electriccars")
public class ElectricCarController {
    private final ElectricCarService electricCarService;

    public ElectricCarController(ElectricCarService electricCarService) {
        this.electricCarService = electricCarService;
    }

    @GetMapping("/csv")
    public void csvRead(){
        electricCarService.readCsv();
    }

    @GetMapping("/findall")
    public List<ElectricCar> findAllElectriccar(){
        return (List<ElectricCar>) electricCarService.findAll();
    }

    @GetMapping("/getall")
    public List<ElectricCarVO> getAllElectriccar(){

        return electricCarService.getAll();
    }

    @GetMapping("/getone/{eccarId}")
    public Optional<ElectricCar> getOneElectriccar(@PathVariable String eccarId) {
        return electricCarService.findById(eccarId);
    }

    @GetMapping("/search/{searchWord}")
    public List<ElectricCar> searchCar(@PathVariable String searchWord) {
        return electricCarService.findAllByWord(searchWord);
    }

    @PostMapping("/insert")
    public void insertElectricCar(@RequestBody ElectricCar electricCar) {
        electricCarService.insertElectricCar(electricCar);
    }

    @PostMapping("/uploadFile")
    public void uploadFile(MultipartFile file) throws IOException {
        electricCarService.saveCsv(file);
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
