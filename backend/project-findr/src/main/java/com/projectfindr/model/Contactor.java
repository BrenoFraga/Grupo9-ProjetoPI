package com.projectfindr.model;


import javax.persistence.*;

@Entity
public class Contactor extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContactor;

    private String document;

    private Integer fkStatusContactor;

    private Integer fkPlanContactor;

}
