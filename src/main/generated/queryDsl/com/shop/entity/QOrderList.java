package com.shop.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QOrderList is a Querydsl query type for OrderList
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOrderList extends EntityPathBase<OrderList> {

    private static final long serialVersionUID = 2099348460L;

    public static final QOrderList orderList = new QOrderList("orderList");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    //inherited
    public final StringPath createdDate = _super.createdDate;

    public final StringPath deliveryMessage = createString("deliveryMessage");

    public final StringPath deliveryStatus = createString("deliveryStatus");

    public final StringPath detailAddress = createString("detailAddress");

    public final StringPath img = createString("img");

    public final StringPath iNumber = createString("iNumber");

    public final NumberPath<Long> mId = createNumber("mId", Long.class);

    public final StringPath mName = createString("mName");

    public final NumberPath<Long> oCount = createNumber("oCount", Long.class);

    public final NumberPath<Long> oDeliveryPrice = createNumber("oDeliveryPrice", Long.class);

    public final NumberPath<Long> oGetPoint = createNumber("oGetPoint", Long.class);

    public final NumberPath<Long> oItemPrice = createNumber("oItemPrice", Long.class);

    public final StringPath oName = createString("oName");

    public final NumberPath<Long> oNumber = createNumber("oNumber", Long.class);

    public final NumberPath<Long> oTotalPrice = createNumber("oTotalPrice", Long.class);

    public final NumberPath<Long> oUsePoint = createNumber("oUsePoint", Long.class);

    public final StringPath paymentMethod = createString("paymentMethod");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final StringPath roadAddress = createString("roadAddress");

    //inherited
    public final StringPath updatedDate = _super.updatedDate;

    public QOrderList(String variable) {
        super(OrderList.class, forVariable(variable));
    }

    public QOrderList(Path<? extends OrderList> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrderList(PathMetadata metadata) {
        super(OrderList.class, metadata);
    }

}

