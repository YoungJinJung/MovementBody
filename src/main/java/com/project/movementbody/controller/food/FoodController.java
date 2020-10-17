package com.project.movementbody.controller.food;

import com.project.movementbody.model.Food;
import com.project.movementbody.service.food.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class FoodController {
    Logger logger = Logger.getLogger(this.getClass().getName());
    @Autowired
    FoodService foodService;

    @GetMapping("/foodInfo/code/{foodCode}")
    public Food getFoodInformationByCode(@PathVariable String foodCode) {
        return foodService.findFoodByCode(foodCode);
    }

    @GetMapping("/foodInfo")
    public List<Food> getFoodList() {
        List<Food> foodList = foodService.findAllFoodList();
        if (foodList == null || foodList.isEmpty()) {
            logger.info("All Food List is Empty");
        }
        return foodList;
    }

    @GetMapping("/foodInfo/category/{foodCategory}")
    public List<Food> getCategoryFoodList(@PathVariable String foodCategory) {
        List<Food> foodList = foodService.findFoodListByCategory(foodCategory);
        if (foodList == null || foodList.isEmpty()) {
            logger.info("Categorized Food List is Empty");
        }
        return foodList;
    }

    @GetMapping("/foodInfo/name/{foodName}")
    public Food getFoodInformationByName(@PathVariable String foodName) {
        return foodService.findFoodByName(foodName);
    }
}
