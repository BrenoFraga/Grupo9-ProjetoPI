package findr.projectfindr.model;


import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Contactor extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContactor;

    //@CPF
   // @CNPJ
    //NotNull
    private String document;




    public Contactor() {
    }

    public Contactor(String name, String email, String password, String phoneContact, String country, String state, String city, String avaliableTime, Long idContactor, String document) {
        super(name, email, password, phoneContact, country, state, city, avaliableTime);
        this.idContactor = idContactor;
        this.document = document;

    }

    public Long getIdContactor() {
        return idContactor;
    }

    public void setIdContactor(Long idContactor) {
        this.idContactor = idContactor;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }


}
