package findr.projectfindr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "register_specialty_freelancer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecialtyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSpecialty;
    private String occupationArea;
    private String technologyUsed;
    private String levelKnowledge;

    @ManyToOne
    private UserFreelancer userFreelancer;


}
