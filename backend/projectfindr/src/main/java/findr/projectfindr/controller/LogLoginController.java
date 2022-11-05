package findr.projectfindr.controller;


import findr.projectfindr.model.LikeProject;
import findr.projectfindr.model.LogLoginContactor;
import findr.projectfindr.model.LogLoginFreelancer;
import findr.projectfindr.model.Match;
import findr.projectfindr.repository.LogLoginContactorRepositoy;
import findr.projectfindr.repository.LogLoginFreelancerRepositoy;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loglogin")
@CrossOrigin
public class LogLoginController {

    @Autowired
    private LogLoginFreelancerRepositoy logLoginFreelancerRepositoy;

    @Autowired
    private LogLoginContactorRepositoy logLoginContactorRepositoy;

    @GetMapping("/freelancer/{id}")
    public ResponseEntity getLogFreelancer(@PathVariable Long id){
        List<LogLoginFreelancer> lista = logLoginFreelancerRepositoy.findByFkFreelancer_fkFreelancer_IdUserFreelancer(id);
        if (!lista.isEmpty()){
            return ResponseEntity.status(200).body(lista.size());
        }
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/contactor/{id}")
    public ResponseEntity getLogContactor(@PathVariable Long id){
        List<LogLoginContactor> lista = logLoginContactorRepositoy.findByFkContactor_fkContactor_IdContactor(id);
        if(!lista.isEmpty()){
            return ResponseEntity.status(200).body(lista.size());
        }
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/total/freelancer")
    public ResponseEntity getTotalFreelancer(){
        List<LogLoginFreelancer> lista = logLoginFreelancerRepositoy.findAll();
        if(!lista.isEmpty()){
            return ResponseEntity.status(200).body(lista.size());
        }
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/total/contactor")
    public ResponseEntity getTotalContactor(){
        List<LogLoginContactor> lista = logLoginContactorRepositoy.findAll();
        if(!lista.isEmpty()){
            return ResponseEntity.status(200).body(lista.size());
        }
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/total/usuarios")
    public ResponseEntity getTotalUsuarios(){
        List<LogLoginContactor> listaCont = logLoginContactorRepositoy.findAll();
        List<LogLoginFreelancer> listaFree = logLoginFreelancerRepositoy.findAll();
        if(!listaCont.isEmpty() || !listaFree.isEmpty()){
            Integer total = listaCont.size() + listaFree.size();
            return ResponseEntity.status(200).body(total);
        }
        return ResponseEntity.status(204).build();
    }


}
