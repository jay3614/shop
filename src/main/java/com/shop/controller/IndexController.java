package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.shop.dto.ItemDTO;
import com.shop.dto.PageRequestDTO;
import com.shop.dto.PageRequestDTO2;
import com.shop.service.BrandService;
import com.shop.service.CategoryService;
import com.shop.service.ItemService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@Controller
public class IndexController {
	
	private final ItemService itemService;
	private final CategoryService categoryService;
	private final BrandService brandService;
	
	@GetMapping("/index")
	public void goIndex(@ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO, Model model) {
		
		Long iNumber = 1L;
		
		ItemDTO itemDTO = itemService.read(iNumber);
		
		model.addAttribute("itemDTO", itemDTO);
	}
	
	@GetMapping("/product")
	public void product(PageRequestDTO pageRequestDTO, PageRequestDTO2 pageRequestDTO2, Model model) {
		
		model.addAttribute("itemDTO", itemService.getList(pageRequestDTO));
		model.addAttribute("topDTO", itemService.getTopList(pageRequestDTO));
		model.addAttribute("itemAsc", itemService.getListByPriceAsc(pageRequestDTO));
		model.addAttribute("itemDesc", itemService.getListByPriceDesc(pageRequestDTO));
		model.addAttribute("count", itemService.readAll());
		model.addAttribute("categoryDTO", categoryService.getCategoryList(pageRequestDTO));	// getCategoryList
		model.addAttribute("brandDTO", brandService.getBrandList(pageRequestDTO));			// getBrandList
	}
	
	@GetMapping("/productPriceAsc")
	public void productAsc(PageRequestDTO pageRequestDTO, Model model) {
		
		model.addAttribute("itemAsc", itemService.getListByPriceAsc(pageRequestDTO));
		model.addAttribute("itemDesc", itemService.getListByPriceDesc(pageRequestDTO));
		model.addAttribute("count", itemService.readAll());
		model.addAttribute("categoryDTO", categoryService.getCategoryList(pageRequestDTO));
		model.addAttribute("brandDTO", brandService.getBrandList(pageRequestDTO));
	}
	
	@GetMapping("/productPriceDesc")
	public void productDesc(PageRequestDTO pageRequestDTO, Model model) {
		
		model.addAttribute("itemAsc", itemService.getListByPriceAsc(pageRequestDTO));
		model.addAttribute("itemDesc", itemService.getListByPriceDesc(pageRequestDTO));
		model.addAttribute("count", itemService.readAll());
		model.addAttribute("categoryDTO", categoryService.getCategoryList(pageRequestDTO));
		model.addAttribute("brandDTO", brandService.getBrandList(pageRequestDTO));
	}
	
	@GetMapping("/producttop")
	public void productTop(PageRequestDTO pageRequestDTO, Model model) {
		
		model.addAttribute("itemDTO", itemService.getTopList(pageRequestDTO));
		model.addAttribute("itemAsc", itemService.getListByPriceAsc(pageRequestDTO));
		model.addAttribute("itemDesc", itemService.getListByPriceDesc(pageRequestDTO));
		model.addAttribute("count", itemService.readAll());
		model.addAttribute("categoryDTO", categoryService.getCategoryList(pageRequestDTO));
		model.addAttribute("brandDTO", brandService.getBrandList(pageRequestDTO));
	}
	
	@GetMapping("/productbottom")
	public void productBottom(PageRequestDTO pageRequestDTO, Model model) {
		
		model.addAttribute("itemDTO", itemService.getBottomList(pageRequestDTO));
		model.addAttribute("itemAsc", itemService.getListByPriceAsc(pageRequestDTO));
		model.addAttribute("itemDesc", itemService.getListByPriceDesc(pageRequestDTO));
		model.addAttribute("count", itemService.readAll());
		model.addAttribute("categoryDTO", categoryService.getCategoryList(pageRequestDTO));
		model.addAttribute("brandDTO", brandService.getBrandList(pageRequestDTO));
	}
	
