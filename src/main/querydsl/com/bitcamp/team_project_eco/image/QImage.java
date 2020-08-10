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

    public final StringPath category = createString("category");

    public final NumberPath<Long> imageId = createNumber("imageId", Long.class);

    public final StringPath imgFile = createString("imgFile");

    public final StringPath imgName = createString("imgName");

    public final DateTimePath<org.joda.time.DateTime> uploadDate = createDateTime("uploadDate", org.joda.time.DateTime.class);

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

