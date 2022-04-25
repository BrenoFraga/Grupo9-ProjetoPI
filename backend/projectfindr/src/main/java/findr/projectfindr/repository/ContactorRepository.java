package findr.projectfindr.repository;

import findr.projectfindr.model.Contactor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactorRepository extends JpaRepository<Contactor,Long> {

    List<Contactor> findByEmailAndPassword(String email, String password);
}
