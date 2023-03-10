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
	
	
}
