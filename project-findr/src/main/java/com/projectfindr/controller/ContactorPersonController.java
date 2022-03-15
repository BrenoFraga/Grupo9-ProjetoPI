package com.projectfindr.controller;

import com.projectfindr.model.UserContactorCompany;
import com.projectfindr.model.UserContactorPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class ContactorPersonController {
    @Autowired
    private BancoService bd;

    @PostMapping
    public String addUserContactorPerson(@RequestBody UserContactorPerson contactorPerson){
        bd.addUserContactorPerson(contactorPerson);
        return "Contratante cadastrado com sucesso!";
    }

    @GetMapping
    public List<UserContactorPerson> getContactorPerson(){
        return bd.contactorPersons;
    }

    @DeleteMapping("/{email}/{password}")
    public String deleteUserContactorPerson(@PathVariable String email, @PathVariable String password){
        return bd.deleteUserContactorPerson(email, password);
    }

    @PostMapping("/login/{email}/{password}")
    public String setLoginContactorPerson(@PathVariable String email, @PathVariable String password){
        return bd.setLoginContactorPerson(email, password);
    }

    @PostMapping("/logoff/{email}/{password}")
    public String setLogoffContactorPerson(@PathVariable String email, @PathVariable String password){
        return bd.setLogoffContactorPerson(email, password);
    }
}
