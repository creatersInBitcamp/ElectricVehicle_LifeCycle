package com.bitcamp.team_project_eco.user;

import com.bitcamp.team_project_eco.join.AdminUsedCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
        Optional<User> idCheckResult = userService.findByUserId(userId);
        return idCheckResult.isPresent();
    }

    @GetMapping("/findAll/{page}/{size}")
    public Page<User> findAll(@PathVariable int page, @PathVariable int size){
        return userService.findUsers(page, size);
    }

    @PostMapping("/register")
    public boolean register(@RequestBody User user) {
        return userService.insert(user);
    }

    @PostMapping("/updateOne")
    public boolean updateUser(@RequestBody User user) {
        return userService.updateOne(user);
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

    @GetMapping("/count")
    public int count() {
        return userService.count();
    }

    @GetMapping("/sendPassword/{email}")
    public String sendPassword(@PathVariable String email){

        return userService.sendPassword(email);
    }

    @PostMapping("/allUpdate")
    public void allUpdate(@RequestBody List<User> user){
        userService.allUpdate(user);
    }

    @PostMapping("/oneUpdate")
    public void oneUpdate(@RequestBody User user){
        userService.oneUpdate(user.getUserId(), user.getGrade(), user.getBanDate());
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

    @GetMapping("/findCarNamePrice/{eccarId}")
    public List<Map<String,String>> findCarNamePrice(@PathVariable String eccarId) {
        return userService.findCarNamePrice(eccarId);
    }

    @GetMapping("/findBrandCar")
    public List<Map<String,String>> findBrandCar(){
        return userService.findBrandCar();
    }

    @GetMapping("/findBrandUsedCar")
    public List<Map<String,String>> findBrandUsedCar() {
        return userService.findBrandUsedCar();
    }

    @PostMapping("/changePassword")
    public boolean changePassword(@RequestBody User user) {
        return userService.changePassword(user.getUserId(), user.getPassword());
    }


}
