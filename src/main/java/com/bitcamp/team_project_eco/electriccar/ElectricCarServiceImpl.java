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

    List<ElectricCarVO> getAll();

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
    public List<ElectricCarVO> getAll() {
        List<ElectricCar> electricCarList = electricCarRepository.findAll();
        List<ElectricCarVO> result = new ArrayList<>();
        for(int i=0; i< electricCarList.size(); i++){
            ElectricCarVO carVO = new ElectricCarVO();
            carVO.setEccarId(electricCarList.get(i).getEccarId());
            carVO.setCarName(electricCarList.get(i).getCarName());
            carVO.setYyyy(electricCarList.get(i).getYyyy());
            carVO.setTrim(electricCarList.get(i).getTrim());
            carVO.setBrand(electricCarList.get(i).getBrand());
            carVO.setPrice(electricCarList.get(i).getPrice());
            carVO.setFuel(electricCarList.get(i).getFuel());
            carVO.setFuelEfficiency(electricCarList.get(i).getFuelEfficiency());
            carVO.setPassengersNumber(electricCarList.get(i).getPassengersNumber());
            carVO.setDrivingMethod(electricCarList.get(i).getDrivingMethod());
            carVO.setDistanceDriven(electricCarList.get(i).getDistanceDriven());
            carVO.setEnergy(electricCarList.get(i).getEnergy());
            carVO.setMaximumOutput(electricCarList.get(i).getMaximumOutput());
            carVO.setMaximumTorque(electricCarList.get(i).getMaximumTorque());
            carVO.setAccelerationPerformance(electricCarList.get(i).getAccelerationPerformance());
            carVO.setLength(electricCarList.get(i).getLength());
            carVO.setWidth(electricCarList.get(i).getWidth());
            carVO.setHeight(electricCarList.get(i).getHeight());
            carVO.setWheelBase(electricCarList.get(i).getWheelBase());
            carVO.setFrontDistance(electricCarList.get(i).getFrontDistance());
            carVO.setBackDistance(electricCarList.get(i).getBackDistance());
            carVO.setWeight(electricCarList.get(i).getWeight());
            carVO.setFrontWheel(electricCarList.get(i).getFrontWheel());
            carVO.setRearWheel(electricCarList.get(i).getRearWheel());
            carVO.setFrontSuspension(electricCarList.get(i).getFrontSuspension());
            carVO.setRearSuspension(electricCarList.get(i).getRearSuspension());
            carVO.setFrontBraking(electricCarList.get(i).getFrontBraking());
            carVO.setRearBraking(electricCarList.get(i).getRearBraking());
            carVO.setSteering(electricCarList.get(i).getSteering());
            carVO.setImg(electricCarList.get(i).getImg());
            carVO.setBoostingCharge(electricCarList.get(i).getBoostingCharge());
            carVO.setSlowCharging(electricCarList.get(i).getSlowCharging());
            List<String> colors = new ArrayList<>();
            colors.add(electricCarList.get(i).getColor1());
            if (electricCarList.get(i).getColor2().equals("")){
                carVO.setColors(colors);
            }
            else if (electricCarList.get(i).getColor3().equals("")){
                colors.add(electricCarList.get(i).getColor2());
                carVO.setColors(colors);
            }
            else if (electricCarList.get(i).getColor4().equals("")){
                colors.add(electricCarList.get(i).getColor2());
                colors.add(electricCarList.get(i).getColor3());
                carVO.setColors(colors);
            }
            else if (electricCarList.get(i).getColor5().equals("")){
                colors.add(electricCarList.get(i).getColor2());
                colors.add(electricCarList.get(i).getColor3());
                colors.add(electricCarList.get(i).getColor4());
                carVO.setColors(colors);
            }
            else if (electricCarList.get(i).getColor6().equals("")){
                colors.add(electricCarList.get(i).getColor2());
                colors.add(electricCarList.get(i).getColor3());
                colors.add(electricCarList.get(i).getColor4());
                colors.add(electricCarList.get(i).getColor5());
                carVO.setColors(colors);
            }
            else{
                colors.add(electricCarList.get(i).getColor2());
                colors.add(electricCarList.get(i).getColor3());
                colors.add(electricCarList.get(i).getColor4());
                colors.add(electricCarList.get(i).getColor5());
                colors.add(electricCarList.get(i).getColor6());
                carVO.setColors(colors);
            }
            carVO.setSale(electricCarList.get(i).isSale());
            List<String> pictures = new ArrayList<>();
            pictures.add(electricCarList.get(i).getPicture1());
            pictures.add(electricCarList.get(i).getPicture2());
            pictures.add(electricCarList.get(i).getPicture3());
            pictures.add(electricCarList.get(i).getPicture4());
            pictures.add(electricCarList.get(i).getPicture5());
            pictures.add(electricCarList.get(i).getPicture6());
            pictures.add(electricCarList.get(i).getPicture7());
            pictures.add(electricCarList.get(i).getPicture8());
            pictures.add(electricCarList.get(i).getPicture9());
            pictures.add(electricCarList.get(i).getPicture10());
            if (electricCarList.get(i).getPicture11().equals("")){
                carVO.setPictures(pictures);
            }
            else if (electricCarList.get(i).getPicture12().equals("")){
                pictures.add(electricCarList.get(i).getPicture11());
                carVO.setPictures(pictures);
            }
            else if (electricCarList.get(i).getPicture13().equals("")){
                pictures.add(electricCarList.get(i).getPicture11());
                pictures.add(electricCarList.get(i).getPicture12());
                carVO.setPictures(pictures);
            }
            else if (electricCarList.get(i).getPicture14().equals("")){
                pictures.add(electricCarList.get(i).getPicture11());
                pictures.add(electricCarList.get(i).getPicture12());
                pictures.add(electricCarList.get(i).getPicture13());
                carVO.setPictures(pictures);
            }
            else if (electricCarList.get(i).getPicture15().equals("")){
                pictures.add(electricCarList.get(i).getPicture11());
                pictures.add(electricCarList.get(i).getPicture12());
                pictures.add(electricCarList.get(i).getPicture13());
                pictures.add(electricCarList.get(i).getPicture14());
                carVO.setPictures(pictures);
            }
            else if (electricCarList.get(i).getPicture16().equals("")){
                pictures.add(electricCarList.get(i).getPicture11());
                pictures.add(electricCarList.get(i).getPicture12());
                pictures.add(electricCarList.get(i).getPicture13());
                pictures.add(electricCarList.get(i).getPicture14());
                pictures.add(electricCarList.get(i).getPicture15());
                carVO.setPictures(pictures);
            }
            else if (electricCarList.get(i).getPicture17().equals("")){
                pictures.add(electricCarList.get(i).getPicture11());
                pictures.add(electricCarList.get(i).getPicture12());
                pictures.add(electricCarList.get(i).getPicture13());
                pictures.add(electricCarList.get(i).getPicture14());
                pictures.add(electricCarList.get(i).getPicture15());
                pictures.add(electricCarList.get(i).getPicture16());
                carVO.setPictures(pictures);
            }
            else if (electricCarList.get(i).getPicture18().equals("")){
                pictures.add(electricCarList.get(i).getPicture11());
                pictures.add(electricCarList.get(i).getPicture12());
                pictures.add(electricCarList.get(i).getPicture13());
                pictures.add(electricCarList.get(i).getPicture14());
                pictures.add(electricCarList.get(i).getPicture15());
                pictures.add(electricCarList.get(i).getPicture16());
                pictures.add(electricCarList.get(i).getPicture17());
                carVO.setPictures(pictures);
            }
            else{
                pictures.add(electricCarList.get(i).getPicture11());
                pictures.add(electricCarList.get(i).getPicture12());
                pictures.add(electricCarList.get(i).getPicture13());
                pictures.add(electricCarList.get(i).getPicture14());
                pictures.add(electricCarList.get(i).getPicture15());
                pictures.add(electricCarList.get(i).getPicture16());
                pictures.add(electricCarList.get(i).getPicture17());
                pictures.add(electricCarList.get(i).getPicture18());
                carVO.setPictures(pictures);
            }
            carVO.setShortDetails(electricCarList.get(i).getShortDetails());
            carVO.setNew(electricCarList.get(i).isNew());
            carVO.setVideo(electricCarList.get(i).getVideo());
            carVO.setUsedCarList(electricCarList.get(i).getUsedCarList());
            carVO.setPurchasesList(electricCarList.get(i).getPurchasesList());
            carVO.setWishlistList(electricCarList.get(i).getWishlistList());
            carVO.setVariants(electricCarList.get(i).getVariants());
            result.add(carVO);
        }

        return result;
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
