package findr.projectfindr.pks;

import findr.projectfindr.model.Contactor;
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
public class pkLogLoginContactor implements Serializable {
    @JoinColumn(name = "fk_contactor")
    @ManyToOne
    private Contactor fkContactor;
}
