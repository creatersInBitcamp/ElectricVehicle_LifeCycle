package com.bitcamp.team_project_eco.sights;

import com.bitcamp.team_project_eco.chargingStation.ChargingStation;
import com.bitcamp.team_project_eco.utils.JpaService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;

interface SightsService extends JpaService<Sights> {
    public void readCsv();
}

@Service
public class SightsServiceImpl implements SightsService{
    private final SightsRepository sightsRepository;

    public SightsServiceImpl(SightsRepository sightsRepository) {
        this.sightsRepository = sightsRepository;
    }

    @Override
    public Optional<Sights> findById(String id) {
        return sightsRepository.findById(Long.valueOf(id));
    }

    @Override
    public Iterable<Sights> findAll() {
        return sightsRepository.findAll();
    }

    @Override
    public int count() {
        return (int) sightsRepository.count();
    }

    @Override
    public void delete(String id) {
        sightsRepository.delete(findById(id).orElse(new Sights()));
    }

    @Override
    public boolean exists(String id) {
        return sightsRepository.existsById(Long.valueOf(id));
    }

    @Override
    public void readCsv() {
        InputStream is = getClass().getResourceAsStream("/static/sights.csv");

        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                sightsRepository.save(new Sights(
                        csvRecord.get(1),
                        csvRecord.get(2),
                        csvRecord.get(3),
                        Double.parseDouble(csvRecord.get(4)),
                        Double.parseDouble(csvRecord.get(5)),
                        Integer.parseInt(csvRecord.get(6)),
                        Integer.parseInt(csvRecord.get(7)),
                        csvRecord.get(8)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
