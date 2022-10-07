package findr.projectfindr.controller;

import findr.projectfindr.datastructure.ListaObj;
import findr.projectfindr.importExport.GravarLerCsv;
import findr.projectfindr.model.Contactor;
import findr.projectfindr.model.ProjectModel;
import findr.projectfindr.repository.ContactorRepository;
import findr.projectfindr.repository.ProjectRepository;
import findr.projectfindr.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectRepository bd;

    @Autowired
    private ContactorRepository contactorRepository;

    private GravarLerCsv gravadorLeitor;

    @PostMapping
    @Operation(summary = "Registros de novos projetos",description =
            "Irá registrar no banco de dados novos projetos",
            tags = {"API project"})
    public ResponseEntity addProjectCompany(@RequestBody @Valid ProjectModel project) {
        try {
            bd.save(project);
        }catch (Exception e){
            return ResponseEntity.status(406).build();
        }
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    @Operation(summary = "Consulta de projetos no banco de dados",description =
            "Irá consultar os projetos cadastrados no banco de dados",
            tags = {"API project"})
    public ResponseEntity getProject() {
        if (bd.findAll().isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(bd.findAll());
    }


    @GetMapping("/{fkContactor}")
    @Operation(summary = "Irá buscar todos os projetos de um unico usuário",
    description = "irá buscar no banco os projetos de um unico usuário",
            tags = {"API project"}
    )
    public ResponseEntity getProjectByContactor(@PathVariable long fkContactor){
        if(bd.findByFkContactor_IdContactor(fkContactor).isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(bd.findByFkContactor_IdContactor(fkContactor));
    }

    @DeleteMapping("/{idProject}")
    @Operation(summary = "Deletar os projetos de acordo com um id",description =
            "Irá deletar os usuarios do banco de dados de acordo com um id de projeto especifico",
            tags = {"API project"})
    public ResponseEntity deleteProject(@PathVariable Long idProject) {
        if (bd.existsById(idProject)){
            bd.deleteById(idProject);
            return ResponseEntity.status(200).body(bd.findAll());
        }
        return ResponseEntity.status(204).build();
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
}
