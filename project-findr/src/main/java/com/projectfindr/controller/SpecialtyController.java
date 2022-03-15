package com.projectfindr.controller;

import com.projectfindr.model.Specialty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/specialty")
public class SpecialtyController {
    @Autowired
    private BancoService bd;

    @PostMapping("/{email}/{password}")
    public String addSpecialty(@RequestBody Specialty specialty, @PathVariable String email, @PathVariable String password){
        return bd.addSpecialty(specialty, email, password);
    }

    @GetMapping
    public List<Specialty> getSpecialty(){
        return bd.specialties;
    }
}
