package findr.projectfindr.controller;

import findr.projectfindr.datastructure.hashtable.HashTable;
import findr.projectfindr.model.*;
import findr.projectfindr.pks.pkLogLoginFreelancer;
import findr.projectfindr.repository.FreelancerRepository;
import findr.projectfindr.repository.LogLoginFreelancerRepositoy;
import findr.projectfindr.repository.SpecialtyRepository;
import findr.projectfindr.request.LoginRequest;
import findr.projectfindr.service.S3Service;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/freelancer")
@CrossOrigin
public class FreelancerController {

    @Autowired
    private FreelancerRepository bd;
    @Autowired
    private SpecialtyRepository specialty;
    @Autowired
    private LogLoginFreelancerRepositoy logLoginFreelancerRepositoy;

   @Autowired
    private S3Service s3Service;

    private String defaultBucketName = "findr-images";

    @PostMapping
    @Operation(summary = "Cadastra novos freelancers",description =
            "Irá cadastrar um novo freelancer informado no banco de dados",
            tags = {"API freelancer"})
    public ResponseEntity addUserFreelancer(@RequestBody @Valid UserFreelancer freelancer) {
        try {
            bd.save(freelancer);
        }catch (Exception e){
            return ResponseEntity.status(406).build();
        }
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    @Operation(summary = "Consulta de novos freelancers",description =
            "Irá consultar todos os freelancers que existem no bando de dados",
            tags = {"API freelancer"})
    public ResponseEntity getFreelancer() {
        if (bd.findAll().isEmpty()){
            return ResponseEntity.status(204).body(bd.findAll());
        }
        return ResponseEntity.status(200).body(bd.findAll());
    }

    @GetMapping("/recursividade/{id}")
    public ResponseEntity getRecursividade(long id){
        UserFreelancer[] usr2 = bd.findAll().toArray(new UserFreelancer[0]);
        List<UserFreelancer> usr = new ArrayList<>();
        if(usr2.length != 0) {
            usr.add(recursividade(usr2,0));
            return ResponseEntity.status(200).body(usr2);

        }

        return ResponseEntity.status(404).build();
    }

    public static UserFreelancer recursividade(UserFreelancer[] u, int cont){
        UserFreelancer a = null;
        if(cont != u.length){
            a = u[cont];
            cont ++;
            recursividade(u,cont);
        }
        return a;
    }

    @GetMapping("/perfil/{email}")
    public ResponseEntity getPerfil(@PathVariable String email){
        if(bd.findByEmail(email) != null){
            return  ResponseEntity.status(200).body(bd.findByEmail(email));
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta por id",description =
            "Irá deletar do banco de dados um freelancer de acordo com id",
            tags = {"API freelancer"})
    public ResponseEntity deleteFreelancer(@PathVariable Long id) {
        if (bd.existsById(id)){
            bd.deleteById(id);
            return ResponseEntity.status(200).body(bd.findAll());
        }
        return ResponseEntity.status(404).build();
    }


    @PostMapping("/login")
    @Operation(summary = "Login de freelancer",description =
            "Irá consultar um freelancer informado para realizar o login",
            tags = {"API freelancer"})
    public ResponseEntity setLoginFreelancer(@RequestBody LoginRequest login) {
        UserFreelancer freelancerAtual = bd.findByEmailAndPassword(login.getEmail(), login.getPassword());
        if (freelancerAtual != null){
            pkLogLoginFreelancer pk = new pkLogLoginFreelancer(freelancerAtual);
            Date log = new Date();
            LogLoginFreelancer free = new LogLoginFreelancer(pk,log);
            logLoginFreelancerRepositoy.save(free);
            return ResponseEntity.status(200).body(freelancerAtual);
        }else{
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/specialtys/{idFreelancer}")
    @Operation(summary = "Consulta as especialidades de um freelancer",description =
            "Irá consultar no banco de dados as especialidades de um freelancer especifico",
            tags = {"API freelancer"})
    public ResponseEntity mySpecialtys(
            @PathVariable long idFreelancer
    ){
        List<SpecialtyModel> especialidades = bd.showAllSpecialty(idFreelancer);
        if (especialidades.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(especialidades);
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


    @GetMapping("/busca/{nomeFreelancer}")
    public ResponseEntity getFreelancerBusca(@PathVariable String nomeFreelancer){
        if(bd.findAll().isEmpty()){
            return ResponseEntity.status(204).body("Lista vazia");
        }
        List<UserFreelancer> freelancers = bd.findAll();
        String primeiraLetraBusca = "";
        HashTable hashTable = new HashTable(27);
        UserFreelancer freelancerChange = new UserFreelancer();

        char[] arr =nomeFreelancer.toCharArray();
        primeiraLetraBusca = String.valueOf(arr[0]);

        for (UserFreelancer s : freelancers) {
            if (s != null) {
                hashTable.insere(primeiraLetraBusca.toUpperCase(), s.getName());
            }
        }
        if(hashTable.busca(primeiraLetraBusca,nomeFreelancer)){
            for (UserFreelancer freelancer : freelancers) {
                if (freelancer.getName().equals(nomeFreelancer)) {
                    freelancerChange = freelancer;
                }
            }
        }
            return ResponseEntity.status(200).body(freelancerChange);
    }

    @PatchMapping(value = "/updateImages/{fkFreelancer}", consumes = "image/jpeg")
    public ResponseEntity createObject(@PathVariable Long fkFreelancer,@RequestBody byte[] file) throws IOException {
        UUID idImage = UUID.randomUUID();
        bd.setImageFreelancer(idImage.toString(),fkFreelancer);
        s3Service.putObject(idImage.toString(), file);
        return ResponseEntity.status(200).body("Imagem atualizada com sucesso");
    }

    @GetMapping(value = "/getImages/{fkFreelancer}", produces = "image/jpeg")
    public ResponseEntity getObject(@PathVariable Long fkFreelancer) throws IOException {
        UserFreelancer freelancer = bd.findByIdUserFreelancer(fkFreelancer);
        try{
        return ResponseEntity.status(200).body(s3Service.getObject(freelancer.getImage()));}
        catch (Exception e){
            return ResponseEntity.status(200).body(e.getMessage());}
        }


    @DeleteMapping(value = "/delete/{fkFreelancer}")
    public ResponseEntity deleteObject(@PathVariable Long fkFreelancer) throws IOException {
        UserFreelancer freelancer = bd.findByIdUserFreelancer(fkFreelancer);
        s3Service.deleteObject(freelancer.getImage());
        return ResponseEntity.status(202).build();
    }
}







