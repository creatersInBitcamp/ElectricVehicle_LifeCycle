package com.bitcamp.team_project_eco.fare;

import com.bitcamp.team_project_eco.utils.JpaService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;

interface FareService extends JpaService<Fare> {
    boolean readCsv();

    Fare findFare(String startName, String arriveName);
}

@Service
public class FareServiceImpl implements FareService {
    private final FareRepository repository;

    public FareServiceImpl(FareRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Fare> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Iterable<Fare> findAll() {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public boolean exists(String id) {
        return false;
    }

    @Override
    public boolean readCsv() {
        InputStream is = getClass().getResourceAsStream("/static/fare.csv");
        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                repository.save(new Fare(
                        Long.parseLong(csvRecord.get(0)),
                        csvRecord.get(1),
                        csvRecord.get(2),
                        csvRecord.get(3),
                        csvRecord.get(4),
                        csvRecord.get(5),
                        csvRecord.get(6),
                        csvRecord.get(7),
                        csvRecord.get(8)));
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Fare findFare(String startName, String arriveName) {
        return repository.findByStartNameAndArriveName(startName, arriveName);
    }
}
