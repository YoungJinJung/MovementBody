package com.project.movementbody.controller.food;

import com.project.movementbody.model.Food;
import com.project.movementbody.service.food.FoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    FoodService foodService;

    @PostMapping("/api/v1/foodInfo")
    public Food addFoodInformation(@RequestBody Food food) {
        return foodService.addFoodInfo(food);
    }

    @PutMapping("/api/v1/foodInfo")
    public Food updateFoodInformation(@RequestBody Food food) {
        return foodService.updateFoodInfo(food);
    }

    @GetMapping("/api/v1/foodInfo/code/{foodCode}")
    public Food getFoodInformationByCode(@PathVariable String foodCode) {
        return foodService.findFoodByCode(foodCode);
    }

    @GetMapping("/api/v1/foodInfo")
    public List<Food> getFoodList() {
        List<Food> foodList = foodService.findAllFoodList();
        if (foodList == null || foodList.isEmpty()) {
            logger.info("All Food List is Empty");
        }
        return foodList;
    }

    @GetMapping("/api/v1/foodInfo/category/{foodCategory}")
    public List<Food> getCategoryFoodList(@PathVariable String foodCategory) {
        List<Food> foodList = foodService.findFoodListByCategory(foodCategory);
        if (foodList == null || foodList.isEmpty()) {
            logger.info("Categorized Food List is Empty");
        }
        return foodList;
    }

    @GetMapping("/api/v1/foodInfo/name/{foodName}")
    public Food getFoodInformationByName(@PathVariable String foodName) {
        return foodService.findFoodByName(foodName);
    }
}
