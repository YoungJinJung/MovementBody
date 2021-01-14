package com.project.movementbody.repository;

import com.project.movementbody.model.Food;
import com.project.movementbody.model.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
    Food findByFoodCode(String foodCode);

    List<Food> findByFoodCategoryEquals(FoodCategory foodCategory);

    Food findByFoodName(String foodName);
}
