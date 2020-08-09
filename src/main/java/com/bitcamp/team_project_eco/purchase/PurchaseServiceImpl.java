package com.bitcamp.team_project_eco.purchase;

import com.bitcamp.team_project_eco.chargingStation.ChargingStation;
import com.bitcamp.team_project_eco.utils.JpaService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;

interface PurchaseService extends JpaService<Purchase>{
}
public class PurchaseServiceImpl implements PurchaseService{
    private final PurchaseRepository purchaseRepository;

    public PurchaseServiceImpl(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public Optional<Purchase> findById(String id) {
        return purchaseRepository.findById(Integer.parseInt(id));
    }

    @Override
    public Iterable<Purchase> findAll() {
        return purchaseRepository.findAll();
    }

    @Override
    public int count() {
        return (int) purchaseRepository.count();
    }

    @Override
    public void delete(String id) {
        purchaseRepository.delete(findById(id).orElse(new Purchase()));
    }

    @Override
    public boolean exists(String id) {
        return purchaseRepository.existsById(Integer.parseInt(id));
    }

}
