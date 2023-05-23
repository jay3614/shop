package com.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ShopPlusApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopPlusApplication.class, args);
	}

}
