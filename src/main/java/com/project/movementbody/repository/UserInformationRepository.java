package com.project.movementbody.repository;

import com.project.movementbody.model.UserBodyInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInformationRepository extends JpaRepository<UserBodyInformation, Integer> {
}
