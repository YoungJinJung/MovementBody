package com.project.movementbody.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.movementbody.model.Member;
import com.project.movementbody.repository.MemberRepository;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;
    
    @Transactional
    public void create(Member member){
    	
    	Member result = memberRepository.save(member);
    	if(!result.getMemberId().isEmpty()) {
    		System.out.println(result.getMemberId() + "Insert Member Success");
    	}else {
    		System.out.println(result.getMemberId() + "Insert Member Fail");
    	}
        
    }
    
    @Transactional
    public void update(Member member) {
    	
    	Member result = memberRepository.save(member);
    	if(!result.getMemberId().isEmpty()) {
    		System.out.println(result.getMemberId() + "Update Member Success");
    	}else {
    		System.out.println(result.getMemberId() + "Update Member Fail");
    	}
    }
    
    @Transactional
    public Member read(String memberMemberId) {
    	
    	Member result = memberRepository.findByMemberId(memberMemberId);
    	if(!result.getMemberId().isEmpty()) {
    		System.out.println(result.getMemberId() + "Find Member Success");
    	}else {
    		System.out.println(result.getMemberId() + "Find Member Fail");
    	}
    	return result;
    }
    
    @Transactional
    public void delete(Member member) {
    	try {
    		memberRepository.delete(member);
    	}catch(Exception e) {
    		System.out.println("[회원정보DELETE] 에러발");
    	}
    }
    
}
