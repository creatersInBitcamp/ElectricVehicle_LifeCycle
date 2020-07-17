package com.bitcamp.team_project_eco.purchase;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name="purchase")
public class Purchas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id",nullable = false) private Long id;
    @Column(name="purchasing_method",nullable = false) private String purchasing_method;
    @Column(name="purchase_time",nullable = false) private String purchase_time;
    @Column(name="purchase_amount",nullable = false) private String purchase_amount ;
}
