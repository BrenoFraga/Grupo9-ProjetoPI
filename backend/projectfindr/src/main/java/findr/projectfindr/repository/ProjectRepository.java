package findr.projectfindr.repository;

import findr.projectfindr.model.ProjectModel;
import findr.projectfindr.views.TecnologiasRequeridas;
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

    @Query("select new findr.projectfindr.views.TecnologiasRequeridas(a.requiredLanguages,count(a.requiredLanguages)) from ProjectModel a group by a.requiredLanguages order by count(a.requiredLanguages) desc ")
    List<TecnologiasRequeridas> tecs();

    @Modifying
    @Query("update ProjectModel p set p.image = ?1 where p.idProjectContactor = ?2")
    @Transactional
    void setImageProject(String idImage,Long idProject);
}
