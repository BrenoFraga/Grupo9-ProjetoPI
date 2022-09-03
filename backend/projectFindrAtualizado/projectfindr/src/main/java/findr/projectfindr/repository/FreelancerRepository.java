package findr.projectfindr.repository;


import findr.projectfindr.model.Contactor;
import findr.projectfindr.model.SpecialtyModel;
import findr.projectfindr.model.UserFreelancer;
import findr.projectfindr.response.PerfilResponseFreelancer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FreelancerRepository extends JpaRepository<UserFreelancer,Long> {
    UserFreelancer findByEmailAndPassword(String email, String password);

    @Transactional
    @Query("select s from SpecialtyModel s where s.userFreelancer.idUserFreelancer = ?1")
    List<SpecialtyModel> showAllSpecialty(Long fkFreelancer);

    @Transactional
        @Query(value = "select new findr.projectfindr.response.PerfilResponseFreelancer(u.name,u.image,u.city,u.state,u.email,j.technologyUsed) from UserFreelancer u inner join SpecialtyModel j on u.idUserFreelancer = j.userFreelancer.idUserFreelancer where u.idUserFreelancer = ?1")
    List<PerfilResponseFreelancer> showPerfilById(long id);

    @Query("update UserFreelancer f set f.image = ?2 where f.idUserFreelancer = ?1")
    @Modifying
    @Transactional
    void atualizarFoto(Long codigo, byte[] novaFoto);

    @Query("select f.image from UserFreelancer f where f.idUserFreelancer = ?1")
    byte[] getFoto(Long codigo);

    @Transactional
    @Query("select f from UserFreelancer f where f.email = ?1 and f.password = ?2")
    UserFreelancer showByEmailAndPass(String email, String password);

    UserFreelancer findByIdUserFreelancer(long f);

}
