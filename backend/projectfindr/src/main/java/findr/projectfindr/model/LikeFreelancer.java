package findr.projectfindr.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Date;

@Entity
public class LikeFreelancer extends Like{

@EmbeddedId
private pkLikeFreelancer idLikeFreelancer;

    public LikeFreelancer(Date dateHour, boolean evaluation, pkLikeFreelancer idLikeFreelancer) {
        super(dateHour, evaluation);
        this.idLikeFreelancer = idLikeFreelancer;
    }

    public LikeFreelancer() {

    }

    public pkLikeFreelancer getIdLikeFreelancer() {
        return idLikeFreelancer;
    }

    public void setIdLikeFreelancer(pkLikeFreelancer idLikeFreelancer) {
        this.idLikeFreelancer = idLikeFreelancer;
    }
}
