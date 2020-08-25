package com.bitcamp.team_project_eco;

import com.bitcamp.team_project_eco.user.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TeamProjectEcoApplicationTests {

    private final UserServiceImpl userServiceImpl;

    TeamProjectEcoApplicationTests(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @Test
    void contextLoads() {
    }

    @Test
    void testRepo(){
        userServiceImpl.readCsv();

    }

}
