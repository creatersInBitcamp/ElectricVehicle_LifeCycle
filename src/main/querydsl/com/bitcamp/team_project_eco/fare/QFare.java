package com.bitcamp.team_project_eco.fare;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QFare is a Querydsl query type for Fare
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFare extends EntityPathBase<Fare> {

    private static final long serialVersionUID = 1975237974L;

    public static final QFare fare = new QFare("fare");

    public final StringPath arriveName = createString("arriveName");

    public final NumberPath<Integer> fareId = createNumber("fareId", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath startName = createString("startName");

    public final StringPath typeFive = createString("typeFive");

    public final StringPath typeFour = createString("typeFour");

    public final StringPath typeLightCar = createString("typeLightCar");

    public final StringPath typeOne = createString("typeOne");

    public final StringPath typeThree = createString("typeThree");

    public final StringPath typeTwo = createString("typeTwo");

    public QFare(String variable) {
        super(Fare.class, forVariable(variable));
    }

    public QFare(Path<? extends Fare> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFare(PathMetadata metadata) {
        super(Fare.class, metadata);
    }

}

