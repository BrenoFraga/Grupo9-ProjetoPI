package findr.projectfindr.controller;

import findr.projectfindr.model.Contactor;
import findr.projectfindr.model.ProjectModel;
import findr.projectfindr.repository.ContactorRepository;
import findr.projectfindr.repository.ProjectRepository;
import findr.projectfindr.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class ContactorPersonController {
    @Autowired
    private ContactorRepository bd;

    @Autowired
    private ProjectRepository projects;

    @PostMapping
    public ResponseEntity addUserContactorPerson(@RequestBody Contactor company) {
        try {
            bd.save(company);
        }catch (Exception e){
            return ResponseEntity.status(406).build();
        }
        return ResponseEntity.status(201).build();
    }

    @GetMapping //verificar responseEntity
    public ResponseEntity getPerson() {
        if (!bd.findAll().isEmpty()){
            return ResponseEntity.status(200).body(bd.findAll());
        }
        return ResponseEntity.status(204).body(bd.findAll());
    }


    //feito-validar
//    @DeleteMapping("/{password}")
//    public ResponseEntity deleteUserContactorCompany(@PathVariable String password) {
//        if (password.equals(this.senha)){
//            bd.deleteById(this.idContactor);
//            return ResponseEntity.status(200).body(bd.findAll());
//        }
//        return ResponseEntity.status(204).build();
//    }

    //feito - validar
    @PostMapping("/login")
    public ResponseEntity setLoginCompany(@RequestBody LoginRequest login) {
        Contactor contactorAtual = bd.showByEmailAndPass(login.getEmail(), login.getPassword());
        if (contactorAtual != null){
            bd.atualizarOnline(contactorAtual.getIdContactor(), true);
            return ResponseEntity.status(200).build();
        }else{
        return ResponseEntity.status(204).build();
        }
    }

    //feito - validar
    @PostMapping("/logoff/{idContactor}")
    public ResponseEntity setLogoffCompany(
            @PathVariable long idContactor
    ) {
            bd.atualizarOnline(idContactor, false);
            return ResponseEntity.status(200).build();
    }


    //feito-validar
    @GetMapping("/projects/{idContactor}")
    public ResponseEntity myProjects(
            @PathVariable long idContactor
    ){
        List<ProjectModel> projetos = bd.showAllProjectsContactor(idContactor);
        if (projetos.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(projetos);
    }
}

