package findr.projectfindr.repository;

import findr.projectfindr.model.LikeFreelancer;
import findr.projectfindr.model.pkLikeFreelancer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeFreelancerRepository extends JpaRepository<LikeFreelancer, pkLikeFreelancer> {
}
