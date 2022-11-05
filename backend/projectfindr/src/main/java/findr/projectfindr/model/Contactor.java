package findr.projectfindr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "contactor")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Contactor extends User implements Serializable {

    private static final long serialVersionUID = 1939377002641387307L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContactor;

    @ManyToOne
    @JoinColumn(name = "fk_plan_contactor")
    private Plans fkPlanContactor;

}
