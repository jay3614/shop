package com.shop.service;

import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.shop.dto.MemberDTO;
import com.shop.dto.OrderDTO;
import com.shop.dto.PageRequestDTO;
import com.shop.dto.PageResultDTO;
import com.shop.entity.Member;
import com.shop.entity.OrderHistory;
import com.shop.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

	private final OrderRepository orderRepository;
	
//	@Override
//	public PageResultDTO<OrderDTO, OrderHistory> getList(PageRequestDTO pageRequestDTO) {
//
//		Function<OrderHistory, OrderDTO> fn = (en -> entityToDto(en));
//		
//		String id = "user10";
//		
//		Page<OrderHistory> result = orderRepository.getListById(id, pageRequestDTO.getPageable(Sort.by("regDate").ascending()));
//		
//		return new PageResultDTO<>(result, fn);
//	}
	
	@Override
	public OrderDTO read(Long oNumber) {
		
		OrderHistory result = orderRepository.getOrderByNumber(oNumber);
		
		return entityToDto(result);
	}
	
	// 테스트용
	@Override
	public MemberDTO page(String id) {
		
		Member result = orderRepository.getTest(id);
		
		return entityToDto2(result);
	}
	//
}
