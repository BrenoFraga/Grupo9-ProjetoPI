package com.projectfindr.repository;

import com.projectfindr.model.UserFreelancer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreelancerRepository extends JpaRepository<UserFreelancer,Long> {

}
