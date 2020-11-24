package com.project.movementbody.service.history;

import com.project.movementbody.model.EatingHistory;
import com.project.movementbody.repository.EatingHistoryRepository;
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

    @Transactional
    public boolean insert(EatingHistory eatingHistory) {
        EatingHistory result = eatingHistoryRepository.save(eatingHistory);
        return result == null ? false : true;
    }

    @Transactional
    public List<EatingHistory> selectByUserId(String userId) {//Find 조건에 따라 함수 만들기
        List<EatingHistory> result = eatingHistoryRepository.findAllByMemberId(userId);
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
        Optional<EatingHistory> result = eatingHistoryRepository.findById(eatingHistory.getId());
        boolean resultFlag = result.isPresent();
        return resultFlag;
    }
}
