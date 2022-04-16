package com.projectfindr.controller;

import com.projectfindr.model.UserFreelancer;
import com.projectfindr.repository.FreelancerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/freelancer")
    public class FreelancerController {

//        @Autowired
//        private FreelancerRepository bd;
//
//        @PostMapping
//        public ResponseEntity addUserFreelancer(@RequestBody UserFreelancer freelancer) {
//            bd.save(freelancer);
//            return ResponseEntity.status(201).build();
//        }
//
//        @GetMapping
//        public ResponseEntity getFreelancer() {
//            return ResponseEntity.status(201).body(bd.findAll());
//        }
//
//        @DeleteMapping("/{id}")
//        public ResponseEntity deleteFreelancer(@PathVariable Integer id) {
//            bd.deleteById(id);
//            return ResponseEntity.status(201).build();
//        }
//
    }

//    @PostMapping
//    public ResponseEntity addUserFreelancer(@RequestBody UserFreelancer freelancer){
//        bd.addUserFreelancer(freelancer);
//        return ResponseEntity.status(201).build();
//    }
//
//    @GetMapping
//    public ResponseEntity getFreelancer(){
//        return ResponseEntity.status(201).body(bd.freelancers);
//    }
//
//    @DeleteMapping("/{email}/{password}")
//    public ResponseEntity deleteUserFreelancer(@PathVariable String email, @PathVariable String password){
//        bd.deleteUserFreelancer(email, password);
//        return ResponseEntity.status(201).build();
//    }
//
//    @PostMapping("/login/{email}/{password}")
//    public ResponseEntity setLoginFreelancer(@PathVariable String email, @PathVariable String password){
//        bd.setLoginFreelancer(email, password);
//        return ResponseEntity.status(201).build();
//    }
//
//    @PostMapping("/logoff/{email}/{password}")
//    public ResponseEntity setLogoffFreelancer(@PathVariable String email, @PathVariable String password){
//        bd.setLogoffFreelancer(email, password);
//        return ResponseEntity.status(201).build();
//    }
//
//    @GetMapping("/history/{user}")
//    public ResponseEntity getUserHistory(@PathVariable String user){
//        bd.getUserHistory(user);
//        return ResponseEntity.status(201).build();
//    }







