package com.bitcamp.team_project_eco.board;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

interface BoardService {
    void handleCsv();
}

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired BoardRepository boardRepository;
    @Override
    public void handleCsv() {
        InputStream is = new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        };
        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
//            for (CSVRecord : csvRecords) {
//                boardRepository.save(new Board());
//            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}