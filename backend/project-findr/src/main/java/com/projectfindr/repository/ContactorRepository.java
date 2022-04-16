package com.projectfindr.repository;

import com.projectfindr.model.Contactor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactorRepository extends JpaRepository<Contactor,Long> {
}
