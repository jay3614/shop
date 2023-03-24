package com.shop.service;

import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.shop.dto.BrandDTO;
import com.shop.dto.PageRequestDTO;
import com.shop.dto.PageRequestDTO2;
import com.shop.dto.PageResultDTO;
import com.shop.dto.PageResultDTO2;
import com.shop.entity.Brand;
import com.shop.repository.BrandRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
	
	private final BrandRepository brandRepository;
	
	@Override
	public PageResultDTO<BrandDTO, Brand> getBrandList(PageRequestDTO pageRequestDTO) {
		
		Function<Brand, BrandDTO> fn = (en -> BrandEntityToDto(en));
		
		Page<Brand> result = brandRepository.getBrand(pageRequestDTO.getPageable(Sort.by("brand_name").ascending()));
		return new PageResultDTO<>(result, fn);
	}
	
}
