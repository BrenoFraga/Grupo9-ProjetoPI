package findr.projectfindr.repository;

import findr.projectfindr.model.LikeFreelancer;
import findr.projectfindr.model.Match;
import findr.projectfindr.model.pkMatch;
import findr.projectfindr.response.MatchContactor;
import findr.projectfindr.response.MatchFreelancer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MatchRepositoy extends JpaRepository<Match,pkMatch> {
    List<Match> findByIdMatch_FkContactor_IdContactor(long c);
    List<Match> findByIdMatch_fkFreelancer_IdUserFreelancer(long c);

    @Transactional
    @Query("select new findr.projectfindr.response.MatchContactor(u.name, r.technologyUsed) from Match m " +
            "inner join UserFreelancer u on  u.idUserFreelancer = ?1 AND m.idMatch.fkFreelancer.idUserFreelancer = u.idUserFreelancer " +
            "inner join SpecialtyModel r on u.idUserFreelancer = r.fkFreelancer.idUserFreelancer "
            )
    List<MatchContactor> showMatchContactor(long id);

    @Transactional
    @Query("select new findr.projectfindr.response.MatchFreelancer(u.name, o.nameProject) from Match m " +
            "inner join Contactor u on u.idContactor = ?1 and u.idContactor = m.idMatch.fkContactor.idContactor " +
            "inner join ProjectModel o on u.idContactor = o.fkContactor.idContactor")
    List<MatchFreelancer> showMatchFreelancer(long id);
}
