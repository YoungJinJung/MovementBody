package com.project.movementbody.repository;

import com.project.movementbody.model.EatingHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EatingHistoryRepository extends JpaRepository<EatingHistory, Integer> {
}
