package com.bitcamp.team_project_eco.variants;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QVariants is a Querydsl query type for Variants
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVariants extends EntityPathBase<Variants> {

    private static final long serialVersionUID = 160133462L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QVariants variants = new QVariants("variants");

    public final StringPath color = createString("color");

    public final com.bitcamp.team_project_eco.electriccar.QElectricCar electricCar;

    public final StringPath images = createString("images");

    public final NumberPath<Long> variantsId = createNumber("variantsId", Long.class);

    public QVariants(String variable) {
        this(Variants.class, forVariable(variable), INITS);
    }

    public QVariants(Path<? extends Variants> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QVariants(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QVariants(PathMetadata metadata, PathInits inits) {
        this(Variants.class, metadata, inits);
    }

    public QVariants(Class<? extends Variants> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.electricCar = inits.isInitialized("electricCar") ? new com.bitcamp.team_project_eco.electriccar.QElectricCar(forProperty("electricCar")) : null;
    }

}

