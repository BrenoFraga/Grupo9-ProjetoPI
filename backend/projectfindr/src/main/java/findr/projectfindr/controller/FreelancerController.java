package findr.projectfindr.controller;

import findr.projectfindr.model.UserFreelancer;
import findr.projectfindr.repository.FreelancerRepository;
import findr.projectfindr.repository.SpecialtyRepository;
import findr.projectfindr.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/freelancer")
public class FreelancerController {

    @Autowired
    private FreelancerRepository bd;
    @Autowired
    private SpecialtyRepository specialty;

    @PostMapping
    public ResponseEntity addUserFreelancer(@RequestBody @Valid UserFreelancer freelancer) {
        try {
            bd.save(freelancer);
        }catch (Exception e){
            return ResponseEntity.status(406).build();
        }
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity getFreelancer() {
        if (bd.findAll().isEmpty()){
            return ResponseEntity.status(204).body(bd.findAll());
        }
        return ResponseEntity.status(200).body(bd.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFreelancer(@PathVariable Long id) {
        if (bd.existsById(id)){
            bd.deleteById(id);
            return ResponseEntity.status(200).body(bd.findAll());
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping("/login")
    public ResponseEntity setLoginFreelancer(@RequestBody LoginRequest login) {
        if (!bd.findByEmailAndPassword(login.getEmail(), login.getPassword()).isEmpty()){
            bd.atualizarOnline(login.getEmail(), login.getPassword(), true);
            return ResponseEntity.status(201).build();
        }
        return ResponseEntity.status(401).build();
    }

    @DeleteMapping ("/logoff")
    public ResponseEntity setLogoffFreelancer(@RequestBody LoginRequest logoff) {
        if (!bd.findByEmailAndPassword(logoff.getEmail(), logoff.getPassword()).isEmpty()){
            bd.atualizarOnline(logoff.getEmail(), logoff.getPassword(), false);
            return ResponseEntity.status(201).build();
        }
        return ResponseEntity.status(401).build();
    }

    @GetMapping("/specialtys/{idFreelancer}")
    public ResponseEntity mySpecialtys(@PathVariable Integer idFreelancer){
        if (specialty.findByFkFreelancer(idFreelancer).isEmpty()){
            return ResponseEntity.status(204).build();
        }else if (!bd.existsById(idFreelancer.longValue())){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(specialty.findByFkFreelancer(idFreelancer));
    }
}







