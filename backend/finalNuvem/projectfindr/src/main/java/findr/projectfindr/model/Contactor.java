package findr.projectfindr.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "contactor")
@AllArgsConstructor
@NoArgsConstructor
public class Contactor extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContactor;

    @ManyToOne
    @JoinColumn(name = "fk_plan_contactor")
    private Plans fkPlanContactor;

}
