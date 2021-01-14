package com.project.movementbody.service.history;

import com.project.movementbody.controller.history.EatingHistoryController;
import com.project.movementbody.model.EatingHistory;
import com.project.movementbody.model.Member;
import com.project.movementbody.repository.EatingHistoryRepository;
import com.project.movementbody.repository.MemberRepository;
import com.project.movementbody.service.member.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EatingHistoryService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EatingHistoryRepository eatingHistoryRepository;

    @Autowired
    MemberRepository memberRepository;

    @Transactional
    public boolean insert(List<EatingHistory> eatingHistoryList) {
        int count = 0;
        for(int idx = 0 ; idx < eatingHistoryList.size(); idx++){
            String memberId = eatingHistoryList.get(idx).getMemberId();
            String foodCode = eatingHistoryList.get(idx).getFoodCode();
            System.out.println(memberId + foodCode);



            EatingHistory result = eatingHistoryRepository.save(eatingHistoryList.get(idx));
            if( null != result ){
                count++;
            }
        }
        if(count == eatingHistoryList.size()){
            return true;
        }else{
            return false;
        }
    }

    @Transactional
    public List<EatingHistory> read(String memberId) {//Find 조건에 따라 함수 만들기
//        Member member = memberRepository.findByMemberId(memberId);
        List<EatingHistory> result = eatingHistoryRepository.findByMemberId(memberId);

        if(result.isEmpty()) {
            result = new ArrayList<>();
        }
        return result;
    }

    @Transactional
    public boolean update(EatingHistory eatingHistory) {
        EatingHistory result = eatingHistoryRepository.save(eatingHistory);
        return result == null ? false : true;
    }

    @Transactional
    public boolean delete(EatingHistory eatingHistory) {
        eatingHistoryRepository.delete(eatingHistory);
        return true;
    }
}
