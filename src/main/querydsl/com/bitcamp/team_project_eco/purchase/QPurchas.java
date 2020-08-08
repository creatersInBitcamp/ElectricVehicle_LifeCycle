package com.bitcamp.team_project_eco.purchase;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPurchas is a Querydsl query type for Purchas
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPurchas extends EntityPathBase<Purchas> {

    private static final long serialVersionUID = -365416561L;

    public static final QPurchas purchas = new QPurchas("purchas");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath purchase_amount = createString("purchase_amount");

    public final StringPath purchase_time = createString("purchase_time");

    public final StringPath purchasing_method = createString("purchasing_method");

    public QPurchas(String variable) {
        super(Purchas.class, forVariable(variable));
    }

    public QPurchas(Path<? extends Purchas> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPurchas(PathMetadata metadata) {
        super(Purchas.class, metadata);
    }

}

