package findr.projectfindr.repository;

import findr.projectfindr.model.SpecialtyModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecialtyRepository extends JpaRepository<SpecialtyModel, Long> {

    List<SpecialtyModel> findByTechnologyUsed(String technologyUsed);


}
