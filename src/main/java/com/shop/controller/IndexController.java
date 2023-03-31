package com.shop.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.config.auth.UserAdapter;
import com.shop.dto.BrandDTO;
import com.shop.dto.CartDTO;
import com.shop.dto.CategoryDTO;
import com.shop.dto.ItemDTO;
import com.shop.dto.PageRequestDTO;
import com.shop.dto.PageRequestDTO2;
import com.shop.dto.MemberDTO.ResponseDTO;
import com.shop.service.BrandService;
import com.shop.service.CartService;
import com.shop.service.CategoryService;
import com.shop.service.ItemService;
import com.shop.service.MemberService;
import com.shop.service.OrderService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Controller
public class IndexController {
	
	private final MemberService memberService;
	private final ItemService itemService;
	private final CartService cartService;
	private final CategoryService categoryService;
	private final BrandService brandService;
	private final OrderService orderService;
	
	@GetMapping("/index")
	public void goIndex(@ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO, Model model) {
		
		Long iNumber = 1L;
		
		ItemDTO itemDTO = itemService.read(iNumber);
		
		model.addAttribute("itemDTO", itemDTO);
	}
	
	@GetMapping("/product")
	public void product(PageRequestDTO pageRequestDTO, PageRequestDTO2 pageRequestDTO2, Model model) {
		
		List<CategoryDTO> categoryDTOList = categoryService.getCategoryList();
		List<BrandDTO> brandDTOList = brandService.getBrandList();
		
		model.addAttribute("itemDTO", itemService.getList(pageRequestDTO));
		model.addAttribute("topDTO", itemService.getTopList(pageRequestDTO));
		model.addAttribute("itemAsc", itemService.getListByPriceAsc(pageRequestDTO));
		model.addAttribute("itemDesc", itemService.getListByPriceDesc(pageRequestDTO));
		model.addAttribute("count", itemService.readAll());
		model.addAttribute("categoryDTOList", categoryDTOList);
		model.addAttribute("brandDTOList", brandDTOList);
		
	}
	
	@GetMapping("/productPriceAsc")
	public void productAsc(PageRequestDTO pageRequestDTO, Model model) {
		
		List<CategoryDTO> categoryDTOList = categoryService.getCategoryList();
		List<BrandDTO> brandDTOList = brandService.getBrandList();
		
		model.addAttribute("itemAsc", itemService.getListByPriceAsc(pageRequestDTO));
		model.addAttribute("itemDesc", itemService.getListByPriceDesc(pageRequestDTO));
		model.addAttribute("count", itemService.readAll());
		model.addAttribute("categoryDTOList", categoryDTOList);
		model.addAttribute("brandDTOList", brandDTOList);
	}
	
	@GetMapping("/productPriceDesc")
	public void productDesc(PageRequestDTO pageRequestDTO, Model model) {
		
		List<CategoryDTO> categoryDTOList = categoryService.getCategoryList();
		List<BrandDTO> brandDTOList = brandService.getBrandList();
		
		model.addAttribute("itemAsc", itemService.getListByPriceAsc(pageRequestDTO));
		model.addAttribute("itemDesc", itemService.getListByPriceDesc(pageRequestDTO));
		model.addAttribute("count", itemService.readAll());
		model.addAttribute("categoryDTOList", categoryDTOList);
		model.addAttribute("brandDTOList", brandDTOList);
	}
	
	@GetMapping("/producttop")
	public void productTop(PageRequestDTO pageRequestDTO, Model model) {
		
		List<CategoryDTO> categoryDTOList = categoryService.getCategoryList();
		List<BrandDTO> brandDTOList = brandService.getBrandList();
		
		model.addAttribute("itemDTO", itemService.getTopList(pageRequestDTO));
		model.addAttribute("itemAsc", itemService.getListByPriceAsc(pageRequestDTO));
		model.addAttribute("itemDesc", itemService.getListByPriceDesc(pageRequestDTO));
		model.addAttribute("count", itemService.readAll());
		model.addAttribute("categoryDTOList", categoryDTOList);
		model.addAttribute("brandDTOList", brandDTOList);
	}
	
	@GetMapping("/productbottom")
	public void productBottom(PageRequestDTO pageRequestDTO, Model model) {
		
		List<CategoryDTO> categoryDTOList = categoryService.getCategoryList();
		List<BrandDTO> brandDTOList = brandService.getBrandList();
		
		model.addAttribute("itemDTO", itemService.getBottomList(pageRequestDTO));
		model.addAttribute("itemAsc", itemService.getListByPriceAsc(pageRequestDTO));
		model.addAttribute("itemDesc", itemService.getListByPriceDesc(pageRequestDTO));
		model.addAttribute("count", itemService.readAll());
		model.addAttribute("categoryDTOList", categoryDTOList);
		model.addAttribute("brandDTOList", brandDTOList);
	}
	
	@GetMapping("/productfootwear")
	public void productFootwear(PageRequestDTO pageRequestDTO, Model model) {
		
		List<CategoryDTO> categoryDTOList = categoryService.getCategoryList();
		List<BrandDTO> brandDTOList = brandService.getBrandList();
		
		model.addAttribute("itemDTO", itemService.getFootwearList(pageRequestDTO));
		model.addAttribute("itemAsc", itemService.getListByPriceAsc(pageRequestDTO));
		model.addAttribute("itemDesc", itemService.getListByPriceDesc(pageRequestDTO));
		model.addAttribute("count", itemService.readAll());
		model.addAttribute("categoryDTOList", categoryDTOList);
		model.addAttribute("brandDTOList", brandDTOList);
	}
	
