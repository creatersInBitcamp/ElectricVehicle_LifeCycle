package com.bitcamp.team_project_eco.test;

import com.bitcamp.team_project_eco.electriccar.ElectricCar;
import com.bitcamp.team_project_eco.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter @ToString(exclude = "")
@Table(name = "test")
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 40)
    private String yyyymmdd;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_seq")
    private User user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "eccar_id")
    private ElectricCar eeletricCar;

    public TestEntity() { }

    public TestEntity(String yyyymmdd, User user, ElectricCar electricCar) {
        this. yyyymmdd = yyyymmdd;
        setUser(user);
        setEeletricCar(electricCar);
    }
}
