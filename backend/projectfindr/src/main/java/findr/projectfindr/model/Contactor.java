package findr.projectfindr.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contactor extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContactor;

    private String document;

    private Integer fkStatusContactor;

    private Integer fkPlanContactor;

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

    public Integer getFkStatusContactor() {
        return fkStatusContactor;
    }

    public void setFkStatusContactor(Integer fkStatusContactor) {
        this.fkStatusContactor = fkStatusContactor;
    }

    public Integer getFkPlanContactor() {
        return fkPlanContactor;
    }

    public void setFkPlanContactor(Integer fkPlanContactor) {
        this.fkPlanContactor = fkPlanContactor;
    }
}
