package com.projectfindr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/specialty")
public class SpecialtyController {
    @Autowired
    private BancoService bd;

//    @PostMapping("/{email}/{password}")
//    public String addSpecialty(@RequestBody RegisterSpecialtyUser specialty, @PathVariable String email, @PathVariable String password){
//        return bd.addSpecialty(specialty, email, password);
//    }
//
//    @GetMapping
//    public List<RegisterSpecialtyUser> getSpecialty(){
//        return bd.specialties;
//    }


//    @GetMapping
//    public ResponseEntity getTecnologias(){
//        List<RegisterSpecialtyUser> lista =
//    }
}
