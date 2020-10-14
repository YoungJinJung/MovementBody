package com.project.movementbody.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.movementbody.model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
	
	int createMemberInfo(Member memberInfo);
	Member updateMemberInfo(Member memberInfo);
	//Member readMemberInfo(String memberId);
	
}
