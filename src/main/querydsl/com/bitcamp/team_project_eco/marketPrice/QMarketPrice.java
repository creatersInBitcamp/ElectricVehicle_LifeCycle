package com.bitcamp.team_project_eco.marketPrice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMarketPrice is a Querydsl query type for MarketPrice
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMarketPrice extends EntityPathBase<MarketPrice> {

    private static final long serialVersionUID = -893661804L;

    public static final QMarketPrice marketPrice = new QMarketPrice("marketPrice");

    public final StringPath carType = createString("carType");

    public final StringPath depreciationRate = createString("depreciationRate");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath manufacturingYyyyMm = createString("manufacturingYyyyMm");

    public QMarketPrice(String variable) {
        super(MarketPrice.class, forVariable(variable));
    }

    public QMarketPrice(Path<? extends MarketPrice> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMarketPrice(PathMetadata metadata) {
        super(MarketPrice.class, metadata);
    }

}

