package com.project.movementbody.service.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.movementbody.model.Member;
import com.project.movementbody.repository.MemberRepository;


@Service
public class MemberService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    MemberRepository memberRepository;

    @Transactional
    public void create(Member member) {
        Member result = memberRepository.save(member);
        boolean resultFlag = !result.getMemberId().isEmpty();
        printLogging("Save", resultFlag, result.getMemberId());
    }

    @Transactional
    public void update(Member member) {
        Member result = memberRepository.save(member);
        boolean resultFlag = !result.getMemberId().isEmpty();
        printLogging("Update", resultFlag, result.getMemberId());
    }

    @Transactional
    public Member read(String memberMemberId) {
        Member result = memberRepository.findByMemberId(memberMemberId);
        boolean resultFlag = !result.getMemberId().isEmpty();
        printLogging("Select", resultFlag, result.getMemberId());
        return result;
    }

    @Transactional
    public void delete(Member member) {
        try {
            memberRepository.delete(member);
            printLogging("Delete", true, member.getMemberId());
        } catch (Exception e) {
            printLogging("Delete", false, member.getMemberId());
            e.printStackTrace();
        }
    }

    private void printLogging(String method, boolean flag, String logFactor) {
        if (flag) {
            logger.info("[MemberService - " + method + "] Success - MemberID : " + logFactor);
        } else {
            logger.error("[MemberService - " + method + "] Failed - MemberID : " + logFactor);
        }
    }
}
