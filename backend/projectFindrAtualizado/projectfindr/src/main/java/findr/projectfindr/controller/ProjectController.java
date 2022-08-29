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
    public ResponseEntity getProjectByContactor(@PathVariable int fkContactor){
        if(bd.findByContactor(fkContactor).isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(bd.findByContactor(fkContactor));
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

//    @GetMapping("/relatorio/ler")
//    @Operation(summary = "Leitura de arquivo csv",description =
//            "Irá ler os arquivos encontrados no banco",
//            tags = {"API arquivos"})
//    public ResponseEntity getRelatorioLer(){
//        gravadorLeitor.leArquivoCsv("projetos");
//        return ResponseEntity.status(200).build();
//    }

//    @GetMapping("/relatorio/gravar")
//    @Operation(summary = "Gravação de arquivo csv",description =
//            "Irá gravar registros em um arquivo",
//            tags = {"API arquivos"})
//    public ResponseEntity getRelatorioGravar(){
//
//        List<ProjectModel> todos =  bd.findAll();
//
//        ListaObj<ProjectModel> listaProjetos = new ListaObj(todos.size());
//
//        todos.forEach(elem -> {
//            listaProjetos.adiciona(elem);
//        });
//
//        return ResponseEntity
//                .status(200)
//                .header("content-type", "text/csv")
//                .header("content-disposition", "filename=\"relatorio.csv\"")
//                .body(gravadorLeitor.gravaArquivoCsv(listaProjetos, "projetos"));
//    }


//    @GetMapping("/documento/gravar")
//    @Operation(summary = "Gravação do documento de layout",description =
//            "Irá gravar arquivos de projetos e usuários em um arquivo",
//            tags = {"API arquivos"})
//    public ResponseEntity getDocumentoLayoutGravar(){
//        List<ProjectModel> projectModels = bd.findAll();
//        ListaObj<ProjectModel> listaProjetos = new ListaObj(projectModels.size());
//
//        projectModels.forEach(elem -> {
//            listaProjetos.adiciona(elem);
//        });
//
//        List<UserResponse> userResponses = contactorRepository.findAllUserResponse();
//        ListaObj<UserResponse> listaUsuarios = new ListaObj(userResponses.size());
//
//        userResponses.forEach(elem ->{
//            listaUsuarios.adiciona(elem);
//        });
//
//        return ResponseEntity
//                .status(200)
//                .header("content-type", "text/csv")
//                .header("content-disposition", "filename=\"documentoLayout.txt\"")
//                .body(gravadorLeitor.gravaArquivoTxt(listaUsuarios, listaProjetos,"documento"));
//    }

//    @PostMapping(value = "/import-project", consumes = "multipart/form-data")
//    @Operation(summary = "Importação do documento de layout",description =
//            "Irá importar registros do documento de layout em um arquivo",
//            tags = {"API arquivos"})
//    public ResponseEntity postNovoProjeto(
//            @RequestBody MultipartFile newProject
//    ){
//        String nomeArq = newProject.getResource().getFilename();
//        if (gravadorLeitor.lerArquivoTxt(nomeArq)){
//            return ResponseEntity.status(200).build();
//        }
//        return ResponseEntity.status(404).build();
//    }

//    public static void gravaRegistro(String registro, String nomeArq){
//        BufferedWriter saida = null;
//
//        try{
//            saida = new BufferedWriter(new FileWriter(nomeArq, true));
//        }
//        catch (IOException erro){
//            System.out.println("Erro ao abrir o arquivo: " + erro);
//        }
//
//        try {
//            saida.append(registro + "\n");
//            saida.close();
//        }
//        catch (IOException erro){
//            System.out.println("Erro ao abrir o arquivo" + erro);
//        }
//    }
}
