package com.bitcamp.team_project_eco.usedCarSales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales")
public class UsedCarSalesController {
    @Autowired UsedCarSalesService usedCarSalesService;
}
