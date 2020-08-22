package com.bitcamp.team_project_eco.purchase;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping("/getall")
    public List<OrderVO> getAllPurchase(){
        return purchaseService.findAllOrder();
    }

    @GetMapping("/getall/{userSeq}")
    public List<OrderVO> getAllPurchase(@PathVariable Long userSeq){
        return purchaseService.findAllOrder(userSeq);
    }

    @GetMapping("/getone/{orderId}")
    public Optional<Purchase> getOnePurchase(@PathVariable String orderId) {
        return purchaseService.findById(orderId);
    }

    @PostMapping("/insert")
    public void insertPurchase(@RequestBody PurchaseVO purchase) {
        purchaseService.insertPurchase(purchase);
    }
    @PostMapping("/update")
    public void updatePurchase(@RequestBody Purchase purchase) {
        purchaseService.updatePurchase(purchase);
    }

    @GetMapping("/delete/{orderId}")
    public void deletePurchase(@PathVariable String orderId) {
        purchaseService.delete(orderId);
    }

}
