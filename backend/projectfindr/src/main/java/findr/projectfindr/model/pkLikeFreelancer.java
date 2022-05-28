package findr.projectfindr.model;

import findr.projectfindr.model.Contactor;
import findr.projectfindr.model.UserFreelancer;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class pkLikeFreelancer implements Serializable {
    @ManyToOne
    private UserFreelancer fkFreelancer;

    @ManyToOne
    private Contactor fkContactor;

    public pkLikeFreelancer(UserFreelancer fkFreelancer, Contactor fkContactor) {
        this.fkFreelancer = fkFreelancer;
        this.fkContactor = fkContactor;
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
}
