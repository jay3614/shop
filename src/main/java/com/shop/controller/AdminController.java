package com.shop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shop.dto.ItemDTO;
import com.shop.dto.UploadResultDTO;
import com.shop.service.ItemService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequiredArgsConstructor
@RestController	// 데이터만 주고받는 json
@Log4j2
public class AdminController {
	
	private final ItemService itemService;
	
	// DB에 상품 정보를 저장하는 페이지를 연결하는 메서드
	@PostMapping("/uploadAjax")
	public ResponseEntity<List<UploadResultDTO>> uploadFile(MultipartFile[] uploadFiles, ItemDTO dto, RedirectAttributes redirectAttributes) {
		
		// 리턴될 DTO 컬렉션 초기화 작업
		List<UploadResultDTO> resultDTOList = new ArrayList<>();
		
		for(MultipartFile uploadFile : uploadFiles) {
			
			if(uploadFile.getContentType().startsWith("image") == false) {
	            log.warn("이미지 파일이 아님.");
	            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	         }
			
			// 업로드 처리
			try {
	            log.warn("================================== 파일 업로드 성공 ==================================");
	            
	            Long iNumber = itemService.management(dto, uploadFile);
	            redirectAttributes.addFlashAttribute("msg", iNumber);
	            
	         } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	         }
	      }
		
		return new ResponseEntity<>(resultDTOList, HttpStatus.OK);
	}
	
	
	// item DB 수정 메서드(재고 추가, 가격 변동, 이미지 수정)
	
	
	
	
	
}

@Controller
class UploadEx {
	
	@GetMapping("/uploadEx")
	public void uploadEx() {
		
		
		
	}
	
	
}