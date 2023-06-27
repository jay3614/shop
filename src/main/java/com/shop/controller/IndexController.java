package com.shop.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.shop.config.auth.UserAdapter;
import com.shop.dto.CartDTO;
import com.shop.dto.ItemDTO;
import com.shop.dto.PageRequestDTO;
import com.shop.service.CartService;
import com.shop.service.ItemService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {
	
	private final ItemService itemService;
	private final CartService cartService;
	
	@GetMapping({"/","/index"})
	public String goIndex(@ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO, Model model, @AuthenticationPrincipal UserAdapter user) {
		
		if(user == null) {
			ItemDTO itemDTO = itemService.read(1L);
			model.addAttribute("itemDTO", itemDTO);
			model.addAttribute("list1", itemService.getTopListTest());
			model.addAttribute("list4", itemService.getBagListTest());
			model.addAttribute("list6", itemService.getTechListTest());
		} else {
			
			Long id = user.getMemberDTO().getId();
			
			ItemDTO itemDTO = itemService.read(1L);
			
			Long cartCount = cartService.getCartCount(id);
			List<CartDTO> cartDTOList = cartService.getCartList(id);
			
			int totalPrice = 0;
			for (CartDTO cart : cartDTOList) {
				totalPrice += cart.getCPrice() * cart.getCount();
			}
			model.addAttribute("totalPrice", totalPrice);
			model.addAttribute("cartList", cartDTOList);
			model.addAttribute("count", cartCount);
			model.addAttribute("itemDTO", itemDTO);
			model.addAttribute("list1", itemService.getTopListTest());
			model.addAttribute("list4", itemService.getBagListTest());
			model.addAttribute("list6", itemService.getTechListTest());
		}
		return "/index";
	}
	
	@GetMapping("/contact")
	public String contact(Model model, @AuthenticationPrincipal UserAdapter user) {
		
		if(user == null) {
			
		} else {
		
			Long id = user.getMemberDTO().getId();
			List<CartDTO> cartDTOList = cartService.getCartList(id);
			List<CartDTO> cartList = cartService.getCartList(id);
			
			int totalPrice2 = 0;
		    for (CartDTO cart : cartList) {
		        totalPrice2 += cart.getCPrice() * cart.getCount();
		    }
		    
		    Long cartCount = cartService.getCartCount(id);
			
		    model.addAttribute("totalPrice", totalPrice2);
		    model.addAttribute("cartList", cartDTOList);
		    model.addAttribute("count", cartCount);
		}
		return "contact";
	}
	
	@GetMapping("/shopping-cart")
	public String cart(Long cNumber, Long oCount, Long dPrice, Model model, @AuthenticationPrincipal UserAdapter user) {
		
		Long id = user.getMemberDTO().getId();
		
		List<CartDTO> cartDTOList = cartService.getCartList(id);
		List<CartDTO> cartList = cartService.getCartList(id); // 장바구니 리스트 가져오기
		int totalPrice2 = 0;
	    for (CartDTO cart : cartList) {
	        totalPrice2 += cart.getCPrice() * cart.getCount();
	    }
	    Long cartCount = cartService.getCartCount(id);
		
	    model.addAttribute("totalPrice", totalPrice2);
	    model.addAttribute("cartList", cartDTOList);
	    model.addAttribute("count", cartCount);
	    
		return "content/cart/shopping-cart";
	}
	
	@GetMapping("/faq")
	public String goFAQ(Model model, @AuthenticationPrincipal UserAdapter user) {
		
		if(user == null) {
			
		} else {
			Long id = user.getMemberDTO().getId();
			Long cartCount = cartService.getCartCount(id);
			List<CartDTO> cartDTOList = cartService.getCartList(id);
			
			int totalPrice = 0;
			for (CartDTO cart : cartDTOList) {
				totalPrice += cart.getCPrice() * cart.getCount();
			}
			
	        model.addAttribute("totalPrice", totalPrice);
			model.addAttribute("cartList", cartDTOList);
			model.addAttribute("count", cartCount);
		}
		return "board/qna/faq";
	}
}
