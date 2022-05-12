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

    //@NotNull
    private Boolean online = false;

    //@NotNull
    @ManyToOne
    private ProjectModel projectModel;

    public Contactor() {
    }

    public Contactor(String name, String email, String password, String phoneContact, String country, String state, String city, Long idContactor, String document, Integer fkStatusContactor, Integer fkPlanContactor) {
        super(name, email, password, phoneContact, country, state, city);
        this.idContactor = idContactor;
        this.document = document;
        this.online = false;
    }

    public ProjectModel getProjectModel() {
        return projectModel;
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

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    @Override
    public String toString() {
        return  "idContactor=" + idContactor +","+
                super.toString()+
                ", document='" + document + '\'' +
                ", online=" + online +
                "'}'";
    }
}
