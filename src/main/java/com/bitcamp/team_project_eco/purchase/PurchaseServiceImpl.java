package com.bitcamp.team_project_eco.purchase;

import com.bitcamp.team_project_eco.electriccar.ElectricCar;
import com.bitcamp.team_project_eco.electriccar.ElectricCarRepository;
import com.bitcamp.team_project_eco.user.User;
import com.bitcamp.team_project_eco.user.UserRepository;
import com.bitcamp.team_project_eco.utils.JpaService;
import org.springframework.stereotype.Service;

import java.util.Optional;

interface PurchaseService extends JpaService<Purchase>{

    void insertPurchase(PurchaseVO purchase);

    void updatePurchase(Purchase purchase);
}

@Service
public class PurchaseServiceImpl implements PurchaseService{
    private final PurchaseRepository purchaseRepository;
    private final UserRepository userRepository;
    private final ElectricCarRepository electricCarRepository;

    public PurchaseServiceImpl(PurchaseRepository purchaseRepository, UserRepository userRepository, ElectricCarRepository electricCarRepository) {
        this.purchaseRepository = purchaseRepository;
        this.userRepository = userRepository;
        this.electricCarRepository = electricCarRepository;
    }

    @Override
    public Optional<Purchase> findById(String id) {
        return purchaseRepository.findById(Long.parseLong(id));
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
    public void insertPurchase(PurchaseVO purchase) {

        User u = userRepository.findById(Long.parseLong(purchase.getUserSeq())).get();
        ElectricCar ec = electricCarRepository.findById(Long.parseLong(purchase.getEccarId())).get();
        purchaseRepository.save(new Purchase(
                purchase.purchasingMethod,
                purchase.purchaseTime,
                purchase.purchasePrice,
                purchase.color,
                u,
                ec
        ));
    }

    @Override
    public void updatePurchase(Purchase purchase) {
        purchaseRepository.save(purchase);
    }
}
