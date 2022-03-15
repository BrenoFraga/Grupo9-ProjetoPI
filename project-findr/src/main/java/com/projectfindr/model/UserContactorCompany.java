package com.projectfindr.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class UserContactorCompany extends User {
    private List<Project> projectCompany;

    public UserContactorCompany(String name, String email, String password, String document, String phoneContact, String country, String state, String city, boolean statusOnline) {
        super(name, email, password, document, phoneContact, country, state, city, statusOnline);
        this.projectCompany = new ArrayList<>();
    }

    @Override
    public boolean setStatusUser() {
        setStatusOnline(false);
        return false;
    }
}
