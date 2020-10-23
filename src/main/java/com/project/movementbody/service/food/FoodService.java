package com.project.movementbody.service.food;

import com.project.movementbody.model.Food;
import com.project.movementbody.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class FoodService {
    Logger logger = Logger.getLogger(this.getClass().getName());
    @Autowired
    FoodRepository foodRepository;

    @Transactional
    public Food findFoodByCode(String foodCode) {
        Food selectFood = new Food();
        if (foodCode == null) {
            logger.info("[findFood] Cannot Find Food Information : Wrong Food Code");
        } else {
            selectFood = foodRepository.findByFoodCode(foodCode);
        }
        return selectFood;
    }

    @Transactional
    public List<Food> findAllFoodList() {
        List<Food> selectFoodList = new ArrayList<>();
        selectFoodList = foodRepository.findAll();
        return selectFoodList;
    }

    @Transactional
    public List<Food> findFoodListByCategory(String foodCategory) {
        List<Food> selectFoodList = new ArrayList<>();
        if (foodCategory == null) {
            logger.info("[findFood] Cannot Find Food Information : Wrong Food Category");
        } else {
            selectFoodList = foodRepository.findByFoodCategory(foodCategory);
        }
        return selectFoodList;
    }

    @Transactional
    public Food findFoodByName(String foodName) {
        Food selectedFood = new Food();
        if (foodName == null) {
            logger.info("[findFood] Cannot Find Food Information : Wrong Food Name");
        } else {
            selectedFood = foodRepository.findByFoodName(foodName);
        }
        return selectedFood;
    }
}
