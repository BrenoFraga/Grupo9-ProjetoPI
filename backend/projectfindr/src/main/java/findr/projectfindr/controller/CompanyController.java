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


   @GetMapping("/projects/idConctator")
   public ResponseEntity myProjects(@PathVariable long idContactor){
       List<ProjectModel> projetos = bd.showAllProjectsContactor(idContactor);
        if (projetos.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(projetos);
   }
}