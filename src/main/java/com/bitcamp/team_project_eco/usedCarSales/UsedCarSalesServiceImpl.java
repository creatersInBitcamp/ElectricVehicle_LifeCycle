package com.bitcamp.team_project_eco.usedCarSales;

import com.bitcamp.team_project_eco.utils.JpaService;
import org.springframework.stereotype.Service;

import java.util.Optional;

interface UsedCarSalesService extends JpaService<UsedCarSales> {

    boolean insert(SalesVO carSales);
}

@Service
public class UsedCarSalesServiceImpl implements UsedCarSalesService {
    private final UsedCarSalesRepository repository;

    public UsedCarSalesServiceImpl(UsedCarSalesRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean insert(SalesVO sales) {
        repository.save(new UsedCarSales(
                0,
                sales.buyerName,
                sales.buyerPhoneNumber,
                sales.buyerEmail,
                sales.buyerAddr,
                null
        ));
        return true;
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
