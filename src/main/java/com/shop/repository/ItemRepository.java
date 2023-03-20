package com.shop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shop.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	
	// Item의 iNumber를 기준으로 상품 상세를 가져오는 메서드 선언
	@Query("SELECT i FROM Item i WHERE i.iNumber =:iNumber")
	Item getItemByNumber(@Param("iNumber") Long iNumber);
	
//	@Query(value = "SELECT i FROM Item i")
	@Query(value = "SELECT * FROM Item WHERE i_number > 0 ORDER BY i_number ASC", nativeQuery = true)
	Page<Item> getItem(Pageable pageable);
	
	@Query(value = "SELECT * FROM Item WHERE i_number > 0 AND i_category = 10 ORDER BY i_number ASC", nativeQuery = true)
	Page<Item> getTopItem(Pageable pageable);
	
	@Query(value = "SELECT * FROM Item WHERE i_number > 0 AND i_category = 30 ORDER BY i_number ASC", nativeQuery = true)
	Page<Item> getShoesItem(Pageable pageable);
	
	
}
