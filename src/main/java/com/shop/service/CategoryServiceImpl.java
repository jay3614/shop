package com.shop.service;

import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.shop.dto.CategoryDTO;
import com.shop.dto.PageRequestDTO;
import com.shop.dto.PageRequestDTO2;
import com.shop.dto.PageResultDTO;
import com.shop.dto.PageResultDTO2;
import com.shop.entity.Category;
import com.shop.repository.CategoryRepository;
import com.shop.repository.ItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
	
	private final CategoryRepository categoryRepository;
	
	@Override
	public PageResultDTO<CategoryDTO, Category> getCategoryList(PageRequestDTO pageRequestDTO) {
		
		Function<Category, CategoryDTO> fn = (en -> entityToDto(en));
		
		Page<Category> result = categoryRepository.getCategory(pageRequestDTO.getPageable(Sort.by("category_number").ascending()));
		
		System.out.println("_____ : " + result);
		
		System.out.println("+++ : " + result);
		
		return new PageResultDTO<>(result, fn);
	}
	
}
