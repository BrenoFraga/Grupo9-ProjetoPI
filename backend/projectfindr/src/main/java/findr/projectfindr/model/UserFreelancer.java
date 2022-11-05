package findr.projectfindr.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFreelancer extends User implements Serializable {

    private static final long serialVersionUID = -8720159357820298424L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUserFreelancer;


    private long avaliableTime;

    @ManyToOne
    @JoinColumn(name = "fk_plan_freelancer")
    private Plans fkPlanFreelancer;


}
