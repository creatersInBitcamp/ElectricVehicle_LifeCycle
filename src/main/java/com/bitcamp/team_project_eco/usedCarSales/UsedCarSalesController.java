package com.bitcamp.team_project_eco.usedCarSales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/sales")
public class UsedCarSalesController {
    @Autowired UsedCarSalesService usedCarSalesService;

    @PostMapping("/register")
    public boolean register(@RequestBody SalesVO sales) {
        return usedCarSalesService.insert(sales);
    }
}
