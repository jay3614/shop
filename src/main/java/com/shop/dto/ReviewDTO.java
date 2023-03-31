package com.shop.dto;

import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

import com.shop.entity.ReviewEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 모든 필드를 매개변수로 하는 생성자
public class ReviewDTO {

	    private Long id;
	    private String reviewTitle;
	    private String reviewContent;
	    private int reviewRating;
	    private LocalDateTime regDate;
	    private LocalDateTime modDate;
	    private String reviewWriter;

	    private MultipartFile reviewFile;
	    private String originalFileName; //원본파일 이름
	    private String storedFileName;
	    private int fileAttached;
	    //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ추가ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		public static ReviewDTO toReviewDTO(ReviewEntity reviewEntity) {
	        ReviewDTO reviewDTO = new ReviewDTO();
	        reviewDTO.setId(reviewEntity.getId());
	        reviewDTO.setReviewTitle(reviewEntity.getReviewTitle());
	        reviewDTO.setReviewContent(reviewEntity.getReviewContent());
	        reviewDTO.setReviewRating(reviewEntity.getReviewRating());
	        reviewDTO.setRegDate(reviewEntity.getRegDate());

	        if (reviewEntity.getFileAttached()==0) {
	        	reviewDTO.setFileAttached(reviewEntity.getFileAttached()); // 0
	        } else {

	        	reviewDTO.setFileAttached(reviewEntity.getFileAttached()); // 1
	           
	      reviewDTO.setOriginalFileName(reviewEntity.getReviewFileEntityList().get(0).getOriginalFileName());
	      reviewDTO.setStoredFileName(reviewEntity.getReviewFileEntityList().get(0).getStoredFileName());	
	        
	      }
	        return reviewDTO;

	        }
	       

		public ReviewDTO(String reviewTitle, String reviewWriter, String reviewContent, int reviewRating, LocalDateTime regDate) {
			this.reviewTitle = reviewTitle;
			this.reviewWriter = reviewWriter;
			this.reviewContent = reviewContent;
			this.reviewRating = reviewRating;
			this.regDate = regDate;
		}
		
	}
	    
	    
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
