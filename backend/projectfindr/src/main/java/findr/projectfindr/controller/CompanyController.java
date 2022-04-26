package findr.projectfindr.controller;

import findr.projectfindr.model.Contactor;
import findr.projectfindr.repository.ContactorRepository;
import findr.projectfindr.repository.ProjectRepository;
import findr.projectfindr.resposta.LoginResposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private ContactorRepository bd;

    @Autowired
    private ProjectRepository projects;

    @PostMapping
    public ResponseEntity addUserContactorCompany(@RequestBody Contactor company) {
        try {
            bd.save(company);
        }catch (Exception e){
            return ResponseEntity.status(406).build();
        }
        return ResponseEntity.status(201).build();
    }

    @GetMapping //verificar responseEntity
    public ResponseEntity getCompany() {
        if (bd.findAll().isEmpty()){
            return ResponseEntity.status(204).body(bd.findAll());
        }
        return ResponseEntity.status(200).body(bd.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserContactorCompany(@PathVariable Long id) {
        if (bd.existsById(id)){
            bd.deleteById(id);
            return ResponseEntity.status(200).body(bd.findAll());
        }
        return ResponseEntity.status(204).build();
    }

    @PostMapping("/login")
    public ResponseEntity setLoginCompany(@RequestBody LoginResposta login) {
        if (!bd.findByEmailAndPassword(login.getEmail(), login.getPassword()).isEmpty()){
            bd.atualizarOnline(login.getEmail(), login.getPassword(), true);
            return ResponseEntity.status(201).build();
        }
        return ResponseEntity.status(204).build();
    }

    @PostMapping("/logoff")
    public ResponseEntity setLogoffCompany(@RequestBody LoginResposta logoff) {
        if (!bd.findByEmailAndPassword(logoff.getEmail(), logoff.getPassword()).isEmpty()){
            bd.atualizarOnline(logoff.getEmail(), logoff.getPassword(), false);
            return ResponseEntity.status(201).build();
        }
        return ResponseEntity.status(204).build();
    }

   @GetMapping("/projects/{idCompany}")
   public ResponseEntity myProjects(@PathVariable Integer idCompany){
        if (projects.findByFkContactor(idCompany).isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(projects.findByFkContactor(idCompany));
   }
}