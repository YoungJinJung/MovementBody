package com.project.movementbody.service.history;

import com.project.movementbody.model.Calories;
import com.project.movementbody.repository.CalorieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CalorieService {
    final CalorieRepository calorieRepository;

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
}
