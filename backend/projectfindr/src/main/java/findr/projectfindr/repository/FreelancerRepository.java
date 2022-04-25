package findr.projectfindr.repository;


import findr.projectfindr.model.UserFreelancer;
import findr.projectfindr.resposta.LoginResposta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FreelancerRepository extends JpaRepository<UserFreelancer,Long> {

//    @Query("select new com.projectfindr.resposta.LoginResposta(s.email, s.password) from UserFreelancer s")
//    List<LoginResposta>listaLogin();

    List<LoginResposta> findByEmailAndPassword(String email, String password);
}
