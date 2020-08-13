package com.bitcamp.team_project_eco.usedCarSales;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUsedCarSales is a Querydsl query type for UsedCarSales
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUsedCarSales extends EntityPathBase<UsedCarSales> {

    private static final long serialVersionUID = 173815990L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUsedCarSales usedCarSales = new QUsedCarSales("usedCarSales");

    public final StringPath buyerAddr = createString("buyerAddr");

    public final StringPath buyerEmail = createString("buyerEmail");

    public final StringPath buyerName = createString("buyerName");

    public final StringPath buyerPhoneNumber = createString("buyerPhoneNumber");

    public final NumberPath<Long> reqId = createNumber("reqId", Long.class);

    public final NumberPath<Integer> sellerSeq = createNumber("sellerSeq", Integer.class);

    public final com.bitcamp.team_project_eco.usedCar.QUsedCar usedCar;

    public QUsedCarSales(String variable) {
        this(UsedCarSales.class, forVariable(variable), INITS);
    }

    public QUsedCarSales(Path<? extends UsedCarSales> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUsedCarSales(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUsedCarSales(PathMetadata metadata, PathInits inits) {
        this(UsedCarSales.class, metadata, inits);
    }

    public QUsedCarSales(Class<? extends UsedCarSales> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.usedCar = inits.isInitialized("usedCar") ? new com.bitcamp.team_project_eco.usedCar.QUsedCar(forProperty("usedCar"), inits.get("usedCar")) : null;
    }

}

