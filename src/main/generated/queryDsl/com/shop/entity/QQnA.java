package com.shop.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQnA is a Querydsl query type for QnA
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QQnA extends EntityPathBase<QnA> {

    private static final long serialVersionUID = -175993692L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QQnA qnA = new QQnA("qnA");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    //inherited
    public final StringPath createdDate = _super.createdDate;

    public final StringPath qContent = createString("qContent");

    public final NumberPath<Long> qno = createNumber("qno", Long.class);

    public final StringPath qTitle = createString("qTitle");

    public final QMember qWriter;

    //inherited
    public final StringPath updatedDate = _super.updatedDate;

    public QQnA(String variable) {
        this(QnA.class, forVariable(variable), INITS);
    }

    public QQnA(Path<? extends QnA> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QQnA(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QQnA(PathMetadata metadata, PathInits inits) {
        this(QnA.class, metadata, inits);
    }

    public QQnA(Class<? extends QnA> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.qWriter = inits.isInitialized("qWriter") ? new QMember(forProperty("qWriter")) : null;
    }

}

