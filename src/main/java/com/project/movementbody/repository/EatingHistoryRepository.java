package com.project.movementbody.repository;

import com.project.movementbody.model.EatingHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EatingHistoryRepository extends JpaRepository<EatingHistory, Integer> {
    List<EatingHistory> findAllByMemberId(String memberId);
}
