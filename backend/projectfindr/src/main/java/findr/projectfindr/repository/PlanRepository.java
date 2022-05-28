package findr.projectfindr.repository;

import findr.projectfindr.model.Contactor;
import findr.projectfindr.model.Plans;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plans,Long> {
}
