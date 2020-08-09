package com.bitcamp.team_project_eco.image;

import com.bitcamp.team_project_eco.chargingStation.ChargingStation;
import com.bitcamp.team_project_eco.utils.JpaService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;

interface ImageService extends JpaService<Image>{
    public void readCsv();
}

@Service
public class ImageServiceImpl implements ImageService{
    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Optional<Image> findById(String id) {
        return imageRepository.findById(Integer.parseInt(id));
    }

    @Override
    public Iterable<Image> findAll() {
        return imageRepository.findAll();
    }

    @Override
    public int count() {
        return (int) imageRepository.count();
    }

    @Override
    public void delete(String id) {
        imageRepository.delete(findById(id).orElse(new Image()));
    }

    @Override
    public boolean exists(String id) {
        return imageRepository.existsById(Integer.parseInt(id));
    }

    @Override
    public void readCsv() {
        InputStream is = getClass().getResourceAsStream("/static/image.csv");

        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                imageRepository.save(new Image(
                        csvRecord.get(1),
                        csvRecord.get(2),
                        DateTime.parse(csvRecord.get(3)),
                        csvRecord.get(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
