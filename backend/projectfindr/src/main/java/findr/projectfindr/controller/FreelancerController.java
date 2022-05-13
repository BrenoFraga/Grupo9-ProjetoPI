package findr.projectfindr.controller;

import findr.projectfindr.model.Contactor;
import findr.projectfindr.model.SpecialtyModel;
import findr.projectfindr.model.UserFreelancer;
import findr.projectfindr.repository.FreelancerRepository;
import findr.projectfindr.repository.SpecialtyRepository;
import findr.projectfindr.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/freelancer")
public class FreelancerController {

    @Autowired
    private FreelancerRepository bd;
    @Autowired
    private SpecialtyRepository specialty;

    @PostMapping
    public ResponseEntity addUserFreelancer(@RequestBody @Valid UserFreelancer freelancer) {
        try {
            bd.save(freelancer);
        }catch (Exception e){
            return ResponseEntity.status(406).build();
        }
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity getFreelancer() {
        if (bd.findAll().isEmpty()){
            return ResponseEntity.status(204).body(bd.findAll());
        }
        return ResponseEntity.status(200).body(bd.findAll());
    }


    //rever esse
    @DeleteMapping("/{id}")
    public ResponseEntity deleteFreelancer(@PathVariable Long id) {
        if (bd.existsById(id)){
            bd.deleteById(id);
            return ResponseEntity.status(200).body(bd.findAll());
        }
        return ResponseEntity.status(404).build();
    }


    //feito - validar
    @PostMapping("/login")
    public ResponseEntity setLoginFreelancer(@RequestBody LoginRequest login) {
        UserFreelancer freelancerAtual = bd.showByEmailAndPass(login.getEmail(), login.getPassword());

        if (freelancerAtual != null){
            bd.atualizarOnline(freelancerAtual.getIdUserFreelancer(), true);

            return ResponseEntity.status(200).build();
        }else{
            return ResponseEntity.status(204).build();
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







