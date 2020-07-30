package com.bitcamp.team_project_eco._mybatisFare;

import com.bitcamp.team_project_eco._mappers.MbFareMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/fare")
public class MbFareController {
    @Autowired
    MbFareMapper fareMapper;

    @GetMapping("/search/{startName}/{arriveName}")
    public List<MbFare> Search(@PathVariable String startName,
                             @PathVariable String arriveName ){
        System.out.println("시작도시:"+startName+"도착도시:"+arriveName+"결과"+fareMapper.selectOne(startName,arriveName));
        return fareMapper.selectOne(startName,arriveName);
    }

    @GetMapping("/all")
    public List<MbFare> All(){
        System.out.println(fareMapper.selectAll());
        return fareMapper.selectAll();
    }
}
