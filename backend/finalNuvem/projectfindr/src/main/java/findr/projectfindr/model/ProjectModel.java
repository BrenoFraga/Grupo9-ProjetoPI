package findr.projectfindr.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "register_project_contactor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_project_contactor")
    private Long idProjectContactor;

    @JsonIgnore
    @Column(length = 50_000_000)
    private byte[] image;
    private String nameProject;
    private String descriptionProject;
    private String requiredArea;
    private String requiredLanguages;
    private String levelKnowledge;
    private Integer quantityProfissionals;


    @ManyToOne
    @JoinColumn(name = "fk_contactor")
    private Contactor fkContactor;

}
