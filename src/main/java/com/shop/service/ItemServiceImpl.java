package com.shop.service;


import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shop.entity.QItem;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.shop.dto.ItemDTO;
import com.shop.dto.PageRequestDTO;
import com.shop.dto.PageRequestDTO2;
import com.shop.dto.PageResultDTO;
import com.shop.dto.PageResultDTO2;
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
		.brand(dto.getBrand()).iSize(dto.getISize())
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
	public PageResultDTO<ItemDTO, Item> getListByPriceAsc(PageRequestDTO pageRequestDTO) {
		
		Function<Item, ItemDTO> fn = (en -> entityToDto(en));
		
		Page<Item> result = itemRepository.getItemPriceAsc(pageRequestDTO.getPageable(Sort.by("i_price").ascending()));
		
		
		return new PageResultDTO<>(result, fn);
	}
	
	@Override
	public PageResultDTO<ItemDTO, Item> getListByPriceDesc(PageRequestDTO pageRequestDTO) {
		
		Function<Item, ItemDTO> fn = (en -> entityToDto(en));
		
		Page<Item> result = itemRepository.getItemPriceDesc(pageRequestDTO.getPageable(Sort.by("i_price").descending()));
		
		
		return new PageResultDTO<>(result, fn);
	}
	
	
	@Override
	public ItemDTO read(Long iNumber) {
		
		Item result = itemRepository.getItemByNumber(iNumber);
		
		return entityToDto(result);
	}
	
	@Override
	public Long readAll() {
		
		Long count = itemRepository.count();
		
		return count;
	}
	
	@Override
	public ItemDTO order(Long iNumber) {
		
		Item result = itemRepository.getItemByNumber(iNumber);
		
		return entityToDto(result);
	}
	
	@Override
	public PageResultDTO<ItemDTO, Item> getTopList(PageRequestDTO pageRequestDTO) {
		
		Function<Item, ItemDTO> fn = (en -> entityToDto(en));
		
		Page<Item> result = itemRepository.getTop(pageRequestDTO.getPageable(Sort.by("iNumber").ascending()));
		
		return new PageResultDTO<>(result, fn);
	}
	
	@Override
	public PageResultDTO<ItemDTO, Item> getBottomList(PageRequestDTO pageRequestDTO) {
		
		Function<Item, ItemDTO> fn = (en -> entityToDto(en));
		
		Page<Item> result = itemRepository.getBottom(pageRequestDTO.getPageable(Sort.by("iNumber").ascending()));
		
		return new PageResultDTO<>(result, fn);
	}
	
	@Override
	public PageResultDTO<ItemDTO, Item> getFootwearList(PageRequestDTO pageRequestDTO) {
		
		Function<Item, ItemDTO> fn = (en -> entityToDto(en));
		
		Page<Item> result = itemRepository.getFootwear(pageRequestDTO.getPageable(Sort.by("iNumber").ascending()));
		
		return new PageResultDTO<>(result, fn);
	}
	
	@Override
	public PageResultDTO<ItemDTO, Item> getBagList(PageRequestDTO pageRequestDTO) {
		
		Function<Item, ItemDTO> fn = (en -> entityToDto(en));
		
		Page<Item> result = itemRepository.getBag(pageRequestDTO.getPageable(Sort.by("iNumber").ascending()));
		
		return new PageResultDTO<>(result, fn);
	}
	
	@Override
	public PageResultDTO<ItemDTO, Item> getHeadwearList(PageRequestDTO pageRequestDTO) {
		
		Function<Item, ItemDTO> fn = (en -> entityToDto(en));
		
		Page<Item> result = itemRepository.getHeadwear(pageRequestDTO.getPageable(Sort.by("iNumber").ascending()));
		
		return new PageResultDTO<>(result, fn);
	}
	
	@Override
	public PageResultDTO<ItemDTO, Item> getTechList(PageRequestDTO pageRequestDTO) {
		
		Function<Item, ItemDTO> fn = (en -> entityToDto(en));
		
		Page<Item> result = itemRepository.getTech(pageRequestDTO.getPageable(Sort.by("iNumber").ascending()));
		
		return new PageResultDTO<>(result, fn);
	}
	
	@Override
	public PageResultDTO2<ItemDTO, Item> getLimitList(PageRequestDTO2 pageRequestDTO2) {
		
		Function<Item, ItemDTO> fn = (en -> entityToDto(en));
		
		Page<Item> result = itemRepository.getItem(pageRequestDTO2.getPageable(Sort.by("i_number").ascending()));
		
		return new PageResultDTO2<>(result, fn);
	}
	
	// querydsl 테스트
	private BooleanBuilder getFind(PageRequestDTO pageRequestDTO) {
		// 사용자가 요청한 검색 키워드 알아내기
		String type = pageRequestDTO.getType();	// n, b거나 모두 이거나
		
		// QS 도메인 생성
		QItem qItem = QItem.item;
		
		String keyword = pageRequestDTO.getKeyword();
		
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		
		// 쿼리DSL의 장점 : Entity 필드를 조회 조건으로 이용할 수 있다.
		
		// 검색 조건을 생성하는데 기본적으로 iNumber를 기준으로 먼저 검색 조건을 생성 한다.
		BooleanExpression booleanExpression = qItem.iNumber.gt(0L);
		// 생성된 조회건을 booleanExpression에 추가한다.
		// 이유는 repository.find...()에 들어갈 파라미터는 BooleanBuilder 객체이기 때문이다.
		booleanBuilder.and(booleanExpression);
		
		// 만약 검색 조건이 아무것도 없다면 일반 조회조건 즉, iNumber > 0 인 애들을 돌려준다.
		if(type == null || type.equals("") || type.isEmpty() || type.length() == 0) {
			return booleanBuilder;
		}
		
		// 아래서 사용될 조회 조건을 담는 booleanBuilder 또하나 생성
		BooleanBuilder findBuilder = new BooleanBuilder();
		
		
		// 어떤 필드(QDmain)에서 keyword를 찾아야 할지 요청 타입(type)을 검색 해본다.
		// 만약 아무런 type 조건이 없을 경우, 그냥 글번호를 기준으로 넘겨주도록 한다.
		if(type.contains("n")) {
			// 모든 조건을 or로 묶어서 추가한다.
			findBuilder.or(qItem.iName.contains(keyword));
		}
		if(type.contains("b")) {
			findBuilder.or(qItem.brand.contains(keyword));
		}
		
		// 위 조건 검색을 하나도 통합
		booleanBuilder.and(findBuilder);
		
		return booleanBuilder;
	}
	
}
