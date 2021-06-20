package com.project.movementbody.repository;

import com.project.movementbody.model.Calories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CalorieRepository extends JpaRepository<Calories, Integer> {
    Calories findByMemberId(String memberId);

    void deleteByMemberId(String memberId);

    @Query(value = "SELECT 1 AS id, memberId, SUM(carbonCalorie) AS carbonCalorie, SUM(proteinCalorie) AS proteinCalorie, SUM(fatCalorie) AS fatCalorie, SUM(totalCalorie) AS totalCalorie, ?2 AS eatingDate FROM Calories WHERE memberId = ?1 AND eatingDate >= ?2 AND eatingDate <= ?3 GROUP BY memberId", nativeQuery = true)
    Calories findByMemberIdAndEatingDateBetween(String memberId, long startTimeStamp, long endTimeStamp);
}
