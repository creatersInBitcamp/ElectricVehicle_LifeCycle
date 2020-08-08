package com.bitcamp.team_project_eco.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired UserRepository userRepository;
    @GetMapping("/idCheck/{userId}")
    public boolean idCheck(@PathVariable String userId){
        return false;
    }

    @PostMapping("/register")
    public boolean register(@RequestBody User user){
        return false;
    }
}
