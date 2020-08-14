package com.bitcamp.team_project_eco.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/csv")
    public void readCsv() {
        userService.readCsv();
    }

    @GetMapping("/check/{userId}")
    public Boolean idCheck(@PathVariable String userId) {
        System.out.println("유저아이디: " + userId);
        Optional<User> idCheckResult = userService.findByUserId(userId);
        System.out.println(idCheckResult.isPresent());
        return idCheckResult.isPresent();
    }

    @GetMapping("/findAll")
    public List<User> findAll(){
        System.out.println("자바들어옴");
        return userService.findUsers();
    }

    @PostMapping("/register")
    public boolean register(@RequestBody User user) {
        return userService.insert(user);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        Optional<User> findUser = userService.findByUserId(user.getUserId());
        if (findUser.isPresent()) {
            User requestLoginUser = findUser.get();
            if (user.getPassword().equals(requestLoginUser.getPassword())) {
                return ResponseEntity.ok(requestLoginUser);
            } else {
                return ResponseEntity.badRequest().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/sendPassword/{email}")
    public String sendPassword(@PathVariable String email){
        System.out.println(email);
        return userService.findByEmail(email).map(com.bitcamp.team_project_eco.user.User::getPassword).orElse(null);
    }

    @GetMapping("/refresh/{userSeq}")
    public Optional<User> refreshUser(@PathVariable String userSeq) {
        return userService.findById(userSeq);
    }
}
