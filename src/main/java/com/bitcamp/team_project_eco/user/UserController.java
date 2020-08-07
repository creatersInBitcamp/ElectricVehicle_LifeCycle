package com.bitcamp.team_project_eco.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3306)
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired

}
