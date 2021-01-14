package com.project.movementbody.controller.member;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.movementbody.model.Member;
import com.project.movementbody.service.food.FoodService;
import com.project.movementbody.service.member.MemberService;

@RestController
@RequestMapping("/api/v1")
@Api(value = "MemberController V1")
public class MemberController {
    @Autowired
    MemberService memberService;

    // 회원정보 CREATE
    @PostMapping("/member/createMember")
    public boolean createMember(@RequestBody Member member) {
        return memberService.create(member);
    }
    
    // 회원정보 READ
    @GetMapping("/member/readMember/{memberId}")
    public Member readMember( @PathVariable String memberId) {
    	return memberService.read(memberId);
    }
    
    // 회원정보 UPDATE
    @PutMapping("/member/updateMember")
    public boolean updateMember(@RequestBody Member member) {
        return memberService.update(member);
    }
    
    // 회원정보 DELETE
   @DeleteMapping("/api/v1/member/deleteMember")
   public boolean deleteMember(@RequestBody Member member) {
       return memberService.delete(member);
   }
    
}
