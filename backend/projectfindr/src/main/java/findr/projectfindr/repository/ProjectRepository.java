package findr.projectfindr.repository;

import findr.projectfindr.model.ProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<ProjectModel, Long> {

    List<ProjectModel> findByContactor(Integer idContactor);
    ProjectModel findByIdProjectContactor(long p);
}
