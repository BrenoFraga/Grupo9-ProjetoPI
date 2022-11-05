package findr.projectfindr.repository;

import findr.projectfindr.model.SpecialtyModel;
import findr.projectfindr.views.TecnologiasUsadas;
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

    SpecialtyModel findByIdSpecialty(long id);

    @Query("select new findr.projectfindr.views.TecnologiasUsadas(a.technologyUsed, count(a.technologyUsed)) from SpecialtyModel a group by a.technologyUsed order by count(a.technologyUsed) desc")
    List<TecnologiasUsadas> tecs();
}
