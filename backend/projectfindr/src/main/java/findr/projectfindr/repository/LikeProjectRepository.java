package findr.projectfindr.repository;

import findr.projectfindr.model.Contactor;
import findr.projectfindr.model.LikeProject;
import findr.projectfindr.model.pkLikeProject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeProjectRepository extends JpaRepository<LikeProject, pkLikeProject> {
}
