package com.bitcamp.team_project_eco._mappers;

import com.bitcamp.team_project_eco._mybatisCar.MbCar;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MbCarMapper {
    public MbCar[] selectOne(String carName);
    public List<MbCar> selectAll();
}
