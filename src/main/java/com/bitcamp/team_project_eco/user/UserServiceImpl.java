package com.bitcamp.team_project_eco.user;

import com.bitcamp.team_project_eco.join.AdminUsedCar;
import com.bitcamp.team_project_eco.utils.JpaService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

interface UserService extends JpaService<User> {

    void readCsv();

    boolean insert(User user);

    Optional<User> findByUserId(String userId);

    Optional<User> findByEmail(String email);

    List<User> findUsers();

    void allUpdate(List<User> user);

    List<AdminUsedCar> findAdminUsedCar();

    void saveCsv(MultipartFile file);

    List<Map<String, Object>> counting();

    List<Map<String, String>> countAge();

    List<Map<String, String>> findCarNamePrice(String eccarId);

    List<Map<String, String>> findBrandCar();

    List<Map<String,String>> findBrandUsedCar();

    boolean updateOne(User user);

    boolean changePassword(String userId, String password);


    void oneUpdate(String userId, int grade, String banDate);
}

@Service
public class UserServiceImpl implements UserService {
    @Autowired UserRepository userRepository;

    @Override
    public void saveCsv(MultipartFile file) {


        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"));

            CSVParser parser = new CSVParser(fileReader, CSVFormat.DEFAULT);
            Iterable<CSVRecord> csvRecords = parser.getRecords();
            for(CSVRecord csvRecord : csvRecords) {
                userRepository.save(new User(
                        csvRecord.get(0), //userid
                        csvRecord.get(1), //password
                        csvRecord.get(2), // registerDate
                        csvRecord.get(3), // addr
                        csvRecord.get(4), // name
                        csvRecord.get(5), // sex
                        csvRecord.get(6),  // birthDate
                        csvRecord.get(7), // email
                        csvRecord.get(8), // phoneNumber
                        Integer.parseInt(csvRecord.get(9)), // visitCount
                        Boolean.parseBoolean(csvRecord.get(10)), // snsConfirm
                        Boolean.parseBoolean(csvRecord.get(11)), // emailConfirm
                        Integer.parseInt(csvRecord.get(12)), // grade
                        csvRecord.get(13), // banDate
                        csvRecord.get(14), //img
                        csvRecord.get(15), //text
                        csvRecord.get(16),
                        new ArrayList<>(),
                        new ArrayList<>(),
                        new ArrayList<>(),
                        new ArrayList<>(),
                        new ArrayList<>(),
                        new ArrayList<>()
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Map<String, Object>> counting() {
        System.out.println(userRepository.counting());
        return userRepository.counting();
    }

    @Override
    public List<Map<String, String>> countAge() {
        return userRepository.countAge();
    }

    @Override
    public List<Map<String, String>> findCarNamePrice(String eccarId) {
        return userRepository.findCarNamePrice(eccarId);
    }

    @Override
    public List<Map<String, String>> findBrandCar() {
        return userRepository.findBrandCar();
    }

    @Override
    public List<Map<String,String>> findBrandUsedCar() {
        return userRepository.findBrandUsedCar();
    }

    @Override
    public boolean updateOne(User user) {
        try {
            Long userSeq = user.getUserSeq();
            String email = user.getEmail();
            String phoneNumber = user.getPhoneNumber();
            String addr = user.getAddr();
            String profileImage = user.getProfileImage();
            String profileText = user.getProfileText();
            User up = userRepository.findById(userSeq).get();
            up.setEmail(email);
            up.setPhoneNumber(phoneNumber);
            up.setAddr(addr);
            up.setProfileImage(profileImage);
            up.setProfileText(profileText);
            userRepository.save(up);
//            userRepository.updateUser(userSeq, profileImage, profileText, email, phoneNumber, addr);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean changePassword(String userId, String password) {
        try{
            userRepository.changePassword(userId, password);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void oneUpdate(String userId, int grade, String banDate) {
        userRepository.oneUpdate(userId, grade, banDate);
    }

    @Override
    public void readCsv() {
        InputStream is = getClass().getResourceAsStream("/static/user.csv");

        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            CSVParser parser = new CSVParser(fileReader, CSVFormat.DEFAULT);
            Iterable<CSVRecord> csvRecords = parser.getRecords();
            for(CSVRecord csvRecord : csvRecords) {
                userRepository.save(new User(
                        csvRecord.get(0), //userid
                        csvRecord.get(1), //password
                        csvRecord.get(2), // registerDate
                        csvRecord.get(3), // addr
                        csvRecord.get(4), // name
                        csvRecord.get(5), // sex
                        csvRecord.get(6),  // birthDate
                        csvRecord.get(7), // email
                        csvRecord.get(8), // phoneNumber
                        Integer.parseInt(csvRecord.get(9)), // visitCount
                        Boolean.parseBoolean(csvRecord.get(10)), // snsConfirm
                        Boolean.parseBoolean(csvRecord.get(11)), // emailConfirm
                        Integer.parseInt(csvRecord.get(12)), // grade
                        csvRecord.get(13), // banDate
                        csvRecord.get(14), //img
                        csvRecord.get(15), //text
                        csvRecord.get(16),
                        new ArrayList<>(),
                        new ArrayList<>(),
                        new ArrayList<>(),
                        new ArrayList<>(),
                        new ArrayList<>(),
                        new ArrayList<>()
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean insert(User user) {
        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<User> findByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    @Override
    public void allUpdate(List<User> user) {
        userRepository.saveAll(user);
    }

    @Override
    public List<AdminUsedCar> findAdminUsedCar() {
        return userRepository.findAdminUsedCar();
    }



    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById(Long.valueOf(id));
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public int count() {
        return (int) userRepository.count();
    }

    @Override
    public void delete(String id) {
        userRepository.delete(findById(id).orElse(new User()));
    }

    @Override
    public boolean exists(String id) {
        return userRepository.existsById((long) Integer.parseInt(id));
    }
}
