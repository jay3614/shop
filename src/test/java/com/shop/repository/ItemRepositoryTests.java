package com.shop.repository;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Item;


@SpringBootTest
public class ItemRepositoryTests {
	
	@Autowired
	private ItemRepository itemRepository;
	
	// 스트림 이용해서 Member 테이블에 100개의 데이터를 한 번에 insert
	@Test
	public void insertDummies() {
		
		IntStream.rangeClosed(1, 20).forEach(i -> {
			Item item = Item.builder().iName("신발1").iCategory("30")
					.iPrice(150000L).iDeliveryPrice(5000L)
					.iInfo("좋은 신발").iInstock(30L)
					.iImg("https://i.imgur.com/UHRXuoe.png").build();
			
			itemRepository.save(item);
		});
	}
	
}
