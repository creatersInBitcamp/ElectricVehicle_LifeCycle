package com.bitcamp.team_project_eco.usedCar;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUsedCar is a Querydsl query type for UsedCar
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUsedCar extends EntityPathBase<UsedCar> {

    private static final long serialVersionUID = 1954593768L;

    public static final QUsedCar usedCar = new QUsedCar("usedCar");

    public final StringPath age = createString("age");

    public final StringPath mileage = createString("mileage");

    public final StringPath price = createString("price");

    public final NumberPath<Long> usedCarId = createNumber("usedCarId", Long.class);

    public QUsedCar(String variable) {
        super(UsedCar.class, forVariable(variable));
    }

    public QUsedCar(Path<? extends UsedCar> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUsedCar(PathMetadata metadata) {
        super(UsedCar.class, metadata);
    }

}

