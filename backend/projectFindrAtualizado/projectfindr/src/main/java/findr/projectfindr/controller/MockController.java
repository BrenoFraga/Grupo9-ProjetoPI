package findr.projectfindr.controller;

import findr.projectfindr.model.MockContactor;
import findr.projectfindr.model.MockFreelancer;
import findr.projectfindr.model.UserFreelancer;
import findr.projectfindr.repository.MockContactorRepositoy;
import findr.projectfindr.repository.MockFreelancerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/mock")
@CrossOrigin
public class MockController {
    @Autowired
    private MockContactorRepositoy mockContactor;

    @Autowired
    private MockFreelancerRepository mockFreelancer;


    @GetMapping("/freelancer")
    private ResponseEntity getMatchMockFreelancer(){
        if(!mockFreelancer.findAll().isEmpty()){
            return ResponseEntity.status(200).body(mockFreelancer.findAll());
        }
        return ResponseEntity.status(204).build();
    }

    @PostMapping("/freelancer")
    private ResponseEntity setMatchMockFreelancer(@RequestBody MockFreelancer m){
        try {
            mockFreelancer.save(m);
        }catch (Exception e){
            return ResponseEntity.status(406).build();
        }
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/contactor")
    private ResponseEntity getMatchMockContactor(){
        if(!mockContactor.findAll().isEmpty()){
            return ResponseEntity.status(200).body(mockContactor.findAll());
        }
        return ResponseEntity.status(204).build();
    }

    @PostMapping("/contactor")
    private ResponseEntity setMatchMockContactor(@RequestBody MockContactor m){
        try {
            mockContactor.save(m);
        }catch (Exception e){
            return ResponseEntity.status(406).build();
        }
        return ResponseEntity.status(201).build();
    }

    private List recursividade(List<MockContactor> m, int a){
        if(a >0){

        }
        return m;
    }
}
