package com.bitcamp.team_project_eco.usedCarSales;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/sales")
public class UsedCarSalesController {
    private final UsedCarSalesService usedCarSalesService;

    public UsedCarSalesController(UsedCarSalesService usedCarSalesService) {
        this.usedCarSalesService = usedCarSalesService;
    }

    @PostMapping("/register")
    public boolean register(@RequestBody SalesVO sales) {
        return usedCarSalesService.insert(sales);
    }
}
