package findr.projectfindr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "register_specialty_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecialtyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSpecialty;
    private String ocupationArea;
    private String technologyUsed;
    private String levelKnowledge;


    @ManyToOne
    @JoinColumn(name = "fk_freelancer")
    private UserFreelancer userFreelancer;


}
