package com.project.movementbody.repository;

import com.project.movementbody.model.Calories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalorieRepository extends JpaRepository<Calories, Integer> {
    Calories findByMemberId(String memberId);
     void deleteByMemberId(String memberId);
}
