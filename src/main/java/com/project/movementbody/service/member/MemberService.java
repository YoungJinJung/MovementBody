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
    public int createMemberInfo(Member memberInfo) {
    	  int result = memberRepository.createMemberInfo(memberInfo);
    	  if(result <= 0 ) {
    		  System.out.println(this.getClass().getSimpleName() + "Insert Error");
    	  }
    	  
    	  return result;
    	
    }
    
    
}
