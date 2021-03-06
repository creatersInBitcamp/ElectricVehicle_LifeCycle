package com.bitcamp.team_project_eco.usedCar;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUsedCar is a Querydsl query type for UsedCar
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUsedCar extends EntityPathBase<UsedCar> {

    private static final long serialVersionUID = 1954593768L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUsedCar usedCar = new QUsedCar("usedCar");

    public final StringPath age = createString("age");

    public final com.bitcamp.team_project_eco.electriccar.QElectricCar electricCar;

    public final SimplePath<Img> img = createSimple("img", Img.class);

    public final BooleanPath main = createBoolean("main");

    public final StringPath mileage = createString("mileage");

    public final StringPath picture1 = createString("picture1");

    public final StringPath picture10 = createString("picture10");

    public final StringPath picture11 = createString("picture11");

    public final StringPath picture2 = createString("picture2");

    public final StringPath picture3 = createString("picture3");

    public final StringPath picture4 = createString("picture4");

    public final StringPath picture5 = createString("picture5");

    public final StringPath picture6 = createString("picture6");

    public final StringPath picture7 = createString("picture7");

    public final StringPath picture8 = createString("picture8");

    public final StringPath picture9 = createString("picture9");

    public final StringPath price = createString("price");

    public final BooleanPath sale = createBoolean("sale");

    public final NumberPath<Long> usedCarId = createNumber("usedCarId", Long.class);

    public final ListPath<com.bitcamp.team_project_eco.usedCarSales.UsedCarSales, com.bitcamp.team_project_eco.usedCarSales.QUsedCarSales> usedCarSalesList = this.<com.bitcamp.team_project_eco.usedCarSales.UsedCarSales, com.bitcamp.team_project_eco.usedCarSales.QUsedCarSales>createList("usedCarSalesList", com.bitcamp.team_project_eco.usedCarSales.UsedCarSales.class, com.bitcamp.team_project_eco.usedCarSales.QUsedCarSales.class, PathInits.DIRECT2);

    public final com.bitcamp.team_project_eco.user.QUser user;

    public QUsedCar(String variable) {
        this(UsedCar.class, forVariable(variable), INITS);
    }

    public QUsedCar(Path<? extends UsedCar> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUsedCar(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUsedCar(PathMetadata metadata, PathInits inits) {
        this(UsedCar.class, metadata, inits);
    }

    public QUsedCar(Class<? extends UsedCar> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.electricCar = inits.isInitialized("electricCar") ? new com.bitcamp.team_project_eco.electriccar.QElectricCar(forProperty("electricCar")) : null;
        this.user = inits.isInitialized("user") ? new com.bitcamp.team_project_eco.user.QUser(forProperty("user")) : null;
    }

}

