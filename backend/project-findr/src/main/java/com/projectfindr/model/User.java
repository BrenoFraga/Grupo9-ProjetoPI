package com.projectfindr.model;


import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {

    @NotBlank
    private String name;

    @Email
    private String email;

    @NotNull
    private String password;


    @NotBlank
    private String phoneContact;

    @NotBlank
    private String country;

    @NotBlank
    private String state;

    @NotBlank
    private String city;



}
