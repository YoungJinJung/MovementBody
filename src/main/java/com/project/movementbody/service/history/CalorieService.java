package com.project.movementbody.service.history;

import com.project.movementbody.model.Calories;
import com.project.movementbody.repository.CalorieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@Service
public class CalorieService {
    final CalorieRepository calorieRepository;
    final static long ONEDAY = 60 * 60 * 24 * 1000;

    public CalorieService(CalorieRepository calorieRepository) {
        this.calorieRepository = calorieRepository;
    }

    @Transactional
    public boolean insert(Calories calories) {
        Calories result = calorieRepository.save(calories);
        return result != null ? true : false;
    }

    @Transactional
    public Calories select(String memberId) {
        Calories result = calorieRepository.findByMemberId(memberId);
        return result;
    }

    @Transactional
    public boolean update(Calories calories) {
        Calories selectedCalorie = calorieRepository.findByMemberId(calories.getMemberId());
        calories.setId(selectedCalorie.getId());
        selectedCalorie = calorieRepository.save(calories);
        return selectedCalorie != null ? true : false;
    }

    @Transactional
    public boolean delete(String memberId) {
        calorieRepository.deleteByMemberId(memberId);
        return true;
    }

    public Calories selectByTimeStamp(String memberId, long timestamp) {
        long startTimeStamp = getStartTimeStamp(timestamp);
        Calories selectedCalorie = calorieRepository.findByMemberIdAndEatingDateBetween(memberId, startTimeStamp, startTimeStamp + ONEDAY);
        return selectedCalorie;
    }

    private long getStartTimeStamp(long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND,0);
        return calendar.getTimeInMillis();
    }
}
