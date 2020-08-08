package com.bitcamp.team_project_eco.electriccar;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QElectricCar is a Querydsl query type for ElectricCar
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QElectricCar extends EntityPathBase<ElectricCar> {

    private static final long serialVersionUID = -206523192L;

    public static final QElectricCar electricCar = new QElectricCar("electricCar");

    public final StringPath batteryCapacity = createString("batteryCapacity");

    public final StringPath color = createString("color");

    public final StringPath designOption = createString("designOption");

    public final StringPath fuelEfficiency = createString("fuelEfficiency");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath manufacturer = createString("manufacturer");

    public final StringPath manufacturingYyyyMm = createString("manufacturingYyyyMm");

    public final StringPath mileage = createString("mileage");

    public final StringPath price = createString("price");

    public final StringPath productionSite = createString("productionSite");

    public final StringPath rapidCharging = createString("rapidCharging");

    public final StringPath slowCharging = createString("slowCharging");

    public final StringPath subsidy = createString("subsidy");

    public final StringPath technicalOption = createString("technicalOption");

    public final StringPath trim = createString("trim");

    public QElectricCar(String variable) {
        super(ElectricCar.class, forVariable(variable));
    }

    public QElectricCar(Path<? extends ElectricCar> path) {
        super(path.getType(), path.getMetadata());
    }

    public QElectricCar(PathMetadata metadata) {
        super(ElectricCar.class, metadata);
    }

}

