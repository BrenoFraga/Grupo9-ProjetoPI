package com.projectfindr.controller;

import com.projectfindr.model.UserContactorCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private BancoService bd;

    @PostMapping
    public String addUserContactorCompany(@RequestBody UserContactorCompany company) {
        bd.addUserContactorCompany(company);
        return "Empresa cadastrada com sucesso!";
    }

    @GetMapping
    public List<UserContactorCompany> getCompany() {
        return bd.contactorCompanies;
    }

    @DeleteMapping("/{email}/{password}")
    public String deleteUserContactorCompany(@PathVariable String email, @PathVariable String password) {
        return bd.deleteUserContactorCompany(email, password);
    }

    @PostMapping("/login/{email}/{password}")
    public String setLoginCompany(@PathVariable String email, @PathVariable String password) {
        return bd.setLoginCompany(email, password);
    }

    @PostMapping("/logoff/{email}/{password}")
    public String setLogoffCompany(@PathVariable String email, @PathVariable String password) {
        return bd.setLogoffCompany(email, password);
    }
}

