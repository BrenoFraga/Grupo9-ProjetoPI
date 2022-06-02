package findr.projectfindr.model;


import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "contactor")
public class Contactor extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContactor;

    //@CPF
   // @CNPJ
    //NotNull
    @ManyToOne
    @JoinColumn(name = "fk_plan_contactor_id_plan")
    private Plans fkPlanContactor;

    public Contactor() {
    }

    public Contactor(String name, String email, String phoneContact, String country, String state, String city) {
        super(name, email, phoneContact, country, state, city);
    }

    public Contactor(String name, String email, String password, String cpf, String cnpj, String phoneContact, String country, String state, String city, Long idContactor, Plans fkPlanContactor) {
        super(name, email, password, cpf, cnpj, phoneContact, country, state, city);
        this.idContactor = idContactor;
        this.fkPlanContactor = fkPlanContactor;
    }

    public Long getIdContactor() {
        return idContactor;
    }

    public void setIdContactor(Long idContactor) {
        this.idContactor = idContactor;
    }

    public Plans getFkPlanContactor() {
        return fkPlanContactor;
    }

    public void setFkPlanContactor(Plans fkPlanContactor) {
        this.fkPlanContactor = fkPlanContactor;
    }
}
