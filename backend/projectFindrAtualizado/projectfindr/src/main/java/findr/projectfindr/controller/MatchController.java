package findr.projectfindr.controller;

import findr.projectfindr.repository.ContactorRepository;
import findr.projectfindr.repository.FreelancerRepository;
import findr.projectfindr.repository.MatchRepositoy;
import findr.projectfindr.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/match")
public class MatchController {

    @Autowired
    private MatchRepositoy matchRepositoy;

    @GetMapping("/freelancer/{fkFreelancer}")
    public ResponseEntity getMatchFreelancer(@PathVariable long fkFreelancer){
        if(matchRepositoy.findByIdMatch_fkFreelancer_IdUserFreelancer(fkFreelancer).isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(matchRepositoy.findByIdMatch_fkFreelancer_IdUserFreelancer(fkFreelancer));
    }

    @GetMapping("/contactor/{fkContactor}")
    public ResponseEntity getMatchContactor(@PathVariable long fkContactor){
        if(matchRepositoy.findByIdMatch_FkContactor_IdContactor(fkContactor).isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(matchRepositoy.findByIdMatch_FkContactor_IdContactor(fkContactor));
    }
}
