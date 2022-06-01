package findr.projectfindr.repository;

import findr.projectfindr.model.LikeFreelancer;
import findr.projectfindr.model.pkLikeFreelancer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeFreelancerRepository extends JpaRepository<LikeFreelancer, pkLikeFreelancer> {
    List<LikeFreelancer> findByIdLikeFreelancer_FkFreelancer_IdUserFreelancer(long c);
    LikeFreelancer findByIdLikeFreelancer_FkFreelancer_IdUserFreelancerAndIdLikeFreelancer_FkContactor_IdContactor(long c,long d);
}
