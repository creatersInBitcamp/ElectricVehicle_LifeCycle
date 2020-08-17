package com.bitcamp.team_project_eco.usedCarSales;

import com.bitcamp.team_project_eco.usedCar.UsedCar;
import com.bitcamp.team_project_eco.usedCar.UsedCarRepository;
import com.bitcamp.team_project_eco.user.UserRepository;
import com.bitcamp.team_project_eco.utils.JpaService;
import org.springframework.stereotype.Service;

import java.util.Optional;

interface UsedCarSalesService extends JpaService<UsedCarSales> {

    boolean insert(SalesVO carSales);
}

@Service
public class UsedCarSalesServiceImpl implements UsedCarSalesService {
    private final UsedCarSalesRepository repository;
    private final UsedCarRepository usedCarRepository;
    private final UserRepository userRepository;

    public UsedCarSalesServiceImpl(UsedCarSalesRepository repository, UsedCarRepository usedCarRepository, UserRepository userRepository) {
        this.repository = repository;
        this.usedCarRepository = usedCarRepository;
        this.userRepository = userRepository;
    }

    @Override
    public boolean insert(SalesVO sales) {
        UsedCar u = usedCarRepository.findById(Long.valueOf(sales.getUsedCarId())).get();
        repository.save(new UsedCarSales(
                sales.buyerName,
                sales.buyerPhoneNumber,
                sales.buyerEmail,
                sales.buyerAddr,
                u));
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
