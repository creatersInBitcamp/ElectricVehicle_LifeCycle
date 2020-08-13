package com.bitcamp.team_project_eco.user;

import com.bitcamp.team_project_eco.utils.JpaService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;

interface UserService extends JpaService<User> {

    void readCsv();

    boolean insert(User user);

    Optional<User> findByUserId(String userId);

    Optional<User> findByEmail(String email);
}

@Service
public class UserServiceImpl implements UserService {
    @Autowired UserRepository userRepository;

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
                        csvRecord.get(3), //registerdate
                        csvRecord.get(4), //addr
                        csvRecord.get(5), //name
                        "male",
                        csvRecord.get(2), //birth
                        csvRecord.get(6), //email
                        csvRecord.get(7), //phonenumber
                        Integer.parseInt(csvRecord.get(8)), //방문수
                        false,
                        false,
                        0,
                        "noban",
                        csvRecord.get(9), //img
                        csvRecord.get(10), //text
                        "미등록"
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
    public Optional<User> findById(String id) {
        return userRepository.findById((long) Integer.parseInt(id));
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
