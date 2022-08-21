package findr.projectfindr.repository;

import findr.projectfindr.model.Match;
import findr.projectfindr.model.pkMatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepositoy extends JpaRepository<Match,pkMatch> {
}
