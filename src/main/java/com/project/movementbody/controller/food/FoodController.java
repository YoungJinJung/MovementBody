package com.project.movementbody.controller.food;

import com.project.movementbody.model.Food;
import com.project.movementbody.service.food.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FoodController {
    @Autowired
    FoodService foodService;

    @GetMapping("/foodInfo/{foodCode}")
    public Food getFoodInformationByCode(@PathVariable String foodCode){
        return foodService.findFood(foodCode);
    }

    @GetMapping("/foodInfo")
    public List<Food> getFoodList(){
        List<Food> foodList = foodService.findAllFoodList();
        if(foodList == null) {
            foodList = new ArrayList<>();
            System.out.println("[INFO] Food List is Empty");
        }
        return foodList;
    }

    @GetMapping("/foodInfo/{foodCategory}")
    public List<Food> getCategoryFoodList(@PathVariable String foodCategory){
        List<Food> foodList = foodService.findFoodListByCategory(foodCategory);
        if(foodList == null) {
            foodList = new ArrayList<>();
            System.out.println("[INFO] Categorise Food List is Empty");
        }
        return foodList;
    }
}
