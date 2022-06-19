package findr.projectfindr.model;

import findr.projectfindr.model.Contactor;
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

}
