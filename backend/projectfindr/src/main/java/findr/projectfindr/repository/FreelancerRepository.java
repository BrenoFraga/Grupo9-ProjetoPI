package findr.projectfindr.repository;


import findr.projectfindr.model.Contactor;
import findr.projectfindr.model.SpecialtyModel;
import findr.projectfindr.model.UserFreelancer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FreelancerRepository extends JpaRepository<UserFreelancer,Long> {

//    @Query("select new com.projectfindr.resposta.LoginResposta(s.email, s.password) from UserFreelancer s")
//    List<LoginResposta>listaLogin();

    UserFreelancer findByEmailAndPassword(String email, String password);

   // @Transactional
   // @Modifying
   // @Query("update UserFreelancer s set s.online = ?2 where s.idUserFreelancer = ?1 ")
   // void atualizarOnline(Long idFreelancer, Boolean online);

    @Transactional
    @Query("select s from SpecialtyModel s where s.userFreelancer.idUserFreelancer = ?1")
    List<SpecialtyModel> showAllSpecialty(Long fkFreelancer);

    @Transactional
    @Query("select f from UserFreelancer f where f.email = ?1 and f.password = ?2")
    UserFreelancer showByEmailAndPass(String email, String password);
}
