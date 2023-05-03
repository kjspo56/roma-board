package com.kjs.roma.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCommonField is a Querydsl query type for CommonField
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QCommonField extends EntityPathBase<CommonField> {

    private static final long serialVersionUID = -1740548332L;

    public static final QCommonField commonField = new QCommonField("commonField");

    public final DateTimePath<java.sql.Timestamp> modDate = createDateTime("modDate", java.sql.Timestamp.class);

    public final NumberPath<Integer> modMember = createNumber("modMember", Integer.class);

    public final DateTimePath<java.sql.Timestamp> regDate = createDateTime("regDate", java.sql.Timestamp.class);

    public final NumberPath<Integer> regMember = createNumber("regMember", Integer.class);

    public QCommonField(String variable) {
        super(CommonField.class, forVariable(variable));
    }

    public QCommonField(Path<? extends CommonField> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCommonField(PathMetadata metadata) {
        super(CommonField.class, metadata);
    }

}

