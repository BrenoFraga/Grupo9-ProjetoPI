package findr.projectfindr.pks;

import findr.projectfindr.model.UserFreelancer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class pkLogLoginFreelancer implements Serializable {

    @ManyToOne
    @JoinColumn(name = "fk_freelancer")
    private UserFreelancer fkFreelancer;
}
