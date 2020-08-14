package com.bitcamp.team_project_eco.usedCar;

import com.bitcamp.team_project_eco.electriccar.ElectricCar;
import com.bitcamp.team_project_eco.electriccar.ElectricCarRepository;
import com.bitcamp.team_project_eco.user.User;
import com.bitcamp.team_project_eco.user.UserRepository;
import com.bitcamp.team_project_eco.utils.JpaService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;

interface UsedCarService extends JpaService<UsedCar> {

    void readCsv();

    boolean insert(UsedCarVO usedCar);
}

@Service
public class UsedCarServiceImpl implements UsedCarService {
    private final UsedCarRepository usedCarRepository;
    private final UserRepository userRepository;
    private final ElectricCarRepository electricCarRepository;

    public UsedCarServiceImpl(UsedCarRepository usedCarRepository, UserRepository userRepository, ElectricCarRepository electricCarRepository) {
        this.usedCarRepository = usedCarRepository;
        this.userRepository = userRepository;
        this.electricCarRepository = electricCarRepository;
    }

    @Override
    public Optional<UsedCar> findById(String id) {
        return usedCarRepository.findById((long) Integer.parseInt(id));
    }

    @Override
    public Iterable<UsedCar> findAll() {
        return usedCarRepository.findAll();
    }

    @Override
    public int count() {
        return (int) usedCarRepository.count();
    }

    @Override
    public void delete(String id) {
        usedCarRepository.delete(findById(id).orElse(new UsedCar()));
    }

    @Override
    public boolean exists(String id) {
        return usedCarRepository.existsById((long) Integer.parseInt(id));
    }

    @Override
    public void readCsv() {
        InputStream is = getClass().getResourceAsStream("/static/used_cars531.csv");

        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            CSVParser parser = new CSVParser(fileReader, CSVFormat.DEFAULT);
            Iterable<CSVRecord> csvRecords = parser.getRecords();
            for(CSVRecord csvRecord : csvRecords) {
                usedCarRepository.save(new UsedCar(
                        csvRecord.get(0),//price
                        csvRecord.get(1),//age
                        csvRecord.get(2),//mileage
                        csvRecord.get(3),//image
                        csvRecord.get(4),//image
                        csvRecord.get(5),//image
                        csvRecord.get(6),//image
                        userRepository.findById(Long.parseLong(csvRecord.get(7))).orElse(new User()),
                        electricCarRepository.findById(Long.parseLong(csvRecord.get(8))).orElse(new ElectricCar())
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean insert(UsedCarVO usedCarVD) {
        System.out.println(usedCarVD.userSeq);
        User u = userRepository.findById(Long.valueOf(usedCarVD.getUserSeq())).get();
        ElectricCar car = electricCarRepository.findById(Long.valueOf(usedCarVD.getEccarId())).get();

        usedCarRepository.save(new UsedCar(
                usedCarVD.price, usedCarVD.age, usedCarVD.mileage,
                null, null, null, null,
                u, car));
        return true;
    }
}