	@GetMapping("/productbag")
	public void productBag(PageRequestDTO pageRequestDTO, Model model) {
		
		List<CategoryDTO> categoryDTOList = categoryService.getCategoryList();
		List<BrandDTO> brandDTOList = brandService.getBrandList();
		
		model.addAttribute("itemDTO", itemService.getBagList(pageRequestDTO));
		model.addAttribute("itemAsc", itemService.getListByPriceAsc(pageRequestDTO));
		model.addAttribute("itemDesc", itemService.getListByPriceDesc(pageRequestDTO));
		model.addAttribute("count", itemService.readAll());
		model.addAttribute("categoryDTOList", categoryDTOList);
		model.addAttribute("brandDTOList", brandDTOList);
	}
	
	@GetMapping("/productheadwear")
	public void productHeadwear(PageRequestDTO pageRequestDTO, Model model) {
		
		List<CategoryDTO> categoryDTOList = categoryService.getCategoryList();
		List<BrandDTO> brandDTOList = brandService.getBrandList();
		
		model.addAttribute("itemDTO", itemService.getHeadwearList(pageRequestDTO));
		model.addAttribute("itemAsc", itemService.getListByPriceAsc(pageRequestDTO));
		model.addAttribute("itemDesc", itemService.getListByPriceDesc(pageRequestDTO));
		model.addAttribute("count", itemService.readAll());
		model.addAttribute("categoryDTOList", categoryDTOList);
		model.addAttribute("brandDTOList", brandDTOList);
	}
	
	@GetMapping("/producttech")
	public void productTech(PageRequestDTO pageRequestDTO, Model model) {
		
		List<CategoryDTO> categoryDTOList = categoryService.getCategoryList();
		List<BrandDTO> brandDTOList = brandService.getBrandList();
		
		model.addAttribute("itemDTO", itemService.getTechList(pageRequestDTO));
		model.addAttribute("itemAsc", itemService.getListByPriceAsc(pageRequestDTO));
		model.addAttribute("itemDesc", itemService.getListByPriceDesc(pageRequestDTO));
		model.addAttribute("count", itemService.readAll());
		model.addAttribute("categoryDTOList", categoryDTOList);
		model.addAttribute("brandDTOList", brandDTOList);
	}
	
	@GetMapping("/shoping-cart")
	public String cart(Model model, @AuthenticationPrincipal UserAdapter user) {
		System.out.println("테스트1");
		Long id = user.getMemberDTO().getId();
		System.out.println("테스트2" + id);
		List<CartDTO> cartDTOList = cartService.getCartList(id);
		
		model.addAttribute("cartList", cartDTOList);
		
		return "content/cart/shoping-cart";
	}
	
	@GetMapping("/product-detail")
	public void detail(Long iNumber, PageRequestDTO pageRequestDTO, PageRequestDTO2 pageRequestDTO2, Model model, @AuthenticationPrincipal UserAdapter user) {
		
		Long member_id = user.getMemberDTO().getId();
		ResponseDTO responseDto = memberService.getById(member_id);
		
		ItemDTO itemDTO = itemService.read(iNumber);
		
		Long x = itemService.readAll();
		Long random1 = Math.round(Math.random() * (x-1)) + 1;
		Long random2 = Math.round(Math.random() * (x-1)) + 1;
		Long random3 = Math.round(Math.random() * (x-1)) + 1;
		Long random4 = Math.round(Math.random() * (x-1)) + 1;
		
		model.addAttribute("member", responseDto);
		model.addAttribute("recommend1", itemService.read(random1));
		model.addAttribute("recommend2", itemService.read(random2));
		model.addAttribute("recommend3", itemService.read(random3));
		model.addAttribute("recommend4", itemService.read(random4));
		model.addAttribute("item", itemDTO);
		model.addAttribute("limitDTO", itemService.getLimitList(pageRequestDTO2));
	}
	
	@GetMapping("/myPage2")
	public String myPage(@ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO, Model model, @AuthenticationPrincipal UserAdapter user) {
		
		Long id = user.getMemberDTO().getId();
		
		model.addAttribute("list", orderService.getList(id, pageRequestDTO));	// 사용자 id에 따른 전체 목록 출력
		model.addAttribute("coun1", orderService.beforeDeposit(id));	// 입금확인 숫자
		model.addAttribute("count2", orderService.beforeDelivery(id));	// 배송준비중 숫자
		model.addAttribute("count3", orderService.Deliverying(id));		// 배송중 숫자
		model.addAttribute("count4", orderService.afterDelivery(id));	// 배송완료 숫자
		model.addAttribute("count5", orderService.cancleStatus(id));	// 취소 숫자
		model.addAttribute("count6", orderService.exchangeStatus(id));	// 교환 숫자
		model.addAttribute("count7", orderService.returnStatus(id));	// 반품 숫자
		
		return "content/user/myPage";
	}
	
//	@GetMapping("/shopping-cart")
//	public String cart() {
//		
//		return "content/cart/shoping-cart";
//	}
	
}
