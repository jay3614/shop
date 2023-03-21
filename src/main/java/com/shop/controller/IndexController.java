package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.shop.dto.ItemDTO;
import com.shop.dto.PageRequestDTO;
import com.shop.entity.Item;
import com.shop.repository.ItemRepository;
import com.shop.service.ItemService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {
	
	private final ItemService itemService;
	private final ItemRepository itemRepository;
	
	@GetMapping("/index")
	public void goIndex(@ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO, Model model) {
		
		Long iNumber = 1L;
		
		ItemDTO itemDTO = itemService.read(iNumber);
		
		System.out.println("++++ : " + itemDTO);
		
		model.addAttribute("itemDTO", itemDTO);
	}
	
	@GetMapping("/product")
	public void product(Long iNumber, PageRequestDTO pageRequestDTO, Model model) {
		
		model.addAttribute("itemDTO", itemService.getList(pageRequestDTO));
	}
	
	@GetMapping("/shoping-cart")
	public void cart(PageRequestDTO pageRequestDTO, Model model) {
		
		model.addAttribute("list", itemService.getList(pageRequestDTO));
	}
	
	@GetMapping("/product-detail")
	public void detail(Long iNumber, PageRequestDTO pageRequestDTO, Model model) {
		
		ItemDTO itemDTO = itemService.read(iNumber);
		
		Long x = itemService.readAll();
		Long random = Math.round(Math.random() * x-1) + 1;
		
		model.addAttribute("recommend", itemService.read(random));
		
		model.addAttribute("item", itemDTO);
	}
	
	
}
