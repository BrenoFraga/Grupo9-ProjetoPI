package findr.projectfindr.model;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;


@Entity
public class LikeProject extends Like {

    @EmbeddedId
    private pkLikeProject idLikeProject;

    public LikeProject(Date dateHour, boolean evaluation, pkLikeProject idLikeProject) {
        super(dateHour, evaluation);
        this.idLikeProject = idLikeProject;
    }

    public LikeProject() {

    }

    public pkLikeProject getIdLikeProject() {
        return idLikeProject;
    }

    public void setIdLikeProject(pkLikeProject idLikeProject) {
        this.idLikeProject = idLikeProject;
    }
}
