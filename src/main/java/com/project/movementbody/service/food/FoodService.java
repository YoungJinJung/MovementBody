package com.project.movementbody.service.food;

import com.project.movementbody.model.Food;
import com.project.movementbody.model.FoodCategory;
import com.project.movementbody.repository.FoodRepository;
import com.project.movementbody.util.FoodCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

@Service
public class FoodService {
    Logger logger = Logger.getLogger(this.getClass().getName());
    final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @PostConstruct
    public void init() {
        //초기 FOOD CODE 값을 가져오는 로직
        List<Food> foodList = foodRepository.findByFoodCategoryEquals(FoodCategory.CUSTOM);
        String code;
        if (foodList.size() > 1) {
            Collections.sort(foodList, Comparator.comparing(Food::getFoodCode));
            code = foodList.get(foodList.size() - 1).getFoodCode();
        } else if (foodList.size() == 1) {
            code = foodList.get(0).getFoodCode();
        } else {
            code = FoodCodeGenerator.INSTANCE.initFoodCode;
        }
        int foodCodeNumber = FoodCodeGenerator.INSTANCE.checkNumber(code);
        FoodCodeGenerator.INSTANCE.setFoodCodeNumber(++foodCodeNumber);
    }

    @Transactional
    public Food create(Food food) {
        String foodCode = FoodCodeGenerator.INSTANCE.getFoodCode();
        food.setFoodCode(foodCode);
        food.setFoodCategory(FoodCategory.CUSTOM);
        Food result = foodRepository.save(food);
        if (result == null) {
            result = new Food();
            logger.info("[addFoodInfo] Cannot Add Food Information");
        }
        return result;
    }

    @Transactional
    public Food update(Food food) {
        Food result = foodRepository.save(food);
        if (result == null) {
            result = new Food();
            logger.info("[updateFoodInfo] Cannot Update Food Information");
        }
        return result;
    }

    @Transactional
    public Food readFoodByCode(String foodCode) {
        Food selectFood = new Food();
        if (foodCode == null) {
            logger.info("[findFoodInfoByCode] Cannot Find Food Information : Wrong Food Code");
        } else {
            selectFood = foodRepository.findByFoodCode(foodCode);
            if (selectFood == null) {
                logger.info("[findFoodInfoByCode] Cannot Find Food Information : selectFood is null");
            } else {
                logger.info("[findFoodInfoByCode] Success Find Food Information : " + foodCode);
            }
        }
        return selectFood;
    }

    @Transactional
    public List<Food> readAllFoodList() {
        List<Food> selectFoodList = foodRepository.findAll();
        if (selectFoodList == null) {
            selectFoodList = new ArrayList<>();
            logger.info("[findFoodInfo] Success Find Food Information : FoodList Count is 0");
        } else {
            logger.info("[findFoodInfo] Success Find Food Information : FoodList Count : " + selectFoodList.size());
        }

        return selectFoodList;
    }

    @Transactional
    public List<Food> readFoodListByCategory(String foodCategory) {
        List<Food> selectFoodList = new ArrayList<>();
        if (foodCategory == null) {
            logger.info("[findFoodInfo] Cannot Find Food Information : Wrong Food Category");
        } else {
            selectFoodList = foodRepository.findByFoodCategoryEquals(FoodCategory.valueOf(foodCategory));
            if (selectFoodList.size() == 0) {
                logger.info("[findFoodInfo] Success Find Food Information : FoodList Count is 0");
            } else {
                logger.info("[findFoodInfo] Success Find Food Information : FoodList Count : " + selectFoodList.size());
            }
        }
        return selectFoodList;
    }

    @Transactional
    public Food readFoodByName(String foodName) {
        Food selectFood = new Food();
        if (foodName == null) {
            logger.info("[findFoodInfoByCode] Cannot Find Food Information : Wrong Food Name");
        } else {
            selectFood = foodRepository.findByFoodName(foodName);
            if (selectFood == null) {
                logger.info("[findFoodInfoByCode] Cannot Find Food Information : selectFood is null");
            } else {
                logger.info("[findFoodInfoByCode] Success Find Food Information : " + foodName);
            }
        }
        return selectFood;
    }

    public boolean delete(Food food) {
        boolean resultFlag = false;
        try {
            foodRepository.delete(food);
            resultFlag = true;
            logger.info("[deleteFood] Cannot Find Food Information : Wrong Food Name");
        } catch (Exception e) {
            logger.info("[deleteFood] Cannot Find Food Information : Wrong Food Name");
            e.printStackTrace();
        }
        return resultFlag;
    }
}
