package com.bitcamp.team_project_eco.image;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QImage is a Querydsl query type for Image
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QImage extends EntityPathBase<Image> {

    private static final long serialVersionUID = 1380323376L;

    public static final QImage image = new QImage("image");

    public final StringPath imageCate = createString("imageCate");

    public final NumberPath<Long> imageId = createNumber("imageId", Long.class);

    public final DateTimePath<org.joda.time.DateTime> updateDate = createDateTime("updateDate", org.joda.time.DateTime.class);

    public final StringPath url = createString("url");

    public QImage(String variable) {
        super(Image.class, forVariable(variable));
    }

    public QImage(Path<? extends Image> path) {
        super(path.getType(), path.getMetadata());
    }

    public QImage(PathMetadata metadata) {
        super(Image.class, metadata);
    }

}

