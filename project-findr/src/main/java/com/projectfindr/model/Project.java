package com.projectfindr.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@ToString
public class Project {
    private String nameProject;
    private String descriptionProject;
    private String requiredArea;
    private String requiredLanguages;
    private int quantityProfissionals;
    private List<UserFreelancer> profissionals;
    private boolean statusProject;

    public Project(String nameProject, String descriptionProject, String requiredArea, String requiredLanguages, int quantityProfissionals) {
        this.nameProject = nameProject;
        this.descriptionProject = descriptionProject;
        this.requiredArea = requiredArea;
        this.requiredLanguages = requiredLanguages;
        this.quantityProfissionals = quantityProfissionals;
        this.profissionals = new ArrayList<>();
        this.statusProject = false;
    }
}
