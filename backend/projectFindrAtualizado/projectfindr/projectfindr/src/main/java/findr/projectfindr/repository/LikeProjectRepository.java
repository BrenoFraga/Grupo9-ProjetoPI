package findr.projectfindr.repository;

import findr.projectfindr.response.MatchResponse;
import findr.projectfindr.model.LikeProject;
import findr.projectfindr.model.pkLikeProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LikeProjectRepository extends JpaRepository<LikeProject, pkLikeProject> {
    List<LikeProject> findByIdLikeProject_FkContactor_IdContactor(long c);
    LikeProject findByIdLikeProject_FkContactor_IdContactorAndIdLikeProject_FkFreelancer_IdUserFreelancer(long c,long d);
}
