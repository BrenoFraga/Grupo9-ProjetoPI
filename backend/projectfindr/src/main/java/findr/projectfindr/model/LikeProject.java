package findr.projectfindr.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;


@Entity
@Data
public class LikeProject extends Like {

    @EmbeddedId
    private pkLikeProject idLikeProject;

    public LikeProject(Date dateHour, boolean evaluation, pkLikeProject idLikeProject) {
        super(dateHour, evaluation);
        this.idLikeProject = idLikeProject;
    }

    public LikeProject() {

    }
}
