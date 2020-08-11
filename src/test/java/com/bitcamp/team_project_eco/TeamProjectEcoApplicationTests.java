package com.bitcamp.team_project_eco;

import com.bitcamp.team_project_eco.user.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TeamProjectEcoApplicationTests {

    @Autowired
    UserServiceImpl userServiceImpl;

    @Test
    void contextLoads() {
    }

    @Test
    void testRepo(){
        userServiceImpl.readCsv();
        System.out.println("tttttttt"+userServiceImpl.findAll());

    }

}
