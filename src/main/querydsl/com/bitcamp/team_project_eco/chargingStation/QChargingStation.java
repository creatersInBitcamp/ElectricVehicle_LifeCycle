package com.bitcamp.team_project_eco.chargingStation;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QChargingStation is a Querydsl query type for ChargingStation
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QChargingStation extends EntityPathBase<ChargingStation> {

    private static final long serialVersionUID = 990492736L;

    public static final QChargingStation chargingStation = new QChargingStation("chargingStation");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QChargingStation(String variable) {
        super(ChargingStation.class, forVariable(variable));
    }

    public QChargingStation(Path<? extends ChargingStation> path) {
        super(path.getType(), path.getMetadata());
    }

    public QChargingStation(PathMetadata metadata) {
        super(ChargingStation.class, metadata);
    }

}

