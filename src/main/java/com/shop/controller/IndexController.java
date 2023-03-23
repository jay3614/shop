package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dto.ItemDTO;
import com.shop.dto.PageRequestDTO;
import com.shop.entity.Item;
import com.shop.repository.ItemRepository;
import com.shop.service.AdminService;
import com.shop.service.BrandService;
import com.shop.service.CategoryService;
import com.shop.service.ItemService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

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
		
		System.out.println("++++ : " + itemDTO);
		
		model.addAttribute("itemDTO", itemDTO);
	}
	
	@GetMapping("/product")
	public void product(PageRequestDTO pageRequestDTO, Model model) {
		
		model.addAttribute("itemDTO", itemService.getList(pageRequestDTO));
		model.addAttribute("itemAsc", itemService.getListByPriceAsc(pageRequestDTO));
		model.addAttribute("itemDesc", itemService.getListByPriceDesc(pageRequestDTO));
		model.addAttribute("count", itemService.readAll());
		model.addAttribute("categoryDTO", categoryService.getCategoryList(pageRequestDTO));
		model.addAttribute("brandDTO", brandService.getBrandList(pageRequestDTO));
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
	public void detail(Long iNumber, PageRequestDTO pageRequestDTO, Model model) {
		
		ItemDTO itemDTO = itemService.read(iNumber);
		
		Long x = itemService.readAll();
		Long random = Math.round(Math.random() * x-1) + 1;
		
		model.addAttribute("recommend", itemService.read(random));
		
		model.addAttribute("item", itemDTO);
	}
	
	@GetMapping("/quickView")
	public void quciView(Long iNumber, @ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO, Model model) {
		
		ItemDTO itemDTO = itemService.read(iNumber);
		
		model.addAttribute("quick", itemDTO);
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