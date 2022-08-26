package findr.projectfindr.repository;

import findr.projectfindr.model.LikeFreelancer;
import findr.projectfindr.model.Match;
import findr.projectfindr.model.pkMatch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchRepositoy extends JpaRepository<Match,pkMatch> {

    //List<LikeFreelancer> findByIdLikeFreelancer_FkFreelancer_IdUserFreelancer(long c);
    List<Match> findByIdMatch_FkContactor_IdContactor(long c);
    List<Match> findByIdMatch_fkFreelancer_IdUserFreelancer(long c);
}
