package findr.projectfindr.model;

import findr.projectfindr.model.Contactor;
import findr.projectfindr.model.ProjectModel;
import findr.projectfindr.model.UserFreelancer;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class pkLikeProject implements Serializable {

    @JoinColumn(name = "fk_freelancer_id_freelancer")
    @ManyToOne
    private UserFreelancer fkFreelancer;


    @JoinColumn(name = "fk_contactor_id_contactor")
    @ManyToOne
    private Contactor fkContactor;


    @JoinColumn(name ="fk_project_contactor_id_project_contactor")
    @ManyToOne
    private ProjectModel fkProject;

    public pkLikeProject(UserFreelancer fkFreelancer, Contactor fkContactor, ProjectModel fkProject) {
        this.fkFreelancer = fkFreelancer;
        this.fkContactor = fkContactor;
        this.fkProject = fkProject;
    }

    public pkLikeProject() {
    }

    public UserFreelancer getFkFreelancer() {
        return fkFreelancer;
    }

    public void setFkFreelancer(UserFreelancer fkFreelancer) {
        this.fkFreelancer = fkFreelancer;
    }

    public Contactor getFkContactor() {
        return fkContactor;
    }

    public void setFkContactor(Contactor fkContactor) {
        this.fkContactor = fkContactor;
    }

    public ProjectModel getFkProject() {
        return fkProject;
    }

    public void setFkProject(ProjectModel fkProject) {
        this.fkProject = fkProject;
    }
}
