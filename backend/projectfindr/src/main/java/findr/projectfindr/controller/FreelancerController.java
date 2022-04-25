package findr.projectfindr.controller;

import findr.projectfindr.model.UserFreelancer;
import findr.projectfindr.repository.FreelancerRepository;
import findr.projectfindr.resposta.LoginResposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/freelancer")
public class FreelancerController {

    @Autowired
    private FreelancerRepository bd;

    @PostMapping
    public ResponseEntity addUserFreelancer(@RequestBody @Valid UserFreelancer freelancer) {
        bd.save(freelancer);
        return ResponseEntity.status(200).build();
    }

    @GetMapping
    public ResponseEntity getFreelancer() {
        return ResponseEntity.status(200).body(bd.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFreelancer(@PathVariable Long id) {
        bd.deleteById(id);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/login")
    public ResponseEntity getFreelancerLogin(@RequestBody LoginResposta login) {
        bd.findByEmailAndPassword(login.getEmail(), login.getPassword());
        return ResponseEntity.status(200).build();
    }

    @GetMapping("/logoff")
    public ResponseEntity getFreelancerLogoff(@RequestBody LoginResposta logoff) {
        return ResponseEntity.status(200).body(bd.findByEmailAndPassword(logoff.getEmail(), logoff.getPassword()));
    }
}







