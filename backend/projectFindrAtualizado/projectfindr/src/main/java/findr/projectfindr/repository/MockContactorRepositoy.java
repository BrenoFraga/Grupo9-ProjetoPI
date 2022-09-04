package findr.projectfindr.repository;

import findr.projectfindr.model.Match;
import findr.projectfindr.model.MockContactor;
import findr.projectfindr.model.pkMatch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MockContactorRepositoy extends JpaRepository<MockContactor, Long> {
}
