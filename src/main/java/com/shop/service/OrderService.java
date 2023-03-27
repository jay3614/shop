package com.shop.service;

import com.shop.dto.MemberDTO;
import com.shop.dto.OrderDTO;
import com.shop.dto.PageRequestDTO;
import com.shop.dto.PageResultDTO;
import com.shop.entity.Member;
import com.shop.entity.OrderHistory;

public interface OrderService {
	
	// 주문 내역 출력하는 변환 메서드
	default OrderDTO entityToDto(OrderHistory entity) {
		
		OrderDTO dto = OrderDTO.builder().oNumber(entity.getONumber())
				.iNumber(entity.getINumber()).oCount(entity.getOCount())
				.oItemPrice(entity.getOItemPrice()).oDeliveryPrice(entity.getODeliveryPrice())
				.oTotalPrice(entity.getOTotalPrice())
				.oName(entity.getOName()).img(entity.getImg())
				.oGetPoint(entity.getOGetPoint()).build();
		
		return dto;
	}
	
	// 테스트용
	default MemberDTO entityToDto2(Member entity) {
		
		MemberDTO dto = MemberDTO.builder().id("user10").build();
		
		return dto;
	}
	//
	
//	PageResultDTO<OrderDTO, OrderHistory> getList(PageRequestDTO pageRequestDTO);
	
	OrderDTO read(Long oNumber);
	
	MemberDTO page(String id);
	
}
