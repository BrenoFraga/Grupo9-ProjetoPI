package findr.projectfindr.model;
import findr.projectfindr.pks.pkLikeProject;
import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
