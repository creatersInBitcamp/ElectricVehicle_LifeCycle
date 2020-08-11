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

    public final StringPath mileage = createString("mileage");

    public final StringPath price = createString("price");

    public final NumberPath<Long> usedCarId = createNumber("usedCarId", Long.class);

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

