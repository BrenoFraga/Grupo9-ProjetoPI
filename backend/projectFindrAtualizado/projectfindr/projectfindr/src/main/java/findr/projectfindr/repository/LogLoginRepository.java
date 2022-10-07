package findr.projectfindr.repository;

import findr.projectfindr.model.LogLogin;
import findr.projectfindr.model.Match;
import findr.projectfindr.model.pkLogLogin;
import findr.projectfindr.model.pkMatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogLoginRepository extends JpaRepository<LogLogin, pkLogLogin> {

}
