package com.projectfindr.controller;

import com.projectfindr.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private BancoService bd;

    @PostMapping("/{email}/{password}")
    public ResponseEntity addProjectCompany(@RequestBody Project project, @PathVariable String email, @PathVariable String password){
        bd.addProjectCompany(project, email, password);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/person/{email}/{password}")
    public ResponseEntity addProjectContactorPerson(@RequestBody Project project, @PathVariable String email, @PathVariable String password){
        bd.addProjectContactorPerson(project, email, password);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity getProjects(){
        return ResponseEntity.status(201).body(bd.projects);
    }

    @DeleteMapping("/{nameProject}/{email}/{password}")
    public ResponseEntity deleteProject(@PathVariable String nameProject, @PathVariable String email, @PathVariable String password){
        bd.deleteProject(nameProject, email, password);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/{email}/{password}/{nameProject}")
    public ResponseEntity addUserFreelancerProject(@PathVariable String email, @PathVariable String password, @PathVariable String nameProject){
        bd.addUserFreelancerProject(email, password, nameProject);
        return ResponseEntity.status(201).build();
    }
}
