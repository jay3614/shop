package com.shop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shop.dto.ItemDTO;
import com.shop.dto.UploadResultDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController	// 데이터만 주고받는 json
public class OrderController2 {
	
	// DB에 상품 정보를 저장하는 페이지를 연결하는 메서드
	@PostMapping("/insertOrder")
	public ResponseEntity<List<UploadResultDTO>> insertItem(MultipartFile[] uploadFiles, ItemDTO dto, RedirectAttributes redirectAttributes) {
		
		List<UploadResultDTO> resultDTOList = new ArrayList<>();
				
		return new ResponseEntity<>(resultDTOList, HttpStatus.OK);
	}
	
	
}