package com.project.movementbody.controller.member;

import com.project.movementbody.model.Member;
import com.project.movementbody.service.member.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Api(value = "MemberController V1")
public class MemberController {

    @Autowired
    MemberService memberService;
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK !!"),
            @ApiResponse(code = 500, message = "Internal Server Error !!"),
            @ApiResponse(code = 404, message = "Not Found !!")
    })
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
   @DeleteMapping("/member/deleteMember")
   public boolean deleteMember(@RequestBody Member member) {
       return memberService.delete(member);
   }
    
}
