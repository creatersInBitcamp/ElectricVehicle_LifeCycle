package com.bitcamp.team_project_eco.usedCar;

import com.bitcamp.team_project_eco.car.Car;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

interface UsedCarService extends JpaService<UsedCar> {

    void readCsv();

    boolean insert(UsedCarVO usedCar);

    boolean update(UsedCar usedCar);

    boolean deleteCar(Long usedCarId);

    List<UsedCarVO> detail();

    List<CarInfo> carInfo();
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
                        electricCarRepository.findById(Long.parseLong(csvRecord.get(8))).orElse(new ElectricCar()),
                        new ArrayList<>()
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
                "/assets/images/car/samsung/sm3ZERE/1.jpg",
                "/assets/images/car/samsung/sm3ZERE/1.jpg",
                "/assets/images/car/samsung/sm3ZERE/1.jpg",
                "/assets/images/car/samsung/sm3ZERE/1.jpg",
                u, car, new ArrayList<>()));
        return true;
    }

    @Override
    public boolean update(UsedCar usedCar) {
        try{
            usedCarRepository.save(usedCar);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteCar(Long usedCarId) {
        try {
            usedCarRepository.deleteById(usedCarId);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /*@Override
    public List<CarInfo> readWithCar() {
        List<CarInfo> list = new ArrayList<>();
        List<UsedCar> usedCarList  = usedCarRepository.findAll();
        int i = 0;

        while (i < usedCarList.size()){
            UsedCar usedCar = usedCarList.get(i);
            ElectricCar e = electricCarRepository.findById(usedCar.getElectricCar().getEccarId()).get();

//            usedCar, e.getBrand(), e.getCarName(), e.getYyyy(), e.getModelName(), e.getTrim()
            CarInfo info = new CarInfo();
            info.setUsedCar(usedCar);
            info.setBrand(e.getBrand());
            info.setCarName(e.getCarName());
            info.setYyyy(e.getYyyy());
            info.setModelName(e.getModelName());
            info.setTrim(e.getTrim());
            list.add(info);
            i++;
        }
        System.out.println(list.toString());
        return list;
    }*/

    @Override
    public List<UsedCarVO> detail() {
        return usedCarRepository.detail();
    }

    @Override
    public List<CarInfo> carInfo() {
        return usedCarRepository.carInfo();
    }
}
