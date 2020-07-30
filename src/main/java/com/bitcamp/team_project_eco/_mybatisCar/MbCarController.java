package com.bitcamp.team_project_eco._mybatisCar;


import com.bitcamp.team_project_eco._mappers.MbCarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/car")
public class MbCarController {
    @Autowired
    MbCarMapper carMapper;

    @GetMapping("/carSearch/{carName}")
    public MbCar[] select(@PathVariable String carName){
        String car = "%"+carName+"%";
        System.out.println(car);
        return carMapper.selectOne(car);
    }
    @GetMapping("/carAll")
    public List<MbCar> searchAll(){
        return carMapper.selectAll();
    }
}
