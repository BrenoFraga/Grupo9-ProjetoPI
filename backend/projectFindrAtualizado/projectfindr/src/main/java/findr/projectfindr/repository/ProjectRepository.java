package findr.projectfindr.repository;

import findr.projectfindr.model.ProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProjectRepository extends JpaRepository<ProjectModel, Long> {

    List<ProjectModel> findByFkContactor_IdContactor(long idContactor);

    ProjectModel findByIdProjectContactor(long p);

    @Query("update ProjectModel p set p.image = ?2 where p.idProjectContactor = ?1")
    @Modifying
    @Transactional
    void atualizarFoto(Long codigo, byte[] novaFoto);

    @Query("select p.image from ProjectModel p where p.idProjectContactor = ?1")
    byte[] getFoto(Long codigo);

}
