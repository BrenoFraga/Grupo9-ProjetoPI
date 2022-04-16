package com.projectfindr.repository;

import com.projectfindr.model.RegisterSpecialtyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialtyRepository extends JpaRepository<RegisterSpecialtyUser, Long> {

    //List<RegisterSpecialtyUser> findByTechnologyUsed(String technologyUsed);






}
