package com.bitcamp.team_project_eco.purchase;

import com.bitcamp.team_project_eco.electriccar.ElectricCar;
import com.bitcamp.team_project_eco.electriccar.ElectricCarRepository;
import com.bitcamp.team_project_eco.user.User;
import com.bitcamp.team_project_eco.user.UserRepository;
import com.bitcamp.team_project_eco.utils.JpaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

interface PurchaseService extends JpaService<Purchase>{

    void insertPurchase(PurchaseVO purchase);

    void updatePurchase(Purchase purchase);

    List<OrderVO> findAllOrder();
    List<OrderVO> findAllOrder(Long userSeq);
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
                purchase.merchant_uid,
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

    @Override
    public List<OrderVO> findAllOrder() {
        List<OrderVO> result = new ArrayList<>();
        List<Purchase> list = purchaseRepository.findAll();
        for (Purchase purchase : list) {
            OrderVO o = new OrderVO();
            o.setUserName(purchase.getUser().getName());
            o.setCarName(purchase.getElectricCar().getCarName());
            o.setColor(purchase.getColor());
            o.setOrderId(purchase.getOrderId());
            o.setPurchasePrice(purchase.getPurchasePrice());
            o.setPurchaseTime(purchase.getPurchaseTime());
            o.setPurchasingMethod(purchase.getPurchasingMethod());
            result.add(o);
        }
        return result;
    }

    @Override
    public List<OrderVO> findAllOrder(Long userSeq) {
        List<OrderVO> result = new ArrayList<>();
        List<Purchase> list = userRepository.findById(userSeq).get().getPurchasesList();
        for (Purchase purchase : list) {
            OrderVO o = new OrderVO();
            o.setCarName(purchase.getElectricCar().getCarName());
            o.setColor(purchase.getColor());
            o.setOrderId(purchase.getOrderId());
            o.setPurchasePrice(purchase.getPurchasePrice());
            o.setPurchaseTime(purchase.getPurchaseTime());
            o.setPurchasingMethod(purchase.getPurchasingMethod());
            o.setMerchantUid(purchase.getMerchantUid());
            result.add(o);
        }
        return result;
    }
}
