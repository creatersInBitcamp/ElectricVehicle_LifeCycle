package com.bitcamp.team_project_eco.utils;

import au.com.bytecode.opencsv.CSVReader;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvHandler {
    public List<String []> readCsv(String fileName) {
        InputStream in = getClass().getResourceAsStream("/static/"+fileName+".csv");
        List<String[]> data = new ArrayList<String[]>();
        try {
            CSVReader reader = new CSVReader(new InputStreamReader(in, "UTF-8"), ',', '"', 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
