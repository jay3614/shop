package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Member;


public interface MemberRepository extends JpaRepository<Member, String> {

}
