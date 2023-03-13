package com.shop.entity.service;

import com.shop.dto.ItemDTO;
import com.shop.entity.Item;

public interface ItemService {
	
	ItemDTO getImg(Long iNumber);
	
	Long management(ItemDTO itemDTO);
	
	void update(ItemDTO dto);
	
	default Item dtoToEntity(ItemDTO dto) {
		
		Item item = Item.builder().iCategory(dto.getICategory())
				.iDeliveryPrice(dto.getIDeliveryPrice()).iImg(dto.getIImg())
				.iInfo(dto.getIInfo()).iInstock(dto.getIInstock())
				.iName(dto.getIName()).iPrice(dto.getIPrice())
				.build();
		System.out.println(item);	// iImg가 null로 들어옴
		return item;
	}
	
	default ItemDTO entityToDto(Item entity) {
			
		ItemDTO dto = ItemDTO.builder().iCategory(entity.getICategory())
				.iDeliveryPrice(entity.getIDeliveryPrice()).iImg(entity.getIImg())
				.iInfo(entity.getIInfo()).iInstock(entity.getIInstock())
				.iName(entity.getIName()).iPrice(entity.getIPrice())
				.build();
			
		return dto;
	}
}
