package FindR.projectFindR.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class ProjectModel {
    private String id_project_contactor;
    private String name_project;
    private String description_project;
    private String required_area;
    private String required_languages;
    private int quantity_profissionals;
    private int fk_contactor;
    private List<FreelancerModel> devs;

    public ProjectModel(String id_project_contactor,
                        String name_project,
                        String description_project,
                        String required_area,
                        String required_languages,
                        int quantity_profissionals,
                        int fk_contactor, List<FreelancerModel> devs) {
        this.id_project_contactor = id_project_contactor;
        this.name_project = name_project;
        this.description_project = description_project;
        this.required_area = required_area;
        this.required_languages = required_languages;
        this.quantity_profissionals = quantity_profissionals;
        this.fk_contactor = fk_contactor;
        this.devs = devs;
    }
}
