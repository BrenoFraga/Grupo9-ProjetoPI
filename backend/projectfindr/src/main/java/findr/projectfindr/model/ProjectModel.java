package findr.projectfindr.model;


import javax.persistence.*;

@Entity
@Table(name = "register_project_contactor")
public class ProjectModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProjectContactor;
    private String nameProject;
    private String descriptionProject;
    private String requiredArea;
    private String requiredLanguages;
    private Integer quantityProfissionals;

    @ManyToOne
    @JoinColumn(name = "fk_contactor_id_contactor")
    private Contactor contactor;

    public ProjectModel(String nameProject, String descriptionProject, String requiredArea, String requiredLanguages, Integer quantityProfissionals) {
        this.nameProject = nameProject;
        this.descriptionProject = descriptionProject;
        this.requiredArea = requiredArea;
        this.requiredLanguages = requiredLanguages;
        this.quantityProfissionals = quantityProfissionals;
    }

    public ProjectModel() {
    }

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

    public Contactor getContactor() {
        return contactor;
    }

}
