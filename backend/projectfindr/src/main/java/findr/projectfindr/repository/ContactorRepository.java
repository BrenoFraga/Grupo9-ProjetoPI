package findr.projectfindr.repository;

import findr.projectfindr.model.Contactor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ContactorRepository extends JpaRepository<Contactor,Long> {

    List<Contactor> findByEmailAndPassword(String email, String password);

    @Transactional
    @Modifying
    @Query("update Contactor s set s.online = ?3 where s.email = ?1 and s.password = ?2")
    void atualizarOnline(String email, String password, Boolean online);
}
