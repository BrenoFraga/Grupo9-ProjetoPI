package findr.projectfindr.controller;

import findr.projectfindr.model.Contactor;
import findr.projectfindr.model.SpecialtyModel;
import findr.projectfindr.model.UserFreelancer;
import findr.projectfindr.repository.FreelancerRepository;
import findr.projectfindr.repository.SpecialtyRepository;
import findr.projectfindr.request.LoginRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/freelancer")
@CrossOrigin
public class FreelancerController {

    @Autowired
    private FreelancerRepository bd;
    @Autowired
    private SpecialtyRepository specialty;

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


    //rever esse
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


    //feito - validar

    @PostMapping("/login")
    @Operation(summary = "Login de freelancer",description =
            "Irá consultar um freelancer informado para realizar o login",
            tags = {"API freelancer"})
    public ResponseEntity setLoginFreelancer(@RequestBody LoginRequest login) {
        UserFreelancer freelancerAtual = bd.findByEmailAndPassword(login.getEmail(), login.getPassword());
        if (freelancerAtual != null){
            return ResponseEntity.status(200).build();
        }else{
            return ResponseEntity.status(404).build();
        }
    }



    //feito - validar
//    @DeleteMapping ("/logoff/{idFreelancer")
//    public ResponseEntity setLogoffFreelancer(@PathVariable long idFreelancer) {
//        bd.atualizarOnline(idFreelancer, false);
//        return ResponseEntity.status(201).build();
//    }


//    feito - validar
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
}







