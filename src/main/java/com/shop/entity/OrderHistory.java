package com.shop.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
	private String iName;	// 상품명
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Member member;	// Member 테이블에서 id FK로 가져오기
	@ManyToOne(fetch = FetchType.LAZY)
	private Item item;	// Item 테이블에서 iNumber FK로 가져오기

}
