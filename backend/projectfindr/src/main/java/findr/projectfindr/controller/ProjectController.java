package findr.projectfindr.controller;

import findr.projectfindr.model.ProjectModel;
import findr.projectfindr.repository.ProjectRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectRepository bd;

    @PostMapping
    @Operation(summary = "Registros de novos projetos",description =
            "Irá registrar no banco de dados novos projetos",
            tags = {"API project"})
    public ResponseEntity addProjectCompany(@RequestBody @Valid ProjectModel project) {
        try {
            bd.save(project);
        }catch (Exception e){
            return ResponseEntity.status(406).build();
        }
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    @Operation(summary = "Consulta de projetos no banco de dados",description =
            "Irá consultar os projetos cadastrados no banco de dados",
            tags = {"API project"})
    public ResponseEntity getProject() {
        if (bd.findAll().isEmpty()){
            return ResponseEntity.status(204).body(bd.findAll());
        }
        return ResponseEntity.status(200).body(bd.findAll());
    }

    @DeleteMapping("/{idProject}")
    @Operation(summary = "Deletar os projetos de acordo com um id",description =
            "Irá deletar os usuarios do banco de dados de acordo com um id de projeto especifico",
            tags = {"API project"})
    public ResponseEntity deleteProject(@PathVariable Long idProject) {
        if (bd.existsById(idProject)){
            bd.deleteById(idProject);
            return ResponseEntity.status(200).body(bd.findAll());
        }
        return ResponseEntity.status(204).build();
    }

}
