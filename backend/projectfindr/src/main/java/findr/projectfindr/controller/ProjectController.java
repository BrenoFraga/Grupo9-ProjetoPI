package findr.projectfindr.controller;

import com.amazonaws.services.lookoutequipment.model.S3Object;
import findr.projectfindr.importExport.GravarLerCsv;
import findr.projectfindr.model.ProjectModel;
import findr.projectfindr.repository.ContactorRepository;
import findr.projectfindr.repository.ProjectRepository;
import findr.projectfindr.service.S3Service;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.*;
import java.util.*;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectRepository bd;

    @Autowired
    private ContactorRepository contactorRepository;

    private GravarLerCsv gravadorLeitor;

    @Autowired
    private S3Service s3Service;

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

    @GetMapping("/required/languages")
    public ResponseEntity getByProject() {
        if (bd.findAll().isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(bd.tecs());
    }

    @PatchMapping(value = "/updateImages/{fkProject}", consumes = "image/jpeg")
    public ResponseEntity createObject(@PathVariable Long fkProject, @RequestBody byte[] file) throws IOException {
        UUID idImage = UUID.randomUUID();
        bd.setImageProject(idImage.toString(),fkProject);
        s3Service.putObject(idImage.toString(), file);
        return ResponseEntity.status(200).body("Imagem atualizada com sucesso");
    }

    @GetMapping(value = "/getImages/{fkProject}", produces = "image/jpeg")
    public ResponseEntity getObject(@PathVariable Long fkProject) throws IOException {
        ProjectModel project = bd.findByIdProjectContactor(fkProject);
        try {
            String idImage = project.getImage();
            ByteArrayResource resource = new ByteArrayResource(s3Service.getObject(idImage));
            return ResponseEntity.status(200).body(resource);
        }catch (Exception e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/delete/{fkProject}")
    public ResponseEntity deleteObject(@PathVariable Long fkProject) throws IOException {
        ProjectModel project = bd.findByIdProjectContactor(fkProject);
        s3Service.deleteObject(project.getImage());
        return ResponseEntity.status(202).build();
    }
}
