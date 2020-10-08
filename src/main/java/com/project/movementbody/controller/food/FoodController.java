package com.project.movementbody.controller.food;

import com.project.movementbody.model.Food;
import com.project.movementbody.service.food.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {
    @Autowired
    FoodService foodService;

    @GetMapping("/foodInfo/{foodCode}")
    public Food getFoodInformation(@PathVariable String foodCode){
        return foodService.findFood(foodCode);
    }
}
