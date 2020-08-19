package com.bitcamp.team_project_eco.user;

import com.bitcamp.team_project_eco.join.AdminUsedCar;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
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
        return userService.findByEmail(email).map(com.bitcamp.team_project_eco.user.User::getPassword).orElse(null);
    }

    @PostMapping("/allUpdate")
    public void allUpdate(@RequestBody List<User> user){
        userService.allUpdate(user);
    }

    @GetMapping("/getone/{userSeq}")
    public User refreshUser(@PathVariable String userSeq) {
        return userService.findById(userSeq).get();
    }

    @GetMapping("/usedCar")
    public List<AdminUsedCar> adminUsedCar(){
        return userService.findAdminUsedCar();
    }

    @PostMapping("/addCar")
    public void addCar(@RequestParam("files")MultipartFile file) {
        System.out.println(file);
    }
    @PostMapping("/uploadFile")
    public void uploadFile(MultipartFile file) throws IOException {
        userService.saveCsv(file);
    }
    @GetMapping("/countSex")
    public List<Map<String, Object>> counting(){
        return userService.counting();
    }
    @GetMapping("/countAge")
    public List<Map<String,String>> countAge() {
        return userService.countAge();
    }

}
