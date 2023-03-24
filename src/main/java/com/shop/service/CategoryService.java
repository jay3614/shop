package com.shop.service;

import com.shop.dto.CategoryDTO;
import com.shop.dto.PageRequestDTO;
import com.shop.dto.PageRequestDTO2;
import com.shop.dto.PageResultDTO;
import com.shop.dto.PageResultDTO2;
import com.shop.entity.Category;

public interface CategoryService {
	
default CategoryDTO entityToDto(Category cEntity) {
		
		CategoryDTO categoryDTO = CategoryDTO.builder()
				.categoryNumber(cEntity.getCategoryNumber()).categoryName(cEntity.getCategoryName())
				.engName(cEntity.getEngName()).build();
		
		System.out.println("_+___" + categoryDTO);
		
		return categoryDTO;
	}
	
	PageResultDTO<CategoryDTO, Category> getCategoryList(PageRequestDTO pageRequestDTO);
	
}
