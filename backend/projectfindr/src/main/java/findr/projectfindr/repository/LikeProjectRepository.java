package findr.projectfindr.repository;

import findr.projectfindr.response.MatchResponse;
import findr.projectfindr.model.LikeProject;
import findr.projectfindr.model.pkLikeProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LikeProjectRepository extends JpaRepository<LikeProject, pkLikeProject> {

   // @Query("select a.fkContactor,a.fkFreelancer,b.fkContactor,b.fkFreelancer " +
   //         "from LikeProject a inner join LikeFreelancer b on a.fkContactor = b.fkContactor and a.fkFreelancer = b.fkFreelancer")
   // List<MatchResponse> trazerMatchFreelancer();
}
