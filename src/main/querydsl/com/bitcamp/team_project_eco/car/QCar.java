package com.bitcamp.team_project_eco.car;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCar is a Querydsl query type for Car
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCar extends EntityPathBase<Car> {

    private static final long serialVersionUID = 256359394L;

    public static final QCar car = new QCar("car");

    public final StringPath accelerationPerformance = createString("accelerationPerformance");

    public final StringPath backDistance = createString("backDistance");

    public final StringPath brand = createString("brand");

    public final NumberPath<Long> carId = createNumber("carId", Long.class);

    public final StringPath carName = createString("carName");

    public final StringPath CO2Emissions = createString("CO2Emissions");

    public final StringPath drivingMethod = createString("drivingMethod");

    public final StringPath engineType = createString("engineType");

    public final StringPath exhaustVolume = createString("exhaustVolume");

    public final StringPath frontBraking = createString("frontBraking");

    public final StringPath frontDistance = createString("frontDistance");

    public final StringPath frontSuspension = createString("frontSuspension");

    public final StringPath frontWheel = createString("frontWheel");

    public final StringPath fuel = createString("fuel");

    public final StringPath fuelEfficiency = createString("fuelEfficiency");

    public final StringPath height = createString("height");

    public final StringPath img = createString("img");

    public final StringPath length = createString("length");

    public final StringPath maximumOutput = createString("maximumOutput");

    public final StringPath maximumTorque = createString("maximumTorque");

    public final StringPath passengersNumber = createString("passengersNumber");

    public final StringPath price = createString("price");

    public final StringPath rearBraking = createString("rearBraking");

    public final StringPath rearSuspension = createString("rearSuspension");

    public final StringPath rearWheel = createString("rearWheel");

    public final StringPath steering = createString("steering");

    public final StringPath superchargeMethod = createString("superchargeMethod");

    public final StringPath topSpeed = createString("topSpeed");

    public final StringPath transmission = createString("transmission");

    public final StringPath weight = createString("weight");

    public final StringPath wheelBase = createString("wheelBase");

    public final StringPath width = createString("width");

    public QCar(String variable) {
        super(Car.class, forVariable(variable));
    }

    public QCar(Path<? extends Car> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCar(PathMetadata metadata) {
        super(Car.class, metadata);
    }

}

