package com.projectfindr.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public abstract class User {
    private String name;
    private String email;
    private String password;
    private String document;
    private String phoneContact;
    private String country;
    private String state;
    private String city;
    private boolean statusOnline;

    public abstract boolean setStatusUser();

}
