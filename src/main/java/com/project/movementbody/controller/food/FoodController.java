package com.project.movementbody.controller.food;

import com.project.movementbody.model.Food;
import com.project.movementbody.service.food.FoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/foodInfo")
    public Food addFoodInformation(@RequestBody Food food) {
        return foodService.create(food);
    }

    @PutMapping("/foodInfo")
    public Food updateFoodInformation(@RequestBody Food food) {
        return foodService.update(food);
    }

    @GetMapping("/foodInfo/code/{foodCode}")
    public Food getFoodInformationByCode(@PathVariable String foodCode) {
        return foodService.readFoodByCode(foodCode);
    }

    @GetMapping("/foodInfo")
    public List<Food> getFoodList() {
        List<Food> foodList = foodService.readAllFoodList();
        if (foodList == null || foodList.isEmpty()) {
            logger.info("All Food List is Empty");
        }
        return foodList;
    }

    @GetMapping("/foodInfo/category/{foodCategory}")
    public List<Food> getCategoryFoodList(@PathVariable String foodCategory) {
        List<Food> foodList = foodService.readFoodListByCategory(foodCategory);
        if (foodList == null || foodList.isEmpty()) {
            logger.info("Categorized Food List is Empty");
        }
        return foodList;
    }

    @GetMapping("/foodInfo/name/{foodName}")
    public Food getFoodInformationByName(@PathVariable String foodName) {
        return foodService.readFoodByName(foodName);
    }

    @DeleteMapping("/foodInfo")
    public boolean deleteFoodInformation(@RequestBody Food food) {
        return foodService.delete(food);
    }
}
