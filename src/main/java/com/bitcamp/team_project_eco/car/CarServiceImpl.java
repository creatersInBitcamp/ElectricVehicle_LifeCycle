package com.bitcamp.team_project_eco.car;

import com.bitcamp.team_project_eco.chargingStation.ChargingStation;
import com.bitcamp.team_project_eco.post.Post;
import com.bitcamp.team_project_eco.utils.JpaService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;

interface CarService extends JpaService<Car> {
    public void readCsv();

    void insertCar(Car car);

    void updateCar(Car car);
}

@Service
public class CarServiceImpl implements CarService{
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Optional<Car> findById(String id) {
        return carRepository.findById(Long.valueOf(id));
    }

    @Override
    public Iterable<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public int count() {
        return (int) carRepository.count();
    }

    @Override
    public void delete(String id) {
        carRepository.delete(findById(id).orElse(new Car()));
    }

    @Override
    public boolean exists(String id) {
        return carRepository.existsById(Long.valueOf(id));
    }

    @Override
    public void readCsv() {
        InputStream is = getClass().getResourceAsStream("/static/car.csv");

        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                carRepository.save(new Car(
                        csvRecord.get(0),
                        csvRecord.get(1),
                        csvRecord.get(2),
                        csvRecord.get(3),
                        csvRecord.get(4),
                        csvRecord.get(5),
                        csvRecord.get(6),
                        csvRecord.get(7),
                        csvRecord.get(8),
                        csvRecord.get(9),
                        csvRecord.get(10),
                        csvRecord.get(11),
                        csvRecord.get(12),
                        csvRecord.get(13),
                        csvRecord.get(14),
                        csvRecord.get(15),
                        csvRecord.get(16),
                        csvRecord.get(17),
                        csvRecord.get(18),
                        csvRecord.get(19),
                        csvRecord.get(20),
                        csvRecord.get(21),
                        csvRecord.get(22),
                        csvRecord.get(23),
                        csvRecord.get(24),
                        csvRecord.get(25),
                        csvRecord.get(26),
                        csvRecord.get(27),
                        csvRecord.get(28),
                        csvRecord.get(29),
                        csvRecord.get(30)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public void updateCar(Car car) {

    }
}
