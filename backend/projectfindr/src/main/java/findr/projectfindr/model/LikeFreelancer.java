package findr.projectfindr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
