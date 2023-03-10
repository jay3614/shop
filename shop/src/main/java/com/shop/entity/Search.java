package com.shop.entity;

import javax.persistence.Entity;

import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Builder
public class Search {

	private String keyword;
	private Long count;
	
}
