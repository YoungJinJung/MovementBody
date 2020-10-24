package com.project.movementbody.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.movementbody.model.Member;
import com.project.movementbody.service.food.FoodService;
import com.project.movementbody.service.member.MemberService;

@RestController
public class MemberController {
    @Autowired
    MemberService memberService;

    // 회원정보 CREATE
    @PostMapping("/api/v1/member/createMember")
    public void createMember(@RequestBody Member member) {
    	memberService.create(member);
    }
    
    // 회원정보 READ
    @GetMapping("/api/v1/member/readMember/{memberId}")
    public Member readMember( @PathVariable String memberId) {
    	return memberService.read(memberId);
    }
    
    // 회원정보 UPDATE
    @PutMapping("/api/v1/member/updateMember")
    public void updateMember(@RequestBody Member member) {
    	memberService.update(member);
    }
    
    // 회원정보 DELETE
   @DeleteMapping("/api/v1/member/deleteMember")
   public void deleteMember(@RequestBody Member member) {
	   memberService.delete(member);
   }
    
}
