package findr.projectfindr.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "register_project_contactor")
@Data
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
    @JoinColumn(name = "fk_contactor")
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
}
