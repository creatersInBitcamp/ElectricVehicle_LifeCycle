package com.bitcamp.team_project_eco.purchase;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderVO {
    Long orderId;
    String purchasingMethod, purchaseTime, purchasePrice, color, carName, userName;
}
