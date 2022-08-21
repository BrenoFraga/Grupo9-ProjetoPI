package findr.projectfindr.controller;

import findr.projectfindr.repository.ContactorRepository;
import findr.projectfindr.repository.FreelancerRepository;
import findr.projectfindr.repository.MatchRepositoy;
import findr.projectfindr.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/match")
public class MatchController {
    @Autowired
    private ContactorRepository contactorRepository;

    @Autowired
    private FreelancerRepository freelancerRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private MatchRepositoy matchRepositoy;

    @GetMapping("/freelancer")
    public ResponseEntity getMatchFreelancer(){
        return null;
    }

    @GetMapping("/contactor")
    public ResponseEntity getMatchContactor(){
        return null;
    }
}
