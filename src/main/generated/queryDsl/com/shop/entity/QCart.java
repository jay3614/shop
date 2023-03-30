package com.shop.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCart is a Querydsl query type for Cart
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCart extends EntityPathBase<Cart> {

    private static final long serialVersionUID = -1161265088L;

    public static final QCart cart = new QCart("cart");

    public final NumberPath<Long> cId = createNumber("cId", Long.class);

    public final StringPath cImg = createString("cImg");

    public final StringPath cInfo = createString("cInfo");

    public final StringPath cItemName = createString("cItemName");

    public final NumberPath<Long> cPrice = createNumber("cPrice", Long.class);

    public QCart(String variable) {
        super(Cart.class, forVariable(variable));
    }

    public QCart(Path<? extends Cart> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCart(PathMetadata metadata) {
        super(Cart.class, metadata);
    }

}

