package findr.projectfindr.repository;

import findr.projectfindr.model.*;
import findr.projectfindr.pks.pkLogLoginContactor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogLoginContactorRepositoy extends JpaRepository<LogLoginContactor, pkLogLoginContactor> {
    List<LogLoginContactor> findByFkContactor_fkContactor_IdContactor(long c);
}
