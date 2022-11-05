package findr.projectfindr.controller;

import findr.projectfindr.datastructure.hashtable.HashTable;
import findr.projectfindr.model.*;
import findr.projectfindr.pks.pkLogLoginContactor;
import findr.projectfindr.repository.ContactorRepository;
import findr.projectfindr.repository.LogLoginContactorRepositoy;
import findr.projectfindr.repository.ProjectRepository;
import findr.projectfindr.request.LoginRequest;
import findr.projectfindr.service.S3Service;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/contactor")
public class ContactorPersonController {
    @Autowired
    private ContactorRepository bd;

    @Autowired
    private ProjectRepository projects;

    @Autowired
    private LogLoginContactorRepositoy logLoginContactorRepositoy;

    @Autowired
    private S3Service s3Service;

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
            pkLogLoginContactor pk = new pkLogLoginContactor(contactorAtual);
            Date dataLog = new Date();
            LogLoginContactor log = new LogLoginContactor(pk,dataLog);
            logLoginContactorRepositoy.save(log);
            return ResponseEntity.status(200).body(contactorAtual);
        }else{
        return ResponseEntity.status(204).build();
        }
    }

    @GetMapping("/perfil/email/{email}")
    public ResponseEntity getPerfil(@PathVariable String email){
        if(bd.findByEmail(email) != null){
            return  ResponseEntity.status(200).body(bd.findByEmail(email));
        }
        return ResponseEntity.status(404).build();
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

    @GetMapping("/busca/{nomeContactor}")
    public ResponseEntity getFreelancerBusca(@PathVariable String nomeContactor){
        if(bd.findAll().isEmpty()){
            return ResponseEntity.status(204).body("Lista vazia");
        }
        List<Contactor> contactors = bd.findAll();
        String primeiraLetraBusca = "";
        HashTable hashTable = new HashTable(27);
        Contactor contactorChange = new Contactor();

        char[] arr = nomeContactor.toCharArray();
        primeiraLetraBusca = String.valueOf(arr[0]);

        for (Contactor c : contactors) {
            if (c != null) {
                hashTable.insere(primeiraLetraBusca.toUpperCase(), c.getName());
            }
        }
        if(hashTable.busca(primeiraLetraBusca,nomeContactor)){
            for (Contactor contactor : contactors) {
                if (contactor.getName().equals(nomeContactor)) {
                    contactorChange = contactor;
                }
            }
        }
        return ResponseEntity.status(200).body(contactorChange);
    }
    @PatchMapping(value = "/updateImages/{fkContactor}", consumes = "image/jpeg")
    public ResponseEntity createObject(@PathVariable Long fkContactor, @RequestBody byte[] novaFoto) throws IOException {
        UUID idImage = UUID.randomUUID();
        bd.setImageContactor(idImage.toString(),fkContactor);
        s3Service.putObject(idImage.toString(), novaFoto);
        return ResponseEntity.status(200).body("Imagem atualizada com sucesso");
    }
    public InputStream convert(byte[] foto)
            throws IOException {
        byte[] initialArray = { 0, 1, 2 };
        return new ByteArrayInputStream(foto);
    }
    @GetMapping(value = "/getImages/{fkContactor}", produces = "image/jpeg")
    public ResponseEntity getObject(@PathVariable Long fkContactor) throws IOException {
        Contactor contactor = bd.findByIdContactor(fkContactor);
        try{
        return ResponseEntity.status(200).body(s3Service.getObject(contactor.getImage()));
        }catch (Exception e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/delete/{fkContactor}")
    public ResponseEntity deleteObject(@PathVariable Long fkContactor) throws IOException {
        Contactor contactor = bd.findByIdContactor(fkContactor);
        s3Service.deleteObject(contactor.getImage());
        return ResponseEntity.status(202).build();
    }
}