	@GetMapping("/productfootwear")
	public void productFootwear(PageRequestDTO pageRequestDTO, Model model) {
		
		model.addAttribute("itemDTO", itemService.getFootwearList(pageRequestDTO));
		model.addAttribute("itemAsc", itemService.getListByPriceAsc(pageRequestDTO));
		model.addAttribute("itemDesc", itemService.getListByPriceDesc(pageRequestDTO));
		model.addAttribute("count", itemService.readAll());
		model.addAttribute("categoryDTO", categoryService.getCategoryList(pageRequestDTO));
		model.addAttribute("brandDTO", brandService.getBrandList(pageRequestDTO));
	}
	
	@GetMapping("/productbag")
	public void productBag(PageRequestDTO pageRequestDTO, Model model) {
		
		model.addAttribute("itemDTO", itemService.getBagList(pageRequestDTO));
		model.addAttribute("itemAsc", itemService.getListByPriceAsc(pageRequestDTO));
		model.addAttribute("itemDesc", itemService.getListByPriceDesc(pageRequestDTO));
		model.addAttribute("count", itemService.readAll());
		model.addAttribute("categoryDTO", categoryService.getCategoryList(pageRequestDTO));
		model.addAttribute("brandDTO", brandService.getBrandList(pageRequestDTO));
	}
	
	@GetMapping("/productheadwear")
	public void productHeadwear(PageRequestDTO pageRequestDTO, Model model) {
		
		model.addAttribute("itemDTO", itemService.getHeadwearList(pageRequestDTO));
		model.addAttribute("itemAsc", itemService.getListByPriceAsc(pageRequestDTO));
		model.addAttribute("itemDesc", itemService.getListByPriceDesc(pageRequestDTO));
		model.addAttribute("count", itemService.readAll());
		model.addAttribute("categoryDTO", categoryService.getCategoryList(pageRequestDTO));
		model.addAttribute("brandDTO", brandService.getBrandList(pageRequestDTO));
	}
	
	@GetMapping("/producttech")
	public void productTech(PageRequestDTO pageRequestDTO, Model model) {
		
		model.addAttribute("itemDTO", itemService.getTechList(pageRequestDTO));
		model.addAttribute("itemAsc", itemService.getListByPriceAsc(pageRequestDTO));
		model.addAttribute("itemDesc", itemService.getListByPriceDesc(pageRequestDTO));
		model.addAttribute("count", itemService.readAll());
		model.addAttribute("categoryDTO", categoryService.getCategoryList(pageRequestDTO));
		model.addAttribute("brandDTO", brandService.getBrandList(pageRequestDTO));
	}
	
	@GetMapping("/shoping-cart")
	public void cart(PageRequestDTO pageRequestDTO, Model model) {
		
		model.addAttribute("list", itemService.getList(pageRequestDTO));
	}
	
	@GetMapping("/product-detail")
	public void detail(Long iNumber, PageRequestDTO pageRequestDTO, PageRequestDTO2 pageRequestDTO2, Model model) {
		
		ItemDTO itemDTO = itemService.read(iNumber);
		
		Long x = itemService.readAll();	// 25
		Long random1 = Math.round(Math.random() * x-2) + 1;	// (0~24)+1=25
		Long random2 = Math.round(Math.random() * x-2) + 1;
		Long random3 = Math.round(Math.random() * x-2) + 1;
		Long random4 = Math.round(Math.random() * x-2) + 1;
		
		model.addAttribute("recommend1", itemService.read(random1));
		model.addAttribute("recommend2", itemService.read(random2));
		model.addAttribute("recommend3", itemService.read(random3));
		model.addAttribute("recommend4", itemService.read(random4));
		
		
		model.addAttribute("item", itemDTO);
		
		model.addAttribute("limitDTO", itemService.getLimitList(pageRequestDTO2));
	}
	
	@GetMapping("/community")
	public void community(PageRequestDTO pageRequestDTO, Model model) {
		model.addAttribute("itemDTO", itemService.getList(pageRequestDTO));
		model.addAttribute("itemAsc", itemService.getListByPriceAsc(pageRequestDTO));
		model.addAttribute("itemDesc", itemService.getListByPriceDesc(pageRequestDTO));
		model.addAttribute("count", itemService.readAll());
		model.addAttribute("categoryDTO", categoryService.getCategoryList(pageRequestDTO));
		model.addAttribute("brandDTO", brandService.getBrandList(pageRequestDTO));
	}
	
}
