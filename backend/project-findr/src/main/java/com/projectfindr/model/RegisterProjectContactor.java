package com.projectfindr.model;


import javax.persistence.*;

@Entity
public class RegisterProjectContactor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProjectContactor;

    private String nameProject;

    private String descriptionProject;

    private String requiredArea;

    private String requiredLanguages;

    private Integer quantityProfissionals;

    private Integer fkContactor;

}
