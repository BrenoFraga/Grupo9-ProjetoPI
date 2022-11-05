package findr.projectfindr.pks;

import findr.projectfindr.model.Contactor;
import findr.projectfindr.model.ProjectModel;
import findr.projectfindr.model.UserFreelancer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
public class pkLikeProject implements Serializable {

    @JoinColumn(name = "fk_freelancer")
    @ManyToOne
    private UserFreelancer fkFreelancer;


    @JoinColumn(name = "fk_contactor")
    @ManyToOne
    private Contactor fkContactor;


    @JoinColumn(name ="fk_project")
    @ManyToOne
    private ProjectModel fkProject;

    public pkLikeProject(UserFreelancer fkFreelancer, Contactor fkContactor, ProjectModel fkProject) {
        this.fkFreelancer = fkFreelancer;
        this.fkContactor = fkContactor;
        this.fkProject = fkProject;
    }

    public pkLikeProject() {
    }

}
