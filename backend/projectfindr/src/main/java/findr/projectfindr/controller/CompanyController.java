package findr.projectfindr.controller;

import findr.projectfindr.model.Contactor;
import findr.projectfindr.model.ProjectModel;
import findr.projectfindr.repository.ContactorRepository;
import findr.projectfindr.repository.ProjectRepository;
import findr.projectfindr.request.LoginRequest;
import io.swagger.v3.oas.annotations.Operation;
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
   @Operation(summary = "Consulta de projetos de acordo com um contratante",description =
           "Irá consultar no banco de dados os projetos de um unico contratante",
           tags = {"API project"})
   public ResponseEntity myProjects(@PathVariable long idContactor){
       List<ProjectModel> projetos = bd.showAllProjectsContactor(idContactor);
        if (projetos.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(projetos);
   }
}