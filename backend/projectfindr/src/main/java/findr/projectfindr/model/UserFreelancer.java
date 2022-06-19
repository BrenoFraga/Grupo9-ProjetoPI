package findr.projectfindr.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFreelancer extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUserFreelancer;


    private long avaliableTime;

    @ManyToOne
    @JoinColumn(name = "fk_plan_freelancer_id_plan")
    private Plans fkPlanFreelancer;


}
