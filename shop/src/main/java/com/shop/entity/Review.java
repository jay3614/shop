package com.shop.entity;

import javax.persistence.Id;

public class Review {
	
	@Id
	private Long rno;
	
	private String rTitle;
	private String rContent;
	private String rWirter;
	private String rImg;
	
	public void changerTitle(String title) {
		this.rTitle = title;
	}
	
	public void cangerContent(String content) {
		this.rContent = content;
	}

}
