package com.project.movementbody.service.member;

import com.project.movementbody.model.Member;
import com.project.movementbody.repository.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;


@Service
public class MemberService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    MemberRepository memberRepository;

    @Transactional
    public boolean create(Member member) {
        member.setMemberName(member.getMemberId() + Calendar.getInstance().getTimeInMillis());
        Member result = memberRepository.save(member);
        boolean resultFlag = !result.getMemberId().isEmpty();
        printLogging("Save", resultFlag, result.getMemberId());
        return resultFlag;
    }

    @Transactional
    public boolean update(Member member) {
        Member result = memberRepository.save(member);
        boolean resultFlag = !result.getMemberId().isEmpty();
        printLogging("Update", resultFlag, result.getMemberId());
        return resultFlag;
    }

    @Transactional
    public Member read(String memberMemberId) {
        Member result = memberRepository.findByMemberId(memberMemberId);
        boolean resultFlag = !result.getMemberId().isEmpty();
        printLogging("Select", resultFlag, result.getMemberId());
        return result;
    }

    @Transactional
    public boolean delete(Member member) {
        boolean resultFlag = false;
        try {
            memberRepository.delete(member);
            resultFlag = true;
            printLogging("Delete", resultFlag, member.getMemberId());
        } catch (Exception e) {
            printLogging("Delete", resultFlag, member.getMemberId());
            e.printStackTrace();
        }
        return resultFlag;
    }

    private void printLogging(String method, boolean flag, String logFactor) {
        if (flag) {
            logger.info("[" + this.getClass().getName()  + "- " + method + "] Success - MemberID : " + logFactor);
        } else {
            logger.error("[" + this.getClass().getName()  + "- " + method + "] Failed - MemberID : " + logFactor);
        }
    }
}
