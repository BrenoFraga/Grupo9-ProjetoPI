package com.projectfindr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private BancoService bd;

//    @PostMapping
//    public ResponseEntity addUserContactorCompany(@RequestBody Contactor company) {
//        bd.addUserContactorCompany(company);
//        return ResponseEntity.status(201).build();
//    }
//
//    @GetMapping //verificar responseEntity
//    public ResponseEntity getCompany() {
//        return ResponseEntity.status(201).body(bd.contactorCompanies);
//    }
//
//    @DeleteMapping("/{email}/{password}")
//    public ResponseEntity deleteUserContactorCompany(@PathVariable String email, @PathVariable String password) {
//         bd.deleteUserContactorCompany(email, password);
//        return ResponseEntity.status(201).build();
//    }
//
//    @PostMapping("/login/{email}/{password}")
//    public ResponseEntity setLoginCompany(@PathVariable String email, @PathVariable String password) {
//        bd.setLoginCompany(email, password);
//        return ResponseEntity.status(201).build();
//    }
//
//    @PostMapping("/logoff/{email}/{password}")
//    public ResponseEntity setLogoffCompany(@PathVariable String email, @PathVariable String password) {
//        bd.setLogoffCompany(email, password);
//        return ResponseEntity.status(201).build();
//    }
}

