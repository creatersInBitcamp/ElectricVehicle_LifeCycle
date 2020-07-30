package com.bitcamp.team_project_eco._mappers;


import com.bitcamp.team_project_eco._mybatisFare.MbFare;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MbFareMapper {
    public List<MbFare> selectOne(String startName, String arriveName);
    public List<MbFare> selectAll();
}
