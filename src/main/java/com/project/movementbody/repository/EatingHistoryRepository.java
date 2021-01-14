package com.project.movementbody.repository;

import com.project.movementbody.model.EatingHistory;
import com.project.movementbody.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EatingHistoryRepository extends JpaRepository<EatingHistory, Integer> {

    List<EatingHistory> findByMemberId(String memberId);
}
