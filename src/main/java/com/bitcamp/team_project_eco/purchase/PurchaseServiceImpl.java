package com.bitcamp.team_project_eco.purchase;

import com.amazonaws.services.dynamodbv2.xspec.L;
import com.bitcamp.team_project_eco.chargingStation.ChargingStation;
import com.bitcamp.team_project_eco.electriccar.ElectricCar;
import com.bitcamp.team_project_eco.utils.JpaService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;

interface PurchaseService extends JpaService<Purchase>{

    void insertPurchase(Purchase purchase);

    void updatePurchase(Purchase purchase);
}

@Service
public class PurchaseServiceImpl implements PurchaseService{
    private final PurchaseRepository purchaseRepository;

    public PurchaseServiceImpl(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public Optional<Purchase> findById(String id) {
        return purchaseRepository.findById(Long.valueOf(id));
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
        return purchaseRepository.existsById(Long.valueOf(id));
    }

    @Override
    public void insertPurchase(Purchase purchase) {
        purchaseRepository.save(purchase);
    }

    @Override
    public void updatePurchase(Purchase purchase) {

    }
}
