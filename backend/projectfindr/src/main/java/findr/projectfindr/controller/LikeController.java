package findr.projectfindr.controller;

import findr.projectfindr.repository.LikeFreelancerRepository;
import findr.projectfindr.repository.LikeProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/like")
public class LikeController {

    @Autowired
    private LikeFreelancerRepository likeFreelancerRepository;

    @Autowired
    private LikeProjectRepository likeProjectRepository;

    //get like freelancer
    //post like freelancer
    //get like project
    //post like contactor
    @GetMapping("/freelancer")
    public ResponseEntity getlikeFreelancer(){
        if (likeFreelancerRepository.findAll().isEmpty()){
            return ResponseEntity.status(204).body(likeFreelancerRepository.findAll());
        }
        return ResponseEntity.status(200).body(likeFreelancerRepository.findAll());
    }

    @GetMapping("/project")
    public ResponseEntity getlikeProject(){
        if (likeProjectRepository.findAll().isEmpty()){
            return ResponseEntity.status(204).body(likeProjectRepository.findAll());
        }
        return ResponseEntity.status(200).body(likeProjectRepository.findAll());
    }

}
