package findr.projectfindr.repository;

import findr.projectfindr.model.SpecialtyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SpecialtyRepository extends JpaRepository<SpecialtyModel, Long> {

    List<SpecialtyModel> findByTechnologyUsed(String technologyUsed);

    @Transactional
    @Query("select m from SpecialtyModel m where m.fkFreelancer.idUserFreelancer = ?1")
    List<SpecialtyModel> findByFkFreelancer(long fkFreelancer);


}
