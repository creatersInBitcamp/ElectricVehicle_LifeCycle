package com.bitcamp.team_project_eco.variants;

import com.bitcamp.team_project_eco.electriccar.ElectricCar;
import com.bitcamp.team_project_eco.electriccar.ElectricCarRepository;
import com.bitcamp.team_project_eco.utils.JpaService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;

interface VariantsService extends JpaService<Variants>{
    public void readCsv();

    void insertElectricCar(Variants variants);

    void updateElectricCar(Variants variants);
}
@Service
public class VariantsServiceImpl implements VariantsService{
    private final VariantsRepository variantsRepository;
    private final ElectricCarRepository electricCarRepository;

    public VariantsServiceImpl(VariantsRepository variantsRepository, ElectricCarRepository electricCarRepository) {
        this.variantsRepository = variantsRepository;
        this.electricCarRepository = electricCarRepository;
    }

    @Override
    public Optional<Variants> findById(String id) {
        return variantsRepository.findById(Long.valueOf(id));
    }

    @Override
    public Iterable<Variants> findAll() {
        return variantsRepository.findAll();
    }

    @Override
    public int count() {
        return (int) variantsRepository.count();
    }

    @Override
    public void delete(String id) {
        variantsRepository.delete(findById(id).orElse(new Variants()));
    }

    @Override
    public boolean exists(String id) {
        return variantsRepository.existsById(Long.valueOf(id));
    }

    @Override
    public void readCsv() {
        InputStream is = getClass().getResourceAsStream("/static/variants.csv");

        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            int i = 1;
            for (CSVRecord csvRecord : csvRecords) {
                variantsRepository.save(new Variants(
                        csvRecord.get(0),
                        csvRecord.get(1),
                        electricCarRepository.findById(Long.valueOf(csvRecord.get(2))).get()));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertElectricCar(Variants variants) {
        variantsRepository.save(variants);
    }

    @Override
    public void updateElectricCar(Variants variants) {

    }
}
