package findr.projectfindr.repository;

import findr.projectfindr.model.LogLoginFreelancer;
import findr.projectfindr.pks.pkLogLoginFreelancer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogLoginFreelancerRepositoy extends JpaRepository<LogLoginFreelancer, pkLogLoginFreelancer> {
    List<LogLoginFreelancer> findByFkFreelancer_fkFreelancer_IdUserFreelancer(long c);
}
