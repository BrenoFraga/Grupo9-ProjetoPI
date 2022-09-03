package findr.projectfindr.controller;

import findr.projectfindr.model.Contactor;
import findr.projectfindr.model.ProjectModel;
import findr.projectfindr.repository.ContactorRepository;
import findr.projectfindr.repository.ProjectRepository;
import findr.projectfindr.request.LoginRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

@RestController
@RequestMapping("/contactor")
public class ContactorPersonController {
    @Autowired
    private ContactorRepository bd;

    @Autowired
    private ProjectRepository projects;

    @PostMapping
    @Operation(summary = "Cadastra novos contratantes",description =
            "Irá cadastrar um novo contratante informado no banco de dados",
                tags = {"API contactor"})
    public ResponseEntity addUserContactorPerson(@RequestBody Contactor company) {
        try {
            bd.save(company);
        }catch (Exception e){
            return ResponseEntity.status(406).build();
        }
        return ResponseEntity.status(201).build();
    }

    @PatchMapping(value = "/foto/{codigo}",consumes = "image/jpeg")
    public ResponseEntity atualizarFoto(@PathVariable long codigo,@RequestBody byte[] novaFoto) {
        try {
            bd.atualizarFoto(codigo,novaFoto);
        }catch (Exception e){
            return ResponseEntity.status(406).build();
        }
        return ResponseEntity.status(201).build();
    }


    @GetMapping(value = "/foto/{codigo}", produces = "image/jpeg")
    public ResponseEntity<byte[]> getFoto(@PathVariable long codigo) {

        byte[] foto = bd.getFoto(codigo);
        if (foto == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(foto);
    }

    @GetMapping //verificar responseEntity
    @Operation(summary = "Consulta de contratantes",description =
            "Irá trazer todos os contratantes cadastrados no banco de dados",
            tags = {"API contactor"})
    public ResponseEntity getPerson() {
        if (!bd.findAll().isEmpty()){
            return ResponseEntity.status(200).body(bd.findAll());
        }
        return ResponseEntity.status(204).build();
    }


    @GetMapping("/perfil/{id}")
    public ResponseEntity getPerfil(@PathVariable Long id){
        if(bd.existsById(id)){
            bd.showByIdPerfil(id);
            return  ResponseEntity.status(200).body(bd.showByIdPerfil(id));
        }
        return ResponseEntity.status(404).build();
    }


    @DeleteMapping("/{codigo}/{password}")
    public ResponseEntity deleteUserContactorCompany(@PathVariable long codigo,@PathVariable String password) {
        if (bd.getById(codigo).getPassword().equals(password)){
            bd.deleteById(codigo);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(204).build();
    }


    @PostMapping("/login")
    @Operation(summary = "Login de contratantes",description =
            "Consulta um unico usuário de acordo com o email e senha informados",
            tags = {"API contactor"})
    public ResponseEntity setLoginCompany(@RequestBody LoginRequest login) {
        Contactor contactorAtual = bd.showByEmailAndPass(login.getEmail(), login.getPassword());
        if (contactorAtual != null){
            return ResponseEntity.status(200).build();
        }else{
        return ResponseEntity.status(204).build();
        }
    }

    @GetMapping("/projects/{idContactor}")
    @Operation(summary = "Cadastra novos de projetos",description =
            "Irá cadastrar um novo projeto informado no banco de dados",
            tags = {"API contactor"})
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

