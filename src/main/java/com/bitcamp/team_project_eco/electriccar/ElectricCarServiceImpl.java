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
import java.util.List;
import java.util.Optional;

interface ElectricCarService extends JpaService<ElectricCar> {
    public void readCsv();

    public List<ElectricCar> getAll();

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
        System.out.println(electricCarRepository.findAll().toString());
        return electricCarRepository.findAll();
    }

    @Override
    public List<ElectricCar> getAll() {
        List<ElectricCar> electricCarList = electricCarRepository.findAll();
//        List<ElectricCarVO>

        return null;
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
        InputStream is = getClass().getResourceAsStream("/static/eccar.csv");

        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            int i = 1;
            for (CSVRecord csvRecord : csvRecords) {
                electricCarRepository.save(new ElectricCar(
                        csvRecord.get(0), //carName
                        csvRecord.get(1),//yyyy
                        csvRecord.get(2),//modelName
                        csvRecord.get(3),//trim
                        csvRecord.get(4),//brand
                        csvRecord.get(5),//price
                        csvRecord.get(6),//fuel
                        csvRecord.get(7),//fuelEfficiency
                        csvRecord.get(8),//passengersNumber
                        csvRecord.get(9),//drivingMethod
                        csvRecord.get(10),//transmission
                        csvRecord.get(11),//distanceDriven
                        csvRecord.get(12),//energy
                        csvRecord.get(13),//maximumOutput
                        csvRecord.get(14),//maximumTorque
                        csvRecord.get(15),//accelerationPerformance
                        csvRecord.get(16),//length
                        csvRecord.get(17),//width
                        csvRecord.get(18),//height
                        csvRecord.get(19),//wheelBase
                        csvRecord.get(20),//frontDistance
                        csvRecord.get(21),//backDistance
                        csvRecord.get(22),//weight
                        csvRecord.get(23),//frontWheel
                        csvRecord.get(24),//rearWheel
                        csvRecord.get(25),//frontSuspension
                        csvRecord.get(26),//rearSuspension
                        csvRecord.get(27),//frontBraking
                        csvRecord.get(28),//rearBraking
                        csvRecord.get(29),//steering
                        csvRecord.get(30),//img
                        csvRecord.get(31),//boostingCharge
                        csvRecord.get(32),//slowCharging
                        csvRecord.get(33),//color1
                        csvRecord.get(34),//color2
                        csvRecord.get(35),//color3
                        csvRecord.get(36),//color4
                        csvRecord.get(37),//color5
                        csvRecord.get(38),//color6
                        Boolean.parseBoolean(csvRecord.get(39)),//sale
                        csvRecord.get(40),//picture1
                        csvRecord.get(41),//picture2
                        csvRecord.get(42),//picture3
                        csvRecord.get(43),//picture4
                        csvRecord.get(44),//picture5
                        csvRecord.get(45),//picture6
                        csvRecord.get(46),//picture7
                        csvRecord.get(47),//picture8
                        csvRecord.get(48),//picture9
                        csvRecord.get(49),//picture10
                        csvRecord.get(50),//picture11
                        csvRecord.get(51),//picture12
                        csvRecord.get(52),//picture13
                        csvRecord.get(53),//picture14
                        csvRecord.get(54),//picture15
                        csvRecord.get(55),//picture16
                        csvRecord.get(56),//picture17
                        csvRecord.get(57),//picture18
                        csvRecord.get(58),//shortDetails
                        Boolean.parseBoolean(csvRecord.get(59)),//New
                        csvRecord.get(60),//video
                        new ArrayList<>(),//usedCarList
                        new ArrayList<>(),//purchasesList
                        new ArrayList<>(),//wishlistList
                        new ArrayList<>()));//variants
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
