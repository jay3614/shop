package com.shop.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
public class Order extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oNumber;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Member oMember;
	@ManyToOne(fetch = FetchType.LAZY)
	private String oItemName;
	
	private String oItemInfo;
	private Long oItemPrice;
	
}
