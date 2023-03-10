package com.shop.entity.service;

import com.shop.dto.ItemDTO;
import com.shop.entity.Item;

public interface ItemService {
	
	ItemDTO getImg(Long iNumber);
	
	default ItemDTO entityToDto(Item entity) {
			
		ItemDTO dto = ItemDTO.builder().iImg(entity.getIImg()).build();
			
		return dto;
	}
}
