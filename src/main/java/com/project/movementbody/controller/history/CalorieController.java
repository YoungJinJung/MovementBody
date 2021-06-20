package com.project.movementbody.controller.history;

import com.project.movementbody.model.Calories;
import com.project.movementbody.service.history.CalorieService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Api(value = "CalorieController V1")
public class CalorieController {
    final CalorieService calorieService;

    public CalorieController(CalorieService calorieService) {
        this.calorieService = calorieService;
    }

    // Target Calorie CREATE
    @PostMapping("/calorie/addInfo")
    public boolean insertCalorieInformation(@RequestBody Calories calories) {
        return calorieService.insert(calories);
    }

    // Target Calorie READ
    @GetMapping("/calorie/readInfo/{memberId}")
    public Calories getCalorieInformation(@PathVariable String memberId) {
        return calorieService.select(memberId);
    }

    @GetMapping("/calorie/readInfo/{memberId}/{timestamp}")
    public Calories getCalorieInformationByMemberIdAndTimeStamp(@PathVariable String memberId, @PathVariable long timestamp) {
        return calorieService.selectByTimeStamp(memberId, timestamp);
    }
    // Target Calorie UPDATE
    @PutMapping("/calorie/updateInfo")
    public boolean updateCalorieInformation(@RequestBody Calories calories) {
        return calorieService.update(calories);
    }

    // Target Calorie DELETE
    @DeleteMapping("/calorie/deleteInfo")
    public boolean deleteCalorieInformation(@RequestBody Calories calories) {
        calorieService.delete(calories.getMemberId());
        return true;
    }

}
