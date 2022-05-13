package findr.projectfindr.controller;

import findr.projectfindr.model.Contactor;
import findr.projectfindr.model.ProjectModel;
import findr.projectfindr.repository.ContactorRepository;
import findr.projectfindr.repository.ProjectRepository;
import findr.projectfindr.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private ContactorRepository bd;

    @Autowired
    private ProjectRepository projects;

    //verificar esse método
    @PostMapping
    public ResponseEntity addUserContactorCompany(@RequestBody Contactor company) {
        try {
            bd.save(company);
        }catch (Exception e){
            return ResponseEntity.status(406).build();
        }
        return ResponseEntity.status(201).build();
    }

    //esse find all vai trazer o que ? e esse getCompany vai servir para que ?
    @GetMapping //verificar responseEntity
    public ResponseEntity getCompany() {
        if (bd.findAll().isEmpty()){
            return ResponseEntity.status(204).body(bd.findAll());
        }
        return ResponseEntity.status(200).body(bd.findAll());
    }


    //feito - validar
//    @DeleteMapping("/{password}")
//    public ResponseEntity deleteUserContactorCompany(@PathVariable String password) {
//        if (password.equals(this.senha)){
//            bd.deleteById(this.idContactor);
//            return ResponseEntity.status(200).body(bd.findAll());
//        }
//        return ResponseEntity.status(204).build();
//    }

    //feito - validar
   @GetMapping("/projects/idConctator")
   public ResponseEntity myProjects(@PathVariable long idContactor){
       List<ProjectModel> projetos = bd.showAllProjectsContactor(idContactor);
        if (projetos.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(projetos);
   }
}