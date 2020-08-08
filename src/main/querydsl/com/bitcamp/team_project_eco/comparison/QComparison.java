package com.bitcamp.team_project_eco.comparison;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QComparison is a Querydsl query type for Comparison
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QComparison extends EntityPathBase<Comparison> {

    private static final long serialVersionUID = -1330199946L;

    public static final QComparison comparison = new QComparison("comparison");

    public final StringPath cc = createString("cc");

    public final StringPath fuel_efficiency = createString("fuel_efficiency");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath make = createString("make");

    public final StringPath manufacturer = createString("manufacturer");

    public final StringPath manufacturing_year = createString("manufacturing_year");

    public final StringPath mile_age = createString("mile_age");

    public final StringPath order_id = createString("order_id");

    public final StringPath picture = createString("picture");

    public final StringPath price = createString("price");

    public QComparison(String variable) {
        super(Comparison.class, forVariable(variable));
    }

    public QComparison(Path<? extends Comparison> path) {
        super(path.getType(), path.getMetadata());
    }

    public QComparison(PathMetadata metadata) {
        super(Comparison.class, metadata);
    }

}

