package com.bitcamp.team_project_eco.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired UserService userService;

    @GetMapping("/csv")
    public void readCsv() {
        userService.readCsv();
    }

    @GetMapping(value = "/idCheck/{userId}")
    public boolean idCheck(@PathVariable("userId") String userId){
        System.out.println(userId);
        return true;
    }
   /* @GetMapping(value = "/idCheck/${userId}")
    public ResponseEntity<Object> idCheck(@PathVariable String userId){
        Optional<User> idCheckResult = userService.findUserByUserId(userId);
        if(idCheckResult.isPresent()) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/

    @PostMapping(value = "/register")
    public boolean register(@RequestBody User user){
        return userService.insert(user);
    }
}
