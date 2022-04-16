package com.projectfindr.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserFreelancer extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUserFreelancer;

    private String cpf;

    private String avaliableTime;

    private Integer fkStatusFreelancer;

    private Integer fkPlanFreelancer;

}
