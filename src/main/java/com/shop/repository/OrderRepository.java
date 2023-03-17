package com.shop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shop.entity.Member;
import com.shop.entity.OrderHistory;

public interface OrderRepository extends JpaRepository<OrderHistory, Long> {
	
	// Order의 회원아이디를 기준으로 일치하는 주문내역만을 가져오는 메서드
	@Query(value = "SELECT o FROM OrderHistory o WHERE o.mId=:id")
	Page<OrderHistory> getListById(@Param("id") String id, Pageable pageable);
	
	@Query("SELECT o FROM OrderHistory o WHERE o.oNumber =:oNumber")
	OrderHistory getOrderByNumber(@Param("oNumber") Long oNumber);
	
	// 테스트용
	@Query("SELECT m FROM Member m WHERE m.id =:id")
	Member getTest(@Param("id") String id);
	
}