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

    @PostMapping
    public ResponseEntity addSpecialty(@RequestBody SpecialtyModel specialty){
        bd.save(specialty);
        return ResponseEntity.status(200).build();
    }

    @GetMapping
    public ResponseEntity getSpecialty(){
        return ResponseEntity.status(200).body(bd.findAll());
    }


    @GetMapping("/{technology}")
    public ResponseEntity getTecnologias(@PathVariable String technology){
        return ResponseEntity.status(200).body(bd.findByTechnologyUsed(technology));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSpecialty(@PathVariable Long id){
        bd.deleteById(id);
        return ResponseEntity.status(200).build();
    }
}
