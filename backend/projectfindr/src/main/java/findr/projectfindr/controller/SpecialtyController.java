package findr.projectfindr.controller;

import findr.projectfindr.model.SpecialtyModel;
import findr.projectfindr.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/specialty")
public class SpecialtyController {
    @Autowired
    private SpecialtyRepository bd;

    FreelancerController freelancerAtual = new FreelancerController();

    public FreelancerController getFreelancerAtual() {
        return  freelancerAtual;
    }
    // fk do freelancer para fazer a manipulação dos dados
    private Long fkFreelancer = getFreelancerAtual().getIdFreelancer();

    @PostMapping
    public ResponseEntity addSpecialty(@RequestBody SpecialtyModel specialty){
        try {
            bd.save(specialty);
        }catch (Exception e){
            return ResponseEntity.status(406).build();
        }
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity getSpecialty(){
        if (bd.findAll().isEmpty()){
            return ResponseEntity.status(204).body(bd.findAll());
        }
        return ResponseEntity.status(200).body(bd.findAll());
    }


    @GetMapping("/{technology}")
    public ResponseEntity getTecnologias(@PathVariable String technology){
        if (bd.findByTechnologyUsed(technology).isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(bd.findByTechnologyUsed(technology));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSpecialty(@PathVariable Long id){
        if (bd.existsById(id)){
            bd.deleteById(id);
            return ResponseEntity.status(200).body(bd.findAll());
        }
        return ResponseEntity.status(204).build();
    }
}
