package findr.projectfindr.controller;

import findr.projectfindr.model.Contactor;
import findr.projectfindr.repository.ContactorRepository;
import findr.projectfindr.resposta.LoginResposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class ContactorPersonController {
    @Autowired
    private ContactorRepository bd;

    @PostMapping
    public ResponseEntity addUserContactorCompany(@RequestBody Contactor company) {
        bd.save(company);
        return ResponseEntity.status(200).build();
    }

    @GetMapping //verificar responseEntity
    public ResponseEntity getCompany() {
        return ResponseEntity.status(200).body(bd.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserContactorCompany(@PathVariable Long id) {
        bd.deleteById(id);
        return ResponseEntity.status(200).build();
    }

    @PostMapping("/login")
    public ResponseEntity setLoginCompany(@RequestBody LoginResposta login) {
        bd.findByEmailAndPassword(login.getEmail(), login.getPassword());
        return ResponseEntity.status(200).build();
    }

    @PostMapping("/logoff")
    public ResponseEntity setLogoffCompany(@RequestBody LoginResposta logoff) {
        bd.findByEmailAndPassword(logoff.getEmail(), logoff.getPassword());
        return ResponseEntity.status(200).build();
    }
}
