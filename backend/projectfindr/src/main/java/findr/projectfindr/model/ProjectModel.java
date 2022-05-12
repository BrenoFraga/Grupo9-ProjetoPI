package findr.projectfindr.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class ProjectModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProjectContactor;

    private String nameProject;

    private String descriptionProject;

    private String requiredArea;

    private String requiredLanguages;

    private Integer quantityProfissionals;


    public Long getIdProjectContactor() {
        return idProjectContactor;
    }

    public void setIdProjectContactor(Long idProjectContactor) {
        this.idProjectContactor = idProjectContactor;
    }

    public String getNameProject() {
        return nameProject;
    }

    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }

    public String getDescriptionProject() {
        return descriptionProject;
    }

    public void setDescriptionProject(String descriptionProject) {
        this.descriptionProject = descriptionProject;
    }

    public String getRequiredArea() {
        return requiredArea;
    }

    public void setRequiredArea(String requiredArea) {
        this.requiredArea = requiredArea;
    }

    public String getRequiredLanguages() {
        return requiredLanguages;
    }

    public void setRequiredLanguages(String requiredLanguages) {
        this.requiredLanguages = requiredLanguages;
    }

    public Integer getQuantityProfissionals() {
        return quantityProfissionals;
    }

    public void setQuantityProfissionals(Integer quantityProfissionals) {
        this.quantityProfissionals = quantityProfissionals;
    }

    @Override
    public String toString() {
        return "ProjectModel{" +
                "idProjectContactor=" + idProjectContactor +
                ", nameProject='" + nameProject + '\'' +
                ", descriptionProject='" + descriptionProject + '\'' +
                ", requiredArea='" + requiredArea + '\'' +
                ", requiredLanguages='" + requiredLanguages + '\'' +
                ", quantityProfissionals=" + quantityProfissionals +
                "'}'";
    }
}
