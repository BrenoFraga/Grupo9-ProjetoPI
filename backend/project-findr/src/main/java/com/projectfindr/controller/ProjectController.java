package com.projectfindr.controller;

import com.projectfindr.model.RegisterProjectContactor;
import com.projectfindr.model.UserFreelancer;
import com.projectfindr.repository.FreelancerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@RestController
@RequestMapping("/project")
public class ProjectController {

//    @Autowired
//    private RegisterProjectContactor bd;

//    @PostMapping("/registerProjects")
//    public ResponseEntity addProjectCompany(
//            @RequestBody @Valid RegisterProjectContactor project){
//            bd.save(project);
//        return ResponseEntity.status(201).build();
//    }
//
//    @GetMapping
//    public ResponseEntity getProject(){
//        return ResponseEntity.status(200).body(bd.findAll());
//    }
//
//
//    @PostMapping("/deleteProject/{idProject}")
//    public ResponseEntity deletProject(@PathVariable Integer idProject){
//        bd.deleteById(idProject);
//        return ResponseEntity.status(201).build();
//    }

}



//    @PostMapping("/{email}/{password}")
//    public ResponseEntity addProjectCompany(@RequestBody RegisterProjectContactor project, @PathVariable String email, @PathVariable String password){
//        bd.addProjectCompany(project, email, password);
//        return ResponseEntity.status(201).build();
//    }
//
//    @PostMapping("/person/{email}/{password}")
//    public ResponseEntity addProjectContactorPerson(@RequestBody RegisterProjectContactor project, @PathVariable String email, @PathVariable String password){
//        bd.addProjectContactorPerson(project, email, password);
//        return ResponseEntity.status(201).build();
//    }
//
//    @GetMapping
//    public ResponseEntity getProjects(){
//        return ResponseEntity.status(201).body(bd.registerProjectContactors);
//    }
//
//    @DeleteMapping("/{nameProject}/{email}/{password}")
//    public ResponseEntity deleteProject(@PathVariable String nameProject, @PathVariable String email, @PathVariable String password){
//        bd.deleteProject(nameProject, email, password);
//        return ResponseEntity.status(201).build();
//    }
//
//    @PostMapping("/{email}/{password}/{nameProject}")
//    public ResponseEntity addUserFreelancerProject(@PathVariable String email, @PathVariable String password, @PathVariable String nameProject){
//        bd.addUserFreelancerProject(email, password, nameProject);
//        return ResponseEntity.status(201).build();
//    }

