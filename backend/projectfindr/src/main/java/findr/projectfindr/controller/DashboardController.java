package findr.projectfindr.controller;


import findr.projectfindr.model.ProjectModel;
import findr.projectfindr.model.SpecialtyModel;
import findr.projectfindr.repository.*;
import findr.projectfindr.request.LanguagesProjectRequest;
import findr.projectfindr.request.RequiredAreaRequest;
import findr.projectfindr.request.TechnologyUsedRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ContactorRepository contactorRepository;

    @Autowired
    private LikeFreelancerRepository likeFreelancerRepository;

    @Autowired
    private LikeProjectRepository likeProjectRepository;

    @Autowired
    private FreelancerRepository freelancerRepository;

    @Autowired
    private MatchRepositoy matchRepository;

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @Autowired
   private ModelMapper mapper;

    //matchcontactor
    @GetMapping("/count-match")
    public ResponseEntity matchcontactor() {
        if (matchRepository.findAll().isEmpty()) {
            return ResponseEntity.status(201).body(0);
        } else {
            return ResponseEntity.status(200).body(matchRepository.count());
        }
    }

    //totalContratantes
    @GetMapping("/count-contactor")
    public ResponseEntity totalContratantes() {
        if (contactorRepository.findAll().isEmpty()) {
            return ResponseEntity.status(201).body(0);
        } else {
            return ResponseEntity.status(200).body(contactorRepository.count());
        }
    }

    //totalFreelancer
    @GetMapping("/count-freelancer")
    public ResponseEntity totalFreelancer() {
        if (freelancerRepository.findAll().isEmpty()) {
            return ResponseEntity.status(201).body(0);
        } else {
            return ResponseEntity.status(200).body(freelancerRepository.count());
        }
    }

    //totalProjetos
    @GetMapping("/count-projects")
    public ResponseEntity totalProjetos() {
        if (projectRepository.findAll().isEmpty()) {
            return ResponseEntity.status(201).body(0);
        } else {
            return ResponseEntity.status(200).body(projectRepository.count());
        }
    }

    //totalLikeFreelancer
    @GetMapping("/count-likes-freelancer")
    public ResponseEntity totalLikesFreelancer() {
        if (likeFreelancerRepository.findAll().isEmpty()) {
            return ResponseEntity.status(201).body(0);
        } else {
            return ResponseEntity.status(200).body(likeFreelancerRepository.count());
        }
    }

    //totalLikeContactor
    @GetMapping("/count-likes-contactor")
    public ResponseEntity totalLikesContactor() {
        if (likeProjectRepository.findAll().isEmpty()) {
            return ResponseEntity.status(201).body(0);
        } else {
            return ResponseEntity.status(200).body(likeProjectRepository.count());
        }
    }

    //allRequiredLanguages
    @GetMapping("/languages")
    public ResponseEntity<List<LanguagesProjectRequest>> languages() {
        List<ProjectModel> list = projectRepository.findAll();
        if (projectRepository.findAll().isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            List<LanguagesProjectRequest> requests = new ArrayList<>();
            for (ProjectModel projectModel : list) {
                requests.add(mapper.map(projectModel, LanguagesProjectRequest.class));
            }
            return ResponseEntity.status(200).body(requests);
        }
    }

    //alltechnologyUsed
    @RequestMapping(value = {"/technology"}, method = RequestMethod.GET)
    public ResponseEntity technologys() {
        List<SpecialtyModel> list = specialtyRepository.findAll();
        if (specialtyRepository.findAll().isEmpty()) {
            return ResponseEntity.status(204).body(0);
        } else {
            List<TechnologyUsedRequest> requests = new ArrayList<>();
            for (SpecialtyModel specialtyModel : list) {
                requests.add(mapper.map(specialtyModel, TechnologyUsedRequest.class));
            }
            return ResponseEntity.status(200).body(requests);
        }
    }

    //allRequiredArea
    @GetMapping("/requiredAreas")
    public ResponseEntity requiredAreas() {
        List<ProjectModel> list = projectRepository.findAll();
        if (projectRepository.findAll().isEmpty()) {
            return ResponseEntity.status(204).body(0);
        } else {
            List<RequiredAreaRequest> requests = new ArrayList<>();
            for (ProjectModel projectModel : list) {
                requests.add(mapper.map(projectModel, RequiredAreaRequest.class));
            }
            return ResponseEntity.status(200).body(requests);
        }
    }
}