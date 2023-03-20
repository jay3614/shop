package com.shop.service;


import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shop.dto.ItemDTO;
import com.shop.dto.PageRequestDTO;
import com.shop.dto.PageResultDTO;
import com.shop.entity.Item;
import com.shop.repository.ItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
	
	private String fileDir = "https://i.imgur.com/";
	
	private final ItemRepository itemRepository;
	
	
	// 상품 번호를 통해 상품의 이미지를 가져오는 메서드
	@Override
	public ItemDTO getImg(Long number) {
		
		Optional<Item> result = itemRepository.findById(number);
		
		return result.isPresent()?entityToDto(result.get()):null;
	}
	
	// 상품을 추가하는 메서드
	@Override
	public Long management(ItemDTO dto, MultipartFile file) {
		
		
		if(file.isEmpty()) {
			return null;
		}
		
		// 요청한 원본 파일명 추출
		String orginName = file.getOriginalFilename();
		
		// 파일을 불러올 때 사용할 경로
		String savedPath = fileDir + orginName;
		
//		System.out.println("++++++" + savedPath);
		
		Item entity = dtoToEntity(dto).builder()
		.iCategory(dto.getICategory()).iDeliveryPrice(dto.getIDeliveryPrice())
		.iInfo(dto.getIInfo()).iInstock(dto.getIInstock())
		.iName(dto.getIName()).iPrice(dto.getIPrice())
		.iImg(savedPath).build();
		
		itemRepository.save(entity);
		
		return entity.getINumber();
	}
	
	@Override
	public PageResultDTO<ItemDTO, Item> getList(PageRequestDTO pageRequestDTO) {
		
		Function<Item, ItemDTO> fn = (en -> entityToDto(en));
		
		Page<Item> result = itemRepository.getItem(pageRequestDTO.getPageable(Sort.by("i_number").ascending()));
		
		
		return new PageResultDTO<>(result, fn);
	}
	
	@Override
	public PageResultDTO<ItemDTO, Item> getTopList(PageRequestDTO pageRequestDTO) {
		
		Function<Item, ItemDTO> fn = (en -> entityToDto(en));
		
		Page<Item> result = itemRepository.getTopItem(pageRequestDTO.getPageable(Sort.by("i_number").ascending()));
		
		
		return new PageResultDTO<>(result, fn);
	}
	
	@Override
	public PageResultDTO<ItemDTO, Item> getShoesList(PageRequestDTO pageRequestDTO) {
		
		Function<Item, ItemDTO> fn = (en -> entityToDto(en));
		
		Page<Item> result = itemRepository.getShoesItem(pageRequestDTO.getPageable(Sort.by("i_number").ascending()));
		
		
		return new PageResultDTO<>(result, fn);
	}
	
	@Override
	public ItemDTO read(Long iNumber) {
		
		Item result = itemRepository.getItemByNumber(iNumber);
		
		return entityToDto(result);
	}
	
	@Override
	public ItemDTO order(Long iNumber) {
		
		Item result = itemRepository.getItemByNumber(iNumber);
		
		return entityToDto(result);
	}
	
}
