package com.bitcamp.team_project_eco.electriccar;

import com.bitcamp.team_project_eco.car.Car;
import com.bitcamp.team_project_eco.chargingStation.ChargingStation;
import com.bitcamp.team_project_eco.utils.JpaService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Optional;

interface ElectricCarService extends JpaService<ElectricCar> {
    public void readCsv();

    void insertElectricCar(ElectricCar electricCar);

    void updateElectricCar(ElectricCar electricCar);
}

@Service
public class ElectricCarServiceImpl implements ElectricCarService {

    private final ElectricCarRepository electricCarRepository;

    public ElectricCarServiceImpl(ElectricCarRepository electricCarRepository) {
        this.electricCarRepository = electricCarRepository;
    }

    @Override
    public Optional<ElectricCar> findById(String id) {
        return electricCarRepository.findById(Long.valueOf(id));
    }

    @Override
    public Iterable<ElectricCar> findAll() {
        return electricCarRepository.findAll();
    }

    @Override
    public int count() {
        return (int) electricCarRepository.count();
    }

    @Override
    public void delete(String id) {
        electricCarRepository.delete(findById(id).orElse(new ElectricCar()));

    }

    @Override
    public boolean exists(String id) {
        return electricCarRepository.existsById(Long.valueOf(id));
    }

    @Override
    public void readCsv() {
        InputStream is = getClass().getResourceAsStream("/static/electriccar.csv");

        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            int i = 1;
            for (CSVRecord csvRecord : csvRecords) {
                electricCarRepository.save(new ElectricCar(
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
                        csvRecord.get(30),
                        csvRecord.get(31),
                        csvRecord.get(32),
                        csvRecord.get(33),
                        csvRecord.get(34),
                        new ArrayList<>(),
                        new ArrayList<>(),
                        new ArrayList<>()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertElectricCar(ElectricCar electricCar) {
        electricCarRepository.save(electricCar);
    }

    @Override
    public void updateElectricCar(ElectricCar electricCar) {

    }
}
