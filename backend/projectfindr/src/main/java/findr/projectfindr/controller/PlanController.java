package findr.projectfindr.controller;

import findr.projectfindr.model.Plans;
import findr.projectfindr.model.UserFreelancer;
import findr.projectfindr.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/plans")
public class PlanController {
    @Autowired
    private PlanRepository repository;

    @GetMapping
    private ResponseEntity getPlans(){
        if (repository.findAll().isEmpty()){
            return ResponseEntity.status(204).body(repository.findAll());
        }
        return ResponseEntity.status(200).body(repository.findAll());
    }

    @PostMapping
    public ResponseEntity salvarPlan(@RequestBody Plans plan){
        try {
            repository.save(plan);
        }catch (Exception e){
            return ResponseEntity.status(406).build();
        }
        return ResponseEntity.status(201).build();
    }
}
