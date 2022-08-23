package findr.projectfindr.controller;

import findr.projectfindr.model.SpecialtyModel;
import findr.projectfindr.repository.SpecialtyRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/specialty")
public class SpecialtyController {
    @Autowired
    private SpecialtyRepository bd;

    FreelancerController freelancerAtual = new FreelancerController();

    @PostMapping
    @Operation(summary = "Registros de 'especialidades' de freelancers",description =
            "Irá inserir freelancers no banco de dados",
            tags = {"API freelancer"})
    public ResponseEntity addSpecialty(@RequestBody SpecialtyModel specialty){
        try {
            bd.save(specialty);
        }catch (Exception e){
            return ResponseEntity.status(406).build();
        }
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    @Operation(summary = "Consulta de freelancers no banco de dados",description =
            "Irá consultar os  freelancers no banco de dados",
            tags = {"API freelancer"})
    public ResponseEntity getSpecialty(){
        if (bd.findAll().isEmpty()){
            return ResponseEntity.status(204).body(bd.findAll());
        }
        return ResponseEntity.status(200).body(bd.findAll());
    }




    @GetMapping("/{technology}")
    @Operation(summary = "Consulta de freelancers de acordo com uma especialidade",description =
            "Irá consultar os freelancers de acordo com a especialidade no banco de dados",
            tags = {"API freelancer"})
    public ResponseEntity getTecnologias(@PathVariable String technology){
        if (bd.findByTechnologyUsed(technology).isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(bd.findByTechnologyUsed(technology));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar freelancer por id",description =
            "Irá deletar por id um freelancer no banco de dados",
            tags = {"API freelancer"})
    public ResponseEntity deleteSpecialty(@PathVariable Long id){
        if (bd.existsById(id)){
            bd.deleteById(id);
            return ResponseEntity.status(200).body(bd.findAll());
        }
        return ResponseEntity.status(204).build();
    }
}
