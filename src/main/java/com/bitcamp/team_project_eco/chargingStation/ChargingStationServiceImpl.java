package com.bitcamp.team_project_eco.chargingStation;

import com.bitcamp.team_project_eco.bookmark.Bookmark;
import com.bitcamp.team_project_eco.electriccar.ElectricCar;
import com.bitcamp.team_project_eco.electriccar.ElectricCarRepository;
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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

interface ChargingStationService extends JpaService<ChargingStation>{
    public void readCsv();

    void insertChargingStation(ChargingStaionAdminVO chargingStaionAdminVO);

    void updateChargingStation(ChargingStation chargingStation);
    void allUpdate(List<ChargingStation> chargingStation);

    List<? extends Object> findAll(String userSeq);
    List<? extends Object> getMycarChargingStation(String eccarId, String userSeq);
}

@Service
public class ChargingStationServiceImpl implements ChargingStationService{
    private final ChargingStationRepository chargingStationRepository;
    private final UserRepository userRepository;
    private final ElectricCarRepository electricCarRepository;

    public ChargingStationServiceImpl(ChargingStationRepository chargingStationRepository, UserRepository userRepository, ElectricCarRepository electricCarRepository) {
        this.chargingStationRepository = chargingStationRepository;
        this.userRepository = userRepository;
        this.electricCarRepository = electricCarRepository;
    }

    @Override
    public Optional<ChargingStation> findById(String id) {
        return chargingStationRepository.findById(Long.valueOf(id));
    }

    @Override
    public Iterable<ChargingStation> findAll() {
        return chargingStationRepository.findAll();
    }

    @Override
    public List<? extends Object> findAll(String userSeq) {
        List<Bookmark> b = userRepository.findById(Long.valueOf(userSeq)).get().getBookmarkList();
        List<ChargingStation> chargingStations = chargingStationRepository.findAll();

        if(b.isEmpty()){
            return chargingStations;
        }
        else{
            List<ChargingStationVO> chargingStationList = new ArrayList<>();
            List<String> id = new ArrayList<>();
            List<Boolean> check = new ArrayList<>();
            for (Bookmark bookmark : b) {
                if (bookmark.getChargingStation() == null){
                    check.add(true);
                }else {
                    check.add(false);
                    id.add(String.valueOf(bookmark.getChargingStation().getChargingStationId()));
                }
            }
            if (!check.contains(false)){
                return chargingStations;
            }
            for(int i=0; i<count();i++){
                ChargingStationVO c = new ChargingStationVO();
                c.setChargingStationId(chargingStations.get(i).getChargingStationId());
                c.setName(chargingStations.get(i).getName());
                c.setChargerId(chargingStations.get(i).getChargerId());
                c.setChargerTypeID(chargingStations.get(i).getChargerTypeID());
                c.setChargerType(chargingStations.get(i).getChargerType());
                c.setChargerState(chargingStations.get(i).getChargerState());
                c.setAddress(chargingStations.get(i).getAddress());
                c.setXValue(chargingStations.get(i).getXValue());
                c.setYValue(chargingStations.get(i).getYValue());
                c.setBusinessHours(chargingStations.get(i).getBusinessHours());
                c.setAgencyName(chargingStations.get(i).getAgencyName());
                c.setPhone(chargingStations.get(i).getPhone());
                c.setUpdateDate(chargingStations.get(i).getUpdateDate());
                c.setBoostingCharge(chargingStations.get(i).getBoostingCharge());
                c.setCategory(chargingStations.get(i).getCategory());
                c.setUserSeq(Long.valueOf(userSeq));

                for (String s : id) {
                    if (c.getChargingStationId().equals(Long.valueOf(s))) {
                        c.setBookmarkList(b);
                    }
                }

                chargingStationList.add(c);
            }
            return chargingStationList;
        }
    }

