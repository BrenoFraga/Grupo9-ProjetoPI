package findr.projectfindr.repository;

import findr.projectfindr.model.Contactor;
import findr.projectfindr.model.ProjectModel;
import findr.projectfindr.request.LoginRequest;
import findr.projectfindr.response.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ContactorRepository extends JpaRepository<Contactor,Long> {



    //seta se o usuário tá online ou offline
   // @Transactional
   //@Modifying
   // @Query("update Contactor c set c.online = ?2 where c.idContactor = ?1")
   // void atualizarOnline(Long idContactor, Boolean online);


    //trazer um unico contactor de acordo com o email e senha
    @Transactional
    @Query("select c from Contactor c where c.email = ?1 and c.password = ?2")
    Contactor showByEmailAndPass(String email, String password);


    //trazer todos os projetos de um Contactor
    @Transactional
    @Query("select p from ProjectModel p where p.contactor.idContactor = ?1")
    List<ProjectModel> showAllProjectsContactor(long fkContactor);

    Contactor findByIdContactor(long f);

    @Query("select new findr.projectfindr.response.UserResponse(u.name, u.email, u.phoneContact, u.country, u.state, u.city) from Contactor u")
    List<UserResponse> findAllUserResponse();

}
