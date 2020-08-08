package com.bitcamp.team_project_eco.residualRate;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QResidualRate is a Querydsl query type for ResidualRate
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QResidualRate extends EntityPathBase<ResidualRate> {

    private static final long serialVersionUID = -1779225930L;

    public static final QResidualRate residualRate = new QResidualRate("residualRate");

    public final StringPath durableYears = createString("durableYears");

    public final NumberPath<Integer> fiveYears = createNumber("fiveYears", Integer.class);

    public final NumberPath<Integer> fourYears = createNumber("fourYears", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> oneYear = createNumber("oneYear", Integer.class);

    public final NumberPath<Integer> threeYears = createNumber("threeYears", Integer.class);

    public final NumberPath<Integer> twoYears = createNumber("twoYears", Integer.class);

    public QResidualRate(String variable) {
        super(ResidualRate.class, forVariable(variable));
    }

    public QResidualRate(Path<? extends ResidualRate> path) {
        super(path.getType(), path.getMetadata());
    }

    public QResidualRate(PathMetadata metadata) {
        super(ResidualRate.class, metadata);
    }

}

