package findr.projectfindr.model;

import findr.projectfindr.pks.pkLikeFreelancer;
import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@Data
public class LikeFreelancer extends Like{

@EmbeddedId
private pkLikeFreelancer idLikeFreelancer;

    public LikeFreelancer(Date dateHour, boolean evaluation, pkLikeFreelancer idLikeFreelancer) {
        super(dateHour, evaluation);
        this.idLikeFreelancer = idLikeFreelancer;
    }

    public LikeFreelancer() {

    }

}
