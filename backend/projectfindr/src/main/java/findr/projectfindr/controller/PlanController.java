package findr.projectfindr.controller;

import findr.projectfindr.model.Plans;
import findr.projectfindr.model.UserFreelancer;
import findr.projectfindr.repository.PlanRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/plans")
public class PlanController {
    @Autowired
    private PlanRepository repository;

    @GetMapping
    @Operation(summary = "Consulta de planos disponiveis no banco de dados",description =
            "Irá consultar os planos de usuários no banco de dados",
            tags = {"API planos"})
    @Cacheable("plans")
    private ResponseEntity getPlans(){
        if (repository.findAll().isEmpty()){
            return ResponseEntity.status(204).body(repository.findAll());
        }
        return ResponseEntity.status(200).body(repository.findAll());
    }

    @PostMapping
    @Operation(summary = "Registrar planos no banco de dados",description =
            "Irá registrar no banco de dados planos de usuários novos",
            tags = {"API planos"})
    @CacheEvict(value = "plans", allEntries = true)
    public ResponseEntity salvarPlan(@RequestBody Plans plan){
        try {
            repository.save(plan);
        }catch (Exception e){
            return ResponseEntity.status(406).build();
        }
        return ResponseEntity.status(201).build();
    }
}
