package com.shop.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QItem is a Querydsl query type for Item
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QItem extends EntityPathBase<Item> {

    private static final long serialVersionUID = -1161068493L;

    public static final QItem item = new QItem("item");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    public final StringPath brand = createString("brand");

    //inherited
    public final StringPath createdDate = _super.createdDate;

    public final NumberPath<Long> iCategory = createNumber("iCategory", Long.class);

    public final NumberPath<Long> iDeliveryPrice = createNumber("iDeliveryPrice", Long.class);

    public final StringPath iImg = createString("iImg");

    public final StringPath iInfo = createString("iInfo");

    public final NumberPath<Long> iInstock = createNumber("iInstock", Long.class);

    public final StringPath iName = createString("iName");

    public final NumberPath<Long> iNumber = createNumber("iNumber", Long.class);

    public final NumberPath<Long> iPrice = createNumber("iPrice", Long.class);

    public final StringPath iSize = createString("iSize");

    //inherited
    public final StringPath updatedDate = _super.updatedDate;

    public QItem(String variable) {
        super(Item.class, forVariable(variable));
    }

    public QItem(Path<? extends Item> path) {
        super(path.getType(), path.getMetadata());
    }

    public QItem(PathMetadata metadata) {
        super(Item.class, metadata);
    }

}

