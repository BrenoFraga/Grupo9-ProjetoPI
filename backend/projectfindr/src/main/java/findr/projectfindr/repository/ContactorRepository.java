package findr.projectfindr.repository;

import findr.projectfindr.model.Contactor;
import findr.projectfindr.model.ProjectModel;
import findr.projectfindr.request.LoginRequest;
import findr.projectfindr.response.PerfilResponseContactorProject;
import findr.projectfindr.response.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ContactorRepository extends JpaRepository<Contactor,Long> {

    @Transactional
    @Query("select c from Contactor c where c.email = ?1 and c.password = ?2")
    Contactor showByEmailAndPass(String email, String password);


    @Query("update Contactor c set c.image = ?2 where c.idContactor = ?1")
    @Modifying
    @Transactional
    void atualizarFoto(Long codigo, byte[] novaFoto);

    @Query("select c.image from Contactor c where c.idContactor = ?1")
    byte[] getFoto(Long codigo);

    @Transactional
    @Query("select p from ProjectModel p where p.fkContactor.idContactor = ?1")
    List<ProjectModel> showAllProjectsContactor(long fkContactor);

    Contactor findByIdContactor(long f);

    @Query("select new findr.projectfindr.response.UserResponse(u.name, u.email, u.phoneContact, u.country, u.state, u.city) from Contactor u")
    List<UserResponse> findAllUserResponse();


    @Transactional
    @Query("select new findr.projectfindr.response.PerfilResponseContactorProject(c.name,c.image,c.city,c.state,c.email,p.nameProject) from Contactor c inner join ProjectModel p on c.idContactor = p.fkContactor.idContactor where c.idContactor = ?1")
    List<PerfilResponseContactorProject> showByIdPerfil(long id);

    Contactor findByEmail(String email);
    @Modifying
    @Query("update Contactor c set c.image = ?1 where c.idContactor = ?2")
    @Transactional
    void setImageContactor(String idImage,Long idContactor);
}
