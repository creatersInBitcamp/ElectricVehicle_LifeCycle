package com.bitcamp.team_project_eco.electriccar;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QElectricCar is a Querydsl query type for ElectricCar
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QElectricCar extends EntityPathBase<ElectricCar> {

    private static final long serialVersionUID = -206523192L;

    public static final QElectricCar electricCar = new QElectricCar("electricCar");

    public final StringPath accelerationPerformance = createString("accelerationPerformance");

    public final StringPath backDistance = createString("backDistance");

    public final StringPath boostingCharge = createString("boostingCharge");

    public final StringPath brand = createString("brand");

    public final StringPath carName = createString("carName");

    public final StringPath color = createString("color");

    public final StringPath distanceDriven = createString("distanceDriven");

    public final StringPath drivingMethod = createString("drivingMethod");

    public final NumberPath<Long> eccarId = createNumber("eccarId", Long.class);

    public final StringPath energy = createString("energy");

    public final BooleanPath eol = createBoolean("eol");

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

    public final StringPath modelName = createString("modelName");

    public final StringPath passengersNumber = createString("passengersNumber");

    public final StringPath price = createString("price");

    public final ListPath<com.bitcamp.team_project_eco.purchase.Purchase, com.bitcamp.team_project_eco.purchase.QPurchase> purchasesList = this.<com.bitcamp.team_project_eco.purchase.Purchase, com.bitcamp.team_project_eco.purchase.QPurchase>createList("purchasesList", com.bitcamp.team_project_eco.purchase.Purchase.class, com.bitcamp.team_project_eco.purchase.QPurchase.class, PathInits.DIRECT2);

    public final StringPath rearBraking = createString("rearBraking");

    public final StringPath rearSuspension = createString("rearSuspension");

    public final StringPath rearWheel = createString("rearWheel");

    public final StringPath slowCharging = createString("slowCharging");

    public final StringPath steering = createString("steering");

    public final StringPath transmission = createString("transmission");

    public final StringPath trim = createString("trim");

    public final ListPath<com.bitcamp.team_project_eco.usedCar.UsedCar, com.bitcamp.team_project_eco.usedCar.QUsedCar> usedCarList = this.<com.bitcamp.team_project_eco.usedCar.UsedCar, com.bitcamp.team_project_eco.usedCar.QUsedCar>createList("usedCarList", com.bitcamp.team_project_eco.usedCar.UsedCar.class, com.bitcamp.team_project_eco.usedCar.QUsedCar.class, PathInits.DIRECT2);

    public final StringPath weight = createString("weight");

    public final StringPath wheelBase = createString("wheelBase");

    public final StringPath width = createString("width");

    public final ListPath<com.bitcamp.team_project_eco.wishlist.Wishlist, com.bitcamp.team_project_eco.wishlist.QWishlist> wishlistList = this.<com.bitcamp.team_project_eco.wishlist.Wishlist, com.bitcamp.team_project_eco.wishlist.QWishlist>createList("wishlistList", com.bitcamp.team_project_eco.wishlist.Wishlist.class, com.bitcamp.team_project_eco.wishlist.QWishlist.class, PathInits.DIRECT2);

    public final StringPath yyyy = createString("yyyy");

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

