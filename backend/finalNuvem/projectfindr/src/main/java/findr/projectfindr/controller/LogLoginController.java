package findr.projectfindr.controller;


import findr.projectfindr.repository.LogLoginRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loglogin")
@CrossOrigin
public class LogLoginController {

    @Autowired
    private LogLoginRepository logLoginRepositoy;


    @GetMapping
    @Operation(summary = "Consulta de novos logins",description =
            "Irá consultar todos os logs de login que existem no bando de dados",
            tags = {"API log"})
    public ResponseEntity getFreelancer() {
        if (logLoginRepositoy.findAll().isEmpty()){
            return ResponseEntity.status(204).body(logLoginRepositoy.findAll());
        }
        return ResponseEntity.status(200).body(logLoginRepositoy.findAll());
    }
}
