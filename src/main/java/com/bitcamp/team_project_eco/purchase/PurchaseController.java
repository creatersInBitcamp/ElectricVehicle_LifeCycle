package com.bitcamp.team_project_eco.purchase;

import com.bitcamp.team_project_eco.electriccar.ElectricCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired PurchaseService purchaseService;

    @GetMapping("/getall")
    public List<Purchase> getAllPurchase(){
        return (List<Purchase>) purchaseService.findAll();
    }

    @GetMapping("/getone/{eccarId}")
    public Optional<Purchase> getOnePurchase(@PathVariable String eccarId) {
        return purchaseService.findById(eccarId);
    }

    @PostMapping("/insert")
    public void insertPurchase(@RequestBody Purchase purchase) {
        purchaseService.insertPurchase(purchase);
    }
    @PostMapping("/update")
    public void updatePurchase(@RequestBody Purchase purchase) {
        purchaseService.updatePurchase(purchase);
    }

    @GetMapping("/delete")
    public void deletePurchase(@PathVariable String orderId) {
        purchaseService.delete(orderId);
    }

}
