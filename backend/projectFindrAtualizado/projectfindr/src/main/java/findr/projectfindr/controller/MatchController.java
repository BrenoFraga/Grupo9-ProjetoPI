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
        if(matchRepositoy.findByFkFreelancer(fkFreelancer).isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(matchRepositoy.findByFkFreelancer(fkFreelancer));
    }

    @GetMapping("/contactor/{fkContactor}")
    public ResponseEntity getMatchContactor(@PathVariable long fkContactor){
        if(matchRepositoy.findByFkContactor(fkContactor).isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(matchRepositoy.findByFkContactor(fkContactor));
    }
}
