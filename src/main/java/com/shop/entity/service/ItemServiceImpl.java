package com.shop.entity.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dto.ItemDTO;
import com.shop.entity.Item;
import com.shop.repository.ItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemRepository itemRepository;

	@Override
	public ItemDTO getImg(Long iNumber) {
		
		Optional<Item> result = itemRepository.findById(iNumber);
		
		return result.isPresent()?entityToDto(result.get()):null;
	}

	@Override
	public Long management(ItemDTO dto) {
		
		Item entity = dtoToEntity(dto);
		
		itemRepository.save(entity);
		
		return entity.getINumber();
	}

	@Override
	public void update(ItemDTO dto) {
		Item item = itemRepository.getById(dto.getINumber());
		item.changeImg(dto.getIImg());
		
		// 수정했으니 save() 호출해서 완료 처리
		itemRepository.save(item);
	}
	
	
}
