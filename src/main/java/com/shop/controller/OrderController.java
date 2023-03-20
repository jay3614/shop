package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.shop.dto.MemberDTO;
import com.shop.dto.OrderDTO;
import com.shop.dto.PageRequestDTO;
import com.shop.service.OrderService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class OrderController {
	
	private final OrderService orderService;
	
	@GetMapping("/orderList")
	public void orderList(PageRequestDTO pageRequestDTO, Model model) {
		
		model.addAttribute("orderList", orderService.getList(pageRequestDTO));
	}
	
	@GetMapping("/orderDetail")
	public void orderDetail(Long oNumber, @ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO, Model model) {
		OrderDTO dto = orderService.read(oNumber);
		
		model.addAttribute("dto", dto);
	}
	
	// 테스트용
	@GetMapping("/myPage")
	public void myPage(String id, @ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO, Model model) {
		
		MemberDTO dto = orderService.page(id);
		
		model.addAttribute("myPage", dto);
	}
	
	
}
