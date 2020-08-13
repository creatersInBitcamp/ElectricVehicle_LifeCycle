package com.bitcamp.team_project_eco.usedCarSales;

import com.bitcamp.team_project_eco.utils.JpaService;
import org.springframework.stereotype.Service;

import java.util.Optional;

interface UsedCarSalesService extends JpaService<UsedCarSales> {
    void insertRequest(UsedCarSales sales);
}

@Service
public class UsedCarSalesServiceImpl implements UsedCarSalesService {

    @Override
    public void insertRequest(UsedCarSales sales) {

    }

    @Override
    public Optional<UsedCarSales> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Iterable<UsedCarSales> findAll() {
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
}
