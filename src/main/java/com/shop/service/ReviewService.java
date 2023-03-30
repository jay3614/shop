package com.shop.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.shop.dto.ReviewDTO;
import com.shop.entity.ReviewEntity;
import com.shop.entity.ReviewFileEntity;
import com.shop.repository.ReviewFileRepository;
import com.shop.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
//@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReviewService {

	private final ReviewRepository reviewRepository;

	private final ReviewFileRepository reviewFileRepository;

	
	
	/*public void save(ReviewDTO reviewDTO) throws IOException {
		// 파일 첨부 여부에 따라 로직분리
		if (reviewDTO.getReviewFile().isEmpty()) {
			// 첨부파일없음
			ReviewEntity reviewEntity = ReviewEntity.toSaveEntity(reviewDTO);
			reviewRepository.save(reviewEntity);
		} else {
			// 첨부파일잇음
			// 1.DTO에 담긴파일을 꺼냄
			// 2.파일의 이름을 가져오고
			// 3.서버저장용이름으로 만듬
			// 4.저장경로 설정
			// 5.해당경로에 파일저장....
			// 6.board_tabal에 해당 데이터 save처리
			// 7.board_file_table에 해당 데이터 save처리

			ReviewEntity reviewEntity = ReviewEntity.toSaveFileEntity(reviewDTO);
			Long saveId = reviewRepository.save(reviewEntity).getId();
			ReviewEntity reviews = reviewRepository.findById(saveId).get();
			for (MultipartFile reviewFile : reviewDTO.getReviewFile()) {

				// MultipartFile boardFile = boardDTO.getBoardFile();//1번처리
				String originalFilename = reviewFile.getOriginalFilename();// 2번처리
				String storedFileName = System.currentTimeMillis() + "_" + originalFilename;// 난수같이 3번처리
				String savePath = "C:/springboot_img/" + storedFileName;// 4번 저장경로 설정
				reviewFile.transferTo(new File(savePath));// 5번 저장

				ReviewFileEntity reviewFileEntity = ReviewFileEntity.toReviewFileEntity(reviews, originalFilename,
						storedFileName);
				reviewFileRepository.save(reviewFileEntity);
			}
		}
	}*/
	public void save(ReviewDTO reviewDTO) throws IOException {
		
		String fName = "C:\\springboot_img";
		File folder = new File(fName);
		
		if (!folder.exists()) // 폴더가 없다면 폴더 생성
			System.out.println(folder.mkdir());
		
		// 파일 첨부 여부에 따라 로직 분리
		if (reviewDTO.getReviewFile().isEmpty()) {
			// 첨부 파일 없음.
			ReviewEntity reviewEntity = ReviewEntity.toSaveEntity(reviewDTO);
			reviewRepository.save(reviewEntity);
		} else {
			// 첨부 파일 있음
				MultipartFile reviewFile = reviewDTO.getReviewFile();//1.dto에 담긴파일꺼냄
				
				String originalFilename = reviewFile.getOriginalFilename(); // 2.파일이름가져옴원래 파일네임
				String storedFileName = System.currentTimeMillis() + "_" + originalFilename; // 3.
				String savePath = "C:/springboot_img/" + storedFileName; // 4. 저장경로 설정.
				reviewFile.transferTo(new File(savePath)); // 5. 해당경로에 파일저장.
				
				ReviewEntity reviewEntity = ReviewEntity.toSaveFileEntity(reviewDTO);
				Long saveId = reviewRepository.save(reviewEntity).getId();
				ReviewEntity review = reviewRepository.findById(saveId).get();
				
				ReviewFileEntity reviewFileEntity = ReviewFileEntity.toReviewFileEntity(review, originalFilename,storedFileName);
				reviewFileRepository.save(reviewFileEntity);
			}
		}
	

	@Transactional
	public List<ReviewDTO> findAll() {
		List<ReviewEntity> reviewEntityList = reviewRepository.findAll();
		List<ReviewDTO> reviewDTOList = new ArrayList<>();
		for (ReviewEntity reviewEntity : reviewEntityList) {
			reviewDTOList.add(ReviewDTO.toReviewDTO(reviewEntity));
		}
		return reviewDTOList;
	}

	@Transactional
	public ReviewDTO findById(Long id) {
		Optional<ReviewEntity> optionalReviewEntity = reviewRepository.findById(id);
		if (optionalReviewEntity.isPresent()) {
			ReviewEntity reviewEntity = optionalReviewEntity.get();
			ReviewDTO reviewDTO = ReviewDTO.toReviewDTO(reviewEntity);
			return reviewDTO;
		} else {
			return null;
		}
	}

	public Page<ReviewDTO> paging(Pageable pageable) {
		int page = pageable.getPageNumber() - 1;
		int pageLimit = 3;
		Page<ReviewEntity> reviewEntities = reviewRepository
				.findAll(PageRequest.of(page, pageLimit, Sort.by(Sort.Direction.DESC, "regDate")));
		
		Page<ReviewDTO> reviewDTOS = reviewEntities.map(review -> new ReviewDTO(review.getReviewTitle(),
				review.getReviewContent(), review.getReviewRating(), review.getRegDate()));
		return reviewDTOS;
	}

}
