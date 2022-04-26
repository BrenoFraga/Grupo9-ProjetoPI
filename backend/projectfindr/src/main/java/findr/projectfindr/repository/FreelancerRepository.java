package findr.projectfindr.repository;


import findr.projectfindr.model.UserFreelancer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FreelancerRepository extends JpaRepository<UserFreelancer,Long> {

//    @Query("select new com.projectfindr.resposta.LoginResposta(s.email, s.password) from UserFreelancer s")
//    List<LoginResposta>listaLogin();

    List<UserFreelancer> findByEmailAndPassword(String email, String password);

    @Transactional
    @Modifying
    @Query("update UserFreelancer s set s.online = ?3 where s.email = ?1 and s.password = ?2")
    void atualizarOnline(String email, String password, Boolean online);
}
