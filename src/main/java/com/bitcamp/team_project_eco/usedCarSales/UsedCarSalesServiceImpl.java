package com.bitcamp.team_project_eco.usedCarSales;

import com.bitcamp.team_project_eco.usedCar.UsedCar;
import com.bitcamp.team_project_eco.usedCar.UsedCarRepository;
import com.bitcamp.team_project_eco.user.UserRepository;
import com.bitcamp.team_project_eco.utils.JpaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

interface UsedCarSalesService extends JpaService<UsedCarSales> {

    boolean insert(SalesVO carSales);

    Optional<UsedCarSales> findById(Long usedCarId);

    List<SalesVO> getInfo();

    List<UsedCarSales> getDetail(String usedCarId);
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
//        SalesVO vo = new SalesVO();
//        vo.setBuyerAddr(sales.buyerAddr);
//        vo.setBuyerEmail(sales.buyerEmail);
//        vo.setBuyerName(sales.buyerName);
//        vo.setBuyerPhoneNumber(sales.buyerPhoneNumber);
//        vo.setCarName(sales.carName);
//        vo.setUsedCarId(u.getUsedCarId());
        repository.save(new UsedCarSales(
                sales.buyerName,
                sales.buyerPhoneNumber,
                sales.buyerEmail,
                sales.buyerAddr,
                sales.carName,
                u));
        return true;
    }

    @Override
    public Optional<UsedCarSales> findById(Long usedCarId) {
        return repository.findById(usedCarId);
    }

    @Override
    public List<SalesVO> getInfo() {
        return repository.getInfo();
    }

    @Override
    public List<UsedCarSales> getDetail(String usedCarId) {
        return repository.findByUsedCarId(Long.parseLong(usedCarId));
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
