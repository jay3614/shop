package com.shop.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member extends BaseEntity {
	
	@Id
	private String id;
	private String pw;
	private String name;
	@Id
	private String email;
	private LocalDateTime regDate;
	private LocalDateTime modDate;
}
