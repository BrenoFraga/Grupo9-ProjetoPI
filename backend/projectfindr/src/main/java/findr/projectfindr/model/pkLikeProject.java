package findr.projectfindr.model;

import findr.projectfindr.model.Contactor;
import findr.projectfindr.model.ProjectModel;
import findr.projectfindr.model.UserFreelancer;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class pkLikeProject implements Serializable {
    @ManyToOne
    private UserFreelancer fkFreelancer;

    @ManyToOne
    private Contactor fkContactor;

    @ManyToOne
    private ProjectModel fkProject;

    public pkLikeProject(UserFreelancer fkFreelancer, Contactor fkContactor, ProjectModel fkProject) {
        this.fkFreelancer = fkFreelancer;
        this.fkContactor = fkContactor;
        this.fkProject = fkProject;
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
