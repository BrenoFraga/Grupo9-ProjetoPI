package findr.projectfindr.controller;

import findr.projectfindr.model.ProjectModel;
import findr.projectfindr.repository.ProjectRepository;
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
    public ResponseEntity addProjectCompany(
            @RequestBody @Valid ProjectModel project){
            bd.save(project);
        return ResponseEntity.status(200).build();
    }

    @GetMapping
    public ResponseEntity getProject(){
        return ResponseEntity.status(200).body(bd.findAll());
    }

    @DeleteMapping("/{idProject}")
    public ResponseEntity deletProject(@PathVariable Long idProject){
        bd.deleteById(idProject);
        return ResponseEntity.status(200).build();
    }

}
