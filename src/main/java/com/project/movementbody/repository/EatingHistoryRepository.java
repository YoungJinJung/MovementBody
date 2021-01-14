package com.project.movementbody.repository;

import com.project.movementbody.model.EatingHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EatingHistoryRepository extends JpaRepository<EatingHistory, Integer> {
    List<EatingHistory> findAllByMember_MemberId(String memberId);
}
