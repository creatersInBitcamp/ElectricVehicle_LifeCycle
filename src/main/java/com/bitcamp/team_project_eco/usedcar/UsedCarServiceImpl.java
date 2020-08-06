package com.bitcamp.team_project_eco.usedcar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

interface UsedCarService {

}

@Service
public class UsedCarServiceImpl implements UsedCarService {
    @Autowired UsedCarRepository usedCarRepository;
}
