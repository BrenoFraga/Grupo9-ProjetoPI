package com.projectfindr.model;

import javax.persistence.*;

@Entity
public class RegisterSpecialtyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSpecialty;
    private String occupationArea;
    private String technologyUsed;
    private String levelKnowledge;
    private Integer fkFreelancer;


}
