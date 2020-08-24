package com.bitcamp.team_project_eco.usedCar;

import com.bitcamp.team_project_eco.electriccar.ElectricCar;
import com.bitcamp.team_project_eco.electriccar.ElectricCarRepository;
import com.bitcamp.team_project_eco.electriccar.ElectricCarVO;
import com.bitcamp.team_project_eco.user.User;
import com.bitcamp.team_project_eco.user.UserRepository;
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

interface UsedCarService extends JpaService<UsedCar> {

    void readCsv();

    public List<UsedCarsVO> getAll();

    boolean insert(UsedCarVO usedCar);

    void update(Long usedCarId);

    void update(UsedCarVO usedCar);

    void update(List<CarInfo> before);

    boolean deleteCar(Long usedCarId);

    List<UsedCarVO> detail();

    List<CarInfo> carInfo();

    Optional<UsedCar> getOneById(Long usedCarId);

    List<CarInfo> getDetail(String usedCarId);

    List<CarInfo> getMyCar(String userSeq);

    List<CarInfo> getFirstCar(String userSeq);

    boolean deleteCarByUserSeq(List<UsedCar> myCars);

    List<CarInfo> getDetailList(String userSeq);
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
    public List<UsedCarsVO> getAll() {
        List<UsedCar> usedCarList = usedCarRepository.findAll();
        System.out.println(usedCarList.get(0).getElectricCar());
        List<UsedCarsVO> result = new ArrayList<>();
        for(int i=0; i< usedCarList.size(); i++){
            UsedCarsVO carVO = new UsedCarsVO();
            carVO.setUsedCarId(usedCarList.get(i).getUsedCarId());
            carVO.setPrice(usedCarList.get(i).getPrice());
            carVO.setAge(usedCarList.get(i).getAge());
            carVO.setMileage(usedCarList.get(i).getMileage());
            carVO.setSale(usedCarList.get(i).isSale());
            carVO.setMain(usedCarList.get(i).isMain());
            carVO.setImg(usedCarList.get(i).getImg());
            carVO.setUser(usedCarList.get(i).getUser());
            carVO.setCarName(usedCarList.get(i).getElectricCar().getCarName());
            carVO.setYyyy(usedCarList.get(i).getElectricCar().getYyyy());
            carVO.setModelName(usedCarList.get(i).getElectricCar().getModelName());
            carVO.setTrim(usedCarList.get(i).getElectricCar().getTrim());
            carVO.setBrand(usedCarList.get(i).getElectricCar().getBrand());
            List<String> pictures = new ArrayList<>();
            pictures.add(usedCarList.get(i).getImg().getImg1());
            pictures.add(usedCarList.get(i).getImg().getImg2());
            pictures.add(usedCarList.get(i).getImg().getImg3());
            pictures.add(usedCarList.get(i).getImg().getImg4());
            pictures.add(usedCarList.get(i).getPicture5());
            pictures.add(usedCarList.get(i).getPicture6());
            pictures.add(usedCarList.get(i).getPicture7());
            pictures.add(usedCarList.get(i).getPicture8());
            pictures.add(usedCarList.get(i).getPicture9());
            pictures.add(usedCarList.get(i).getPicture10());
            pictures.add(usedCarList.get(i).getPicture11());
            carVO.setPictures(pictures);
            carVO.setUsedCarSalesList(usedCarList.get(i).getUsedCarSalesList());
            result.add(carVO);
        }
        return result;
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
        InputStream is = getClass().getResourceAsStream("/static/usedcar.csv");

        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            CSVParser parser = new CSVParser(fileReader, CSVFormat.DEFAULT);
            Iterable<CSVRecord> csvRecords = parser.getRecords();
            for(CSVRecord csvRecord : csvRecords) {
                usedCarRepository.save(new UsedCar(
                        csvRecord.get(0).replace(",",""),//price
                        csvRecord.get(1),//age
                        csvRecord.get(2),//mileage
                        Boolean.parseBoolean(csvRecord.get(3)),//sale
                        Boolean.parseBoolean(csvRecord.get(4)),//main
                        csvRecord.get(5),//image1
                        csvRecord.get(6),//image2
                        csvRecord.get(7),//image3
                        csvRecord.get(8),//image4
                        userRepository.findById(Long.parseLong(csvRecord.get(9))).orElse(new User()),
                        electricCarRepository.findById(Long.parseLong(csvRecord.get(10))).orElse(new ElectricCar()),
                        csvRecord.get(11),//image5
                        csvRecord.get(12),//image6
                        csvRecord.get(13),//image7
                        csvRecord.get(14),//image8
                        csvRecord.get(15),//image9
                        csvRecord.get(16),//image10
                        csvRecord.get(17),//image11
                        new ArrayList<>()
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean insert(UsedCarVO usedCar) {
        User u = userRepository.findById(Long.valueOf(usedCar.getUserSeq())).get();
        ElectricCar car = electricCarRepository.findById(Long.valueOf(usedCar.getEccarId())).get();

        usedCarRepository.save(new UsedCar(
                usedCar.price, usedCar.age, usedCar.mileage, usedCar.sale,
                false,
                usedCar.img,
                null,
                null,
                null,
                u,
                car,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                new ArrayList<>()));
        return true;
    }

    @Override
    public void update(Long usedCarId) {
        System.out.println(usedCarId);
        System.out.println( usedCarRepository.findById(usedCarId).get());
        usedCarRepository.findById(usedCarId).get().setMain(true);
        UsedCar usedCar = usedCarRepository.findById(usedCarId).get();
        usedCar.setMain(true);
        usedCarRepository.save(usedCar);


    }

    @Override
    public void update(UsedCarVO usedCar) {
        try {
            UsedCar u = usedCarRepository.findById(usedCar.usedCarId).get();
            u.setUsedCarId(usedCar.usedCarId);
            u.setElectricCar(electricCarRepository.findById(usedCar.eccarId).get());
            u.setAge(usedCar.age);
            u.setPrice(usedCar.price);
            u.setMileage(usedCar.mileage);
            u.setSale(usedCar.sale);
            u.setMain(usedCar.main);
            usedCarRepository.save(u);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(List<CarInfo> before) {
        for(int i=0; i<before.size();i++){
            UsedCar usedCar = usedCarRepository.findById(before.get(i).usedCarId).get();
            usedCar.setMain(false);
            usedCarRepository.save(usedCar);
        }
    }

    @Override
    public boolean deleteCar(Long usedCarId) {
        System.out.println("deleteCar "+usedCarId);
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

    @Override
    public Optional<UsedCar> getOneById(Long usedCarId) {
        return usedCarRepository.findById(usedCarId);
    }

    @Override
    public List<CarInfo> getDetail(String usedCarId) {
        return usedCarRepository.findByUsedCarId(Long.parseLong(usedCarId));
    }

    @Override
    public List<CarInfo> getMyCar(String userSeq) {
        return usedCarRepository.findByUserSeq(Long.parseLong(userSeq));
    }

    @Override
    public List<CarInfo> getFirstCar(String userSeq) {
        return usedCarRepository.findFirstByUserSeq(Long.parseLong(userSeq));
    }

    @Override
    public boolean deleteCarByUserSeq(List<UsedCar> myCars) {
        try {
            for (int i=0; i<myCars.size(); i++) {
                System.out.println(myCars.get(i));
                Long id = myCars.get(i).getUsedCarId();
                System.out.println(id);
                deleteCar(id);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<CarInfo> getDetailList(String userSeq) {
        return usedCarRepository.findBySalesUserSeq(Long.parseLong(userSeq));
    }
}
