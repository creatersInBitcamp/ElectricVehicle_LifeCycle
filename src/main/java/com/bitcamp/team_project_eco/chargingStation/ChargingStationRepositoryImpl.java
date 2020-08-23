package com.bitcamp.team_project_eco.chargingStation;

import com.bitcamp.team_project_eco.car.CarRepositoryImpl;
import com.bitcamp.team_project_eco.electriccar.ElectricCar;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import static com.bitcamp.team_project_eco.electriccar.QElectricCar.*;
import static com.bitcamp.team_project_eco.chargingStation.QChargingStation.*;

import java.util.List;
import java.util.Optional;

interface CustomedChargingStationRepository{
    List<ChargingStation> getMycarChargingStation(Optional<ElectricCar> eccar);
}

@Repository
public class ChargingStationRepositoryImpl extends QuerydslRepositorySupport implements CustomedChargingStationRepository{
    private final JPAQueryFactory jpaQueryFactory;
    public ChargingStationRepositoryImpl(JPAQueryFactory jpaQueryFactory){
        super(ChargingStation.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<ChargingStation> getMycarChargingStation(Optional<ElectricCar> eccar) {
        List<ChargingStation> chargingStationList = jpaQueryFactory
                .selectFrom(chargingStation)
                .where(chargingStation.chargerType.contains(eccar.get().getBoostingCharge()))
                .fetch();
        return chargingStationList;
    }
}
