package com.shop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderHistory extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oNumber;	// 주문번호
	
	private Long oItemPrice;	// 상품가격
	private Long oCount;	// 주문 갯수
	private Long oTotalPrice;	// 최종결제금액
	private Long oDeliveryPrice;	// 배송비
	private Long oUsePoint;	// 사용포인트
	private Long oGetPoint;	// 적립포인트
	private String mName;	// 주문자명
	private String phoneNumber;	// 주문자 전화번호
	private String oName;	// 주문상품명
	private String iNumber;	// 상품번호
	private String img;	// 상품 이미지
	private String roadAddress;	// 도로명 주소
	private String detailAddress;	// 상세 주소
	private String paymentMethod;	// 결제 수단
	private String deliveryMessage;	// 배송 메세지
	
	

}
