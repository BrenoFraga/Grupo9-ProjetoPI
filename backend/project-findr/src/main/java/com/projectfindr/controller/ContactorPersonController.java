package com.projectfindr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class ContactorPersonController {
    @Autowired
    private BancoService bd;

//    @PostMapping
//    public ResponseEntity addUserContactorPerson(@RequestBody UserContactorPerson contactorPerson){
//        bd.addUserContactorPerson(contactorPerson);
//        return ResponseEntity.status(201).build();
//    }
//
//    @GetMapping //verificar responseEntity
//    public ResponseEntity getContactorPerson(){
//        return ResponseEntity.status(201).body(bd.contactorPersons);
//    }
//
//    @DeleteMapping("/{email}/{password}")
//    public ResponseEntity deleteUserContactorPerson(@PathVariable String email, @PathVariable String password){
//        bd.deleteUserContactorPerson(email, password);
//        return ResponseEntity.status(201).build();
//    }
//
//    @PostMapping("/login/{email}/{password}")
//    public ResponseEntity setLoginContactorPerson(@PathVariable String email, @PathVariable String password){
//        bd.setLoginContactorPerson(email, password);
//        return ResponseEntity.status(201).build();
//    }
//
//    @PostMapping("/logoff/{email}/{password}")
//    public ResponseEntity setLogoffContactorPerson(@PathVariable String email, @PathVariable String password){
//        bd.setLogoffContactorPerson(email, password);
//        return ResponseEntity.status(201).build();
//    }
}