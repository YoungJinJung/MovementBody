package com.project.movementbody.service.food;

import com.project.movementbody.model.Food;
import com.project.movementbody.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FoodService {
    @Autowired
    FoodRepository foodRepository;

    @Transactional
    public Food findFood(String foodCode) {
        Food selectFood = foodRepository.findByFoodCode(foodCode);
        if(selectFood == null) {
            System.out.println("[findFood] Cannot Find Food Information : Wrong Food Code");
            selectFood = new Food();
        }
        return selectFood;
    }
}