    @Override
    public List<? extends Object> getMycarChargingStation(String eccarId, String userSeq) {
        List<Bookmark> b = userRepository.findById(Long.valueOf(userSeq)).get().getBookmarkList();
        Optional<ElectricCar> electricCar = electricCarRepository.findById(Long.valueOf(eccarId));
        List<ChargingStation> chargingStations = chargingStationRepository.getMycarChargingStation(electricCar);
        if(b.isEmpty()){
            return chargingStations;
        }
        else{
            List<ChargingStationVO> chargingStationList = new ArrayList<>();
            List<String> id = new ArrayList<>();
            List<Boolean> check = new ArrayList<>();
            for (Bookmark bookmark : b) {
                if (bookmark.getChargingStation() == null){
                    check.add(true);
                }else {
                    check.add(false);
                    id.add(String.valueOf(bookmark.getChargingStation().getChargingStationId()));
                }
            }
            if (!check.contains(false)){
                return chargingStations;
            }
            for(int i=0; i<chargingStations.size();i++){
                ChargingStationVO c = new ChargingStationVO();
                c.setChargingStationId(chargingStations.get(i).getChargingStationId());
                c.setName(chargingStations.get(i).getName());
                c.setChargerId(chargingStations.get(i).getChargerId());
                c.setChargerTypeID(chargingStations.get(i).getChargerTypeID());
                c.setChargerType(chargingStations.get(i).getChargerType());
                c.setChargerState(chargingStations.get(i).getChargerState());
                c.setAddress(chargingStations.get(i).getAddress());
                c.setXValue(chargingStations.get(i).getXValue());
                c.setYValue(chargingStations.get(i).getYValue());
                c.setBusinessHours(chargingStations.get(i).getBusinessHours());
                c.setAgencyName(chargingStations.get(i).getAgencyName());
                c.setPhone(chargingStations.get(i).getPhone());
                c.setUpdateDate(chargingStations.get(i).getUpdateDate());
                c.setBoostingCharge(chargingStations.get(i).getBoostingCharge());
                c.setCategory(chargingStations.get(i).getCategory());
                c.setUserSeq(Long.valueOf(userSeq));

                for (String s : id) {
                    if (c.getChargingStationId().equals(Long.valueOf(s))) {
                        c.setBookmarkList(b);
                    }
                }

                chargingStationList.add(c);
            }
            return chargingStationList;
        }
    }

    @Override
    public int count() {
        return (int) chargingStationRepository.count();
    }

    @Override
    public void delete(String id) {
        chargingStationRepository.delete(findById(id).orElse(new ChargingStation()));
    }

    @Override
    public boolean exists(String id) {
        return chargingStationRepository.existsById(Long.valueOf(id));
    }

    @Override
    public void readCsv() {
        InputStream is = getClass().getResourceAsStream("/static/chargingstation.csv");

        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                chargingStationRepository.save(new ChargingStation(
                        csvRecord.get(0),
                        csvRecord.get(1),
                        Integer.parseInt(csvRecord.get(2)),
                        csvRecord.get(3),
                        csvRecord.get(4),
                        csvRecord.get(5),
                        Double.parseDouble(csvRecord.get(6)),
                        Double.parseDouble(csvRecord.get(7)),
                        csvRecord.get(8),
                        csvRecord.get(9),
                        csvRecord.get(10),
                        csvRecord.get(11),
                        csvRecord.get(12),
                        "station",
                        new ArrayList<>()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertChargingStation(ChargingStaionAdminVO chargingStaionAdminVO) {
        ChargingStation chargingStation = new ChargingStation();
        chargingStation.setName(chargingStaionAdminVO.name);
        chargingStation.setChargerId(chargingStaionAdminVO.chargerId);
        chargingStation.setChargerTypeID(chargingStaionAdminVO.chargerTypeID);
        chargingStation.setChargerType(chargingStaionAdminVO.chargerType);
        chargingStation.setChargerState(chargingStaionAdminVO.chargerState);
        chargingStation.setAddress(chargingStaionAdminVO.address);
        chargingStation.setXValue(chargingStaionAdminVO.xValue);
        chargingStation.setYValue(chargingStaionAdminVO.yValue);
        chargingStation.setBusinessHours(chargingStaionAdminVO.businessHours);
        chargingStation.setAgencyName(chargingStaionAdminVO.agencyName);
        chargingStation.setPhone(chargingStaionAdminVO.phone);
        chargingStation.setUpdateDate(chargingStaionAdminVO.updateDate);
        chargingStation.setBoostingCharge(chargingStaionAdminVO.boostingCharge);
        chargingStation.setCategory(chargingStaionAdminVO.category);
        chargingStationRepository.save(chargingStation);
    }

    @Override
    public void updateChargingStation(ChargingStation chargingStation) {
       ChargingStation station = chargingStationRepository.findById(chargingStation.getChargingStationId()).get();
       station.setAddress(chargingStation.getAddress());
       station.setAgencyName(chargingStation.getAgencyName());
//       station.setBookmarkList(chargingStation.getBookmarkList());
       station.setBoostingCharge(chargingStation.getBoostingCharge());
       station.setBusinessHours(chargingStation.getBusinessHours());
       station.setCategory(chargingStation.getCategory());
       station.setChargerId(chargingStation.getChargerId());
       station.setChargerState(chargingStation.getChargerState());
       station.setChargerType(chargingStation.getChargerType());
       station.setChargingStationId(chargingStation.getChargingStationId());
       station.setName(chargingStation.getName());
       station.setPhone(chargingStation.getPhone());
       station.setUpdateDate(String.valueOf(new SimpleDateFormat("yyyyMMddHHmmss")));
       chargingStationRepository.save(station);
    }

    @Override
    public void allUpdate(List<ChargingStation> chargingStation) {
        chargingStationRepository.saveAll(chargingStation);
    }

}
