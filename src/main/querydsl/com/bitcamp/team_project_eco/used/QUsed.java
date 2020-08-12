package com.bitcamp.team_project_eco.used;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUsed is a Querydsl query type for Used
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUsed extends EntityPathBase<Used> {

    private static final long serialVersionUID = -1036738890L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUsed used = new QUsed("used");

    public final StringPath age = createString("age");

    public final com.bitcamp.team_project_eco.electriccar.QElectricCar electricCar;

    public final SimplePath<Img> img = createSimple("img", Img.class);

    public final StringPath mileage = createString("mileage");

    public final StringPath price = createString("price");

    public final NumberPath<Long> usedCarId = createNumber("usedCarId", Long.class);

    public final com.bitcamp.team_project_eco.user.QUser user;

    public QUsed(String variable) {
        this(Used.class, forVariable(variable), INITS);
    }

    public QUsed(Path<? extends Used> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUsed(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUsed(PathMetadata metadata, PathInits inits) {
        this(Used.class, metadata, inits);
    }

    public QUsed(Class<? extends Used> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.electricCar = inits.isInitialized("electricCar") ? new com.bitcamp.team_project_eco.electriccar.QElectricCar(forProperty("electricCar")) : null;
        this.user = inits.isInitialized("user") ? new com.bitcamp.team_project_eco.user.QUser(forProperty("user")) : null;
    }

}

