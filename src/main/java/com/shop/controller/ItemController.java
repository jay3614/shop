package com.shop.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.config.auth.UserAdapter;
import com.shop.dto.BrandDTO;
import com.shop.dto.CartDTO;
import com.shop.dto.CategoryDTO;
import com.shop.dto.ItemDTO;
import com.shop.dto.PageRequestDTO;
import com.shop.dto.MemberDTO.ResponseDTO;
import com.shop.service.BrandService;
import com.shop.service.CartService;
import com.shop.service.CategoryService;
import com.shop.service.ItemService;
import com.shop.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ItemController {

	private final ItemService itemService;
	private final MemberService memberService;
	private final CartService cartService;
	private final CategoryService categoryService;
	private final BrandService brandService;
	
	@GetMapping("/product")
	public String product(PageRequestDTO pageRequestDTO, Model model, @AuthenticationPrincipal UserAdapter user) {
		
		Long id = user.getMemberDTO().getId();
	
		List<CategoryDTO> categoryDTOList = categoryService.getCategoryList();
		List<BrandDTO> brandDTOList = brandService.getBrandList();
		List<CartDTO> cartDTOList = cartService.getCartList(id);
		Long cartCount = cartService.getCartCount(id);
		
		int totalPrice = 0;
		for (CartDTO cart : cartDTOList) {
			totalPrice += cart.getCPrice() * cart.getCount();
		}
		
		model.addAttribute("itemDTO", itemService.getList(pageRequestDTO));
		model.addAttribute("itemCount", itemService.readAll());
		model.addAttribute("categoryDTOList", categoryDTOList);
		model.addAttribute("brandDTOList", brandDTOList);
		model.addAttribute("totalPrice", totalPrice);
		model.addAttribute("cartList", cartDTOList);
		model.addAttribute("count", cartCount);
		
		return "/content/product";
	}

	@GetMapping("/product-detail")
	public void detail(Long iNumber, Model model, @AuthenticationPrincipal UserAdapter user) {
		
		Long member_id = user.getMemberDTO().getId();
		ResponseDTO responseDto = memberService.getById(member_id);
		ItemDTO itemDTO = itemService.read(iNumber);
		
		Long x = itemService.readAll();
		Long random1 = Math.round(Math.random() * (x-1)) + 1;
		Long random2 = Math.round(Math.random() * (x-1)) + 1;
		Long random3 = Math.round(Math.random() * (x-1)) + 1;
		Long random4 = Math.round(Math.random() * (x-1)) + 1;
		
		Long id = user.getMemberDTO().getId();
		Long cartCount = cartService.getCartCount(id);
		
		List<CartDTO> cartList = cartService.getCartList(id); // 장바구니 리스트 가져오기
		int totalPrice = 0;
	    for (CartDTO cart : cartList) {
	        totalPrice += cart.getCPrice()*cart.getCount();
	    }
	    
	    model.addAttribute("member", responseDto);
	    model.addAttribute("recommend1", itemService.read(random1));
	    model.addAttribute("recommend2", itemService.read(random2));
	    model.addAttribute("recommend3", itemService.read(random3));
	    model.addAttribute("recommend4", itemService.read(random4));
	    model.addAttribute("item", itemDTO);
	    model.addAttribute("cartList", cartList);
	    model.addAttribute("totalPrice", totalPrice);
	    model.addAttribute("count", cartCount);
	    
	}
	
	@GetMapping("/productCategory")
	public String productByCategory(PageRequestDTO pageRequestDTO, Model model, @AuthenticationPrincipal UserAdapter user,
	        @RequestParam("iCategory") Long iCategory) {

	    Long id = user.getMemberDTO().getId();
	    Long cartCount = cartService.getCartCount(id);

	    List<CategoryDTO> categoryDTOList = categoryService.getCategoryList();
	    List<BrandDTO> brandDTOList = brandService.getBrandList();
	    List<CartDTO> cartDTOList = cartService.getCartList(id);

	    int totalPrice = 0;
	    for (CartDTO cart : cartDTOList) {
	        totalPrice += cart.getCPrice() * cart.getCount();
	    }

	    model.addAttribute("itemDTO", itemService.getCategorySort(pageRequestDTO, iCategory));
	    model.addAttribute("itemCount", itemService.readAll());
	    model.addAttribute("categoryDTOList", categoryDTOList);
	    model.addAttribute("brandDTOList", brandDTOList);
	    model.addAttribute("totalPrice", totalPrice);
	    model.addAttribute("cartList", cartDTOList);
	    model.addAttribute("count", cartCount);
	    
	    return "content/product";
	}
	
	@GetMapping("/productBrand")
	public String productByBrand(PageRequestDTO pageRequestDTO, Model model, @AuthenticationPrincipal UserAdapter user,
			@RequestParam("brandNumber") Long brandNumber) {
		
		Long id = user.getMemberDTO().getId();
		Long cartCount = cartService.getCartCount(id);
		
		List<CategoryDTO> categoryDTOList = categoryService.getCategoryList();
		List<BrandDTO> brandDTOList = brandService.getBrandList();
		List<CartDTO> cartDTOList = cartService.getCartList(id);
		
		int totalPrice = 0;
		for (CartDTO cart : cartDTOList) {
			totalPrice += cart.getCPrice() * cart.getCount();
		}
		
		model.addAttribute("itemDTO", itemService.getBrandSort(pageRequestDTO, brandNumber));
		model.addAttribute("itemCount", itemService.readAll());
		model.addAttribute("categoryDTOList", categoryDTOList);
		model.addAttribute("brandDTOList", brandDTOList);
		model.addAttribute("totalPrice", totalPrice);
		model.addAttribute("cartList", cartDTOList);
		model.addAttribute("count", cartCount);
		
		return "content/product";
	}
	
	@GetMapping("/productSortAsc")
	public String productSortAsc(PageRequestDTO pageRequestDTO, Model model, @AuthenticationPrincipal UserAdapter user) {
		
		Long id = user.getMemberDTO().getId();
		Long cartCount = cartService.getCartCount(id);
		
		List<CategoryDTO> categoryDTOList = categoryService.getCategoryList();
		List<BrandDTO> brandDTOList = brandService.getBrandList();
		List<CartDTO> cartDTOList = cartService.getCartList(id);
		
		int totalPrice = 0;
		for (CartDTO cart : cartDTOList) {
			totalPrice += cart.getCPrice() * cart.getCount();
		}
		
		model.addAttribute("itemDTO", itemService.getPriceAsc(pageRequestDTO));
		model.addAttribute("itemCount", itemService.readAll());
		model.addAttribute("categoryDTOList", categoryDTOList);
		model.addAttribute("brandDTOList", brandDTOList);
		model.addAttribute("totalPrice", totalPrice);
		model.addAttribute("cartList", cartDTOList);
		model.addAttribute("count", cartCount);
		
		return "content/product";
	}
	
	@GetMapping("/productSortDesc")
	public String productSortDesc(PageRequestDTO pageRequestDTO, Model model, @AuthenticationPrincipal UserAdapter user) {
		
		Long id = user.getMemberDTO().getId();
		Long cartCount = cartService.getCartCount(id);
		
		List<CategoryDTO> categoryDTOList = categoryService.getCategoryList();
		List<BrandDTO> brandDTOList = brandService.getBrandList();
		List<CartDTO> cartDTOList = cartService.getCartList(id);
		
		int totalPrice = 0;
		for (CartDTO cart : cartDTOList) {
			totalPrice += cart.getCPrice() * cart.getCount();
		}
		
		model.addAttribute("itemDTO", itemService.getPriceDesc(pageRequestDTO));
		model.addAttribute("itemCount", itemService.readAll());
		model.addAttribute("categoryDTOList", categoryDTOList);
		model.addAttribute("brandDTOList", brandDTOList);
		model.addAttribute("totalPrice", totalPrice);
		model.addAttribute("cartList", cartDTOList);
		model.addAttribute("count", cartCount);
		
		return "content/product";
	}
	
	@GetMapping("/searchResult")
	public void productBySearch(PageRequestDTO pageRequestDTO, Model model, @AuthenticationPrincipal UserAdapter user,
			@RequestParam("keyword") String keyword) {
		
		Long id = user.getMemberDTO().getId();
		
		List<CategoryDTO> categoryDTOList = categoryService.getCategoryList();
		List<BrandDTO> brandDTOList = brandService.getBrandList();
		List<CartDTO> cartDTOList = cartService.getCartList(id);
		Long cartCount = cartService.getCartCount(id);
		
		int totalPrice = 0;
		for (CartDTO cart : cartDTOList) {
			totalPrice += cart.getCPrice() * cart.getCount();
		}
		
		model.addAttribute("itemDTO", itemService.getSearch(pageRequestDTO, keyword));
		model.addAttribute("itemCount", itemService.readAll());
		model.addAttribute("categoryDTOList", categoryDTOList);
		model.addAttribute("brandDTOList", brandDTOList);
		model.addAttribute("totalPrice", totalPrice);
		model.addAttribute("cartList", cartDTOList);
		model.addAttribute("count", cartCount);
		
	}
}
