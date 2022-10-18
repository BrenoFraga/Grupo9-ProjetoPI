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
@AllArgsConstructor
@NoArgsConstructor
public class pkLikeFreelancer implements Serializable {
    @ManyToOne
    @JoinColumn(name = "fk_freelancer")
    private UserFreelancer fkFreelancer;


    @JoinColumn(name = "fk_contactor")
    @ManyToOne
    private Contactor fkContactor;


    @JoinColumn(name = "fk_specialty")
    @ManyToOne
    private SpecialtyModel fkSpecialty;


}
