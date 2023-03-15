package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shop.entity.OrderHistory;

public interface OrderRepository extends JpaRepository<OrderHistory, Long> {
	
	// member의 id를 기준으로 주문한 내역을 조회해서 주문한 상품의 갯수를 가져오는 메서드
//	@Query("SELECT COUNT(o) FROM OrderHistory o WHERE o.member.id=id")
//	Long getCountByNumber(@Param("id") String id);
	@Query("SELECT COUNT(o) FROM Member i LEFT OUTER JOIN OrderHistory o ON o.member.id = i WHERE i.id=:id")
	Long getCountByNumber(@Param("id") String id);
	
	
	// Order의 주문번호를 기준으로 주문내역을 가져오는 메서드
	@Query("SELECT o FROM Member i LEFT OUTER JOIN OrderHistory o ON o.member.id = i WHERE i.id=:id")
	List<OrderHistory> getOrderById(@Param("id") String id);
	
	// order의 주문내역 중 oNumber만 가져오는 메서드
	@Query("SELECT o.oNumber FROM Member i LEFT OUTER JOIN OrderHistory o ON o.member.id = i WHERE i.id=:id")
	Long[] getNumberById(@Param("id") String id);
	
}