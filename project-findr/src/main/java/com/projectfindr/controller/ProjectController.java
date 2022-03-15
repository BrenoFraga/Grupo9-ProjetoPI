package com.projectfindr.controller;

import com.projectfindr.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private BancoService bd;

    @PostMapping("/{email}/{password}")
    public String addProjectCompany(@RequestBody Project project, @PathVariable String email, @PathVariable String password){
        return bd.addProjectCompany(project, email, password);
    }

    @PostMapping("/person/{email}/{password}")
    public String addProjectContactorPerson(@RequestBody Project project, @PathVariable String email, @PathVariable String password){
        return bd.addProjectContactorPerson(project, email, password);
    }

    @GetMapping
    public List<Project> getProjects(){
        return bd.projects;
    }

    @DeleteMapping("/{nameProject}/{email}/{password}")
    public String deleteProject(@PathVariable String nameProject, @PathVariable String email, @PathVariable String password){
        return bd.deleteProject(nameProject, email, password);
    }

    @PostMapping("/{email}/{password}/{nameProject}")
    public String addUserFreelancerProject(@PathVariable String email, @PathVariable String password, @PathVariable String nameProject){
        return bd.addUserFreelancerProject(email, password, nameProject);
    }
}
