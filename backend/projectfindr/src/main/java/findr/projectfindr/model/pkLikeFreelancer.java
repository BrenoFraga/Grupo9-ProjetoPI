package findr.projectfindr.model;

import findr.projectfindr.model.Contactor;
import findr.projectfindr.model.UserFreelancer;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class pkLikeFreelancer implements Serializable {
    @ManyToOne
    @JoinColumn(name = "fk_freelancer_id_freelancer")
    private UserFreelancer fkFreelancer;


    @JoinColumn(name = "fk_contactor_id_contactor")
    @ManyToOne
    private Contactor fkContactor;

    public pkLikeFreelancer(UserFreelancer fkFreelancer, Contactor fkContactor) {
        this.fkFreelancer = fkFreelancer;
        this.fkContactor = fkContactor;
    }

    public pkLikeFreelancer() {
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
