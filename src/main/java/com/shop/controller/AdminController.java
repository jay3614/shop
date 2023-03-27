package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.shop.dto.ItemDTO;
import com.shop.dto.PageRequestDTO;
import com.shop.dto.PageRequestDTO2;
import com.shop.service.ItemService;

import lombok.RequiredArgsConstructor;

//관리자페이지를 mapping 하기 위한 별도의 클래스
//한 클래스에 넣어두면 작동이 안됨
@Controller
@RequiredArgsConstructor
public class AdminController{
	
	private final ItemService itemService;
	
	@GetMapping("/adminList")
	public void adminList(PageRequestDTO pageRequestDTO, Model model) {
		model.addAttribute("list", itemService.getList(pageRequestDTO));
	}
	
	@GetMapping("/insertItem")
	public void insertItem() {
		
	}
	
	@GetMapping("/modify")
	public void modify(Long iNumber, @ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO, Model model) {
		
		ItemDTO itemDTO = itemService.read(iNumber);
		
		System.out.println();
		System.out.println("itemDTO : " + itemDTO);
		System.out.println();
		
		model.addAttribute("itemDTO", itemDTO);
	}
	
	@GetMapping("/modifyList")
	public void modifyList(PageRequestDTO pageRequestDTO, PageRequestDTO2 pageRequestDTO2, Model model) {
		
		model.addAttribute("itemDTO", itemService.getList(pageRequestDTO));
		
	}
	
	@GetMapping("/modify-detail")
	public void detail(Long iNumber, PageRequestDTO pageRequestDTO, PageRequestDTO2 pageRequestDTO2, Model model) {
		
		ItemDTO itemDTO = itemService.read(iNumber);
		
		model.addAttribute("item", itemDTO);
		model.addAttribute("limitDTO", itemService.getLimitList(pageRequestDTO2));
	}
	
	
}