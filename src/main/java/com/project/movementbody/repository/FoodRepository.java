package com.project.movementbody.repository;

import com.project.movementbody.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
    Food findByFoodCode(String foodCode);
}
