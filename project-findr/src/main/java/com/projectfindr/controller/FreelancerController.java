package com.projectfindr.controller;

import com.projectfindr.model.UserFreelancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/freelancer")
public class FreelancerController {
    @Autowired
    private BancoService bd;

    @PostMapping
    public String addUserFreelancer(@RequestBody UserFreelancer freelancer){
        bd.addUserFreelancer(freelancer);
        return "Usuário cadastrado com sucesso!";
    }

    @GetMapping
    public List<UserFreelancer> getFreelancer(){
        return bd.freelancers;
    }

    @DeleteMapping("/{email}/{password}")
    public String deleteUserFreelancer(@PathVariable String email, @PathVariable String password){
        return bd.deleteUserFreelancer(email, password);
    }

    @PostMapping("/login/{email}/{password}")
    public String setLoginFreelancer(@PathVariable String email, @PathVariable String password){
        return bd.setLoginFreelancer(email, password);
    }

    @PostMapping("/logoff/{email}/{password}")
    public String setLogoffFreelancer(@PathVariable String email, @PathVariable String password){
        return bd.setLogoffFreelancer(email, password);
    }
}
