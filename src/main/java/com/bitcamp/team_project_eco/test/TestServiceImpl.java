package com.bitcamp.team_project_eco.test;

import com.bitcamp.team_project_eco.electriccar.ElectricCarRepository;
import com.bitcamp.team_project_eco.user.UserRepository;
import com.bitcamp.team_project_eco.utils.JpaService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;

interface TestService extends JpaService<TestEntity> {

    boolean csv();
}

@Service
public class TestServiceImpl implements TestService{

    private final TestRepository testRepository;
    private final UserRepository userRepository;
    private final ElectricCarRepository electricCarRepository;

    public TestServiceImpl(TestRepository testRepository, UserRepository userRepository, ElectricCarRepository electricCarRepository) {
        this.testRepository = testRepository;
        this.userRepository = userRepository;
        this.electricCarRepository = electricCarRepository;
    }

    @Override
    public Optional<TestEntity> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Iterable<TestEntity> findAll() {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public boolean exists(String id) {
        return false;
    }

    @Override
    public boolean csv() {
        InputStream is = getClass().getResourceAsStream("/static/purchase.csv");
        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            int j = 0;
            for (CSVRecord csvRecord : csvRecords) { // csv row
                for( int y = 1; y < 13; y++) { // csv col
                int userId = (j % 300); //유저가 300명일 때, csv data의 순환만큼 순서대로 유저를 대입하고 유저수가 순환하면 다시 0번 유저부터 시작.
                    for(int z = 0; z < Integer.parseInt(csvRecord.get(y)); z++) { // csv data y월,
                            testRepository.save(new TestEntity(
                                    "2019-"+ y +"-01",
                                    userRepository.findById(Long.parseLong(String.valueOf(userId))).get(),
                                    electricCarRepository.findById(Long.parseLong(csvRecord.get(0))).get())
                            );
                            j++;
                    }
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
