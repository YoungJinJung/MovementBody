package com.project.movementbody.controller.food;

import com.project.movementbody.model.Food;
import com.project.movementbody.service.food.FoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Api(value = "FoodController V1")

public class FoodController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    FoodService foodService;
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK !!"),
            @ApiResponse(code = 500, message = "Internal Server Error !!"),
            @ApiResponse(code = 404, message = "Not Found !!")
    })
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
