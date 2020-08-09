package com.bitcamp.team_project_eco.chargingStation;

import com.bitcamp.team_project_eco.utils.JpaService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;

interface ChargingStationService extends JpaService<ChargingStation>{
    public void readCsv();
}

@Service
public class ChargingStationServiceImpl implements ChargingStationService{
    private final ChargingStationRepository chargingStationRepository;

    public ChargingStationServiceImpl(ChargingStationRepository chargingStationRepository) {
        this.chargingStationRepository = chargingStationRepository;
    }

    @Override
    public Optional<ChargingStation> findById(String id) {
        return chargingStationRepository.findById(Integer.parseInt(id));
    }

    @Override
    public Iterable<ChargingStation> findAll() {
        return chargingStationRepository.findAll();
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
        return chargingStationRepository.existsById(Integer.parseInt(id));
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
                        csvRecord.get(1),
                        csvRecord.get(2),
                        Integer.parseInt(csvRecord.get(3)),
                        csvRecord.get(4),
                        Integer.parseInt(csvRecord.get(5)),
                        Integer.parseInt(csvRecord.get(6)),
                        csvRecord.get(7),
                        csvRecord.get(8),
                        csvRecord.get(9),
                        csvRecord.get(10),
                        csvRecord.get(11),
                        csvRecord.get(12)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
