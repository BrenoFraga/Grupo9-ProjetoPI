package findr.projectfindr.controller;

import findr.projectfindr.datastructure.FilaObj;
import findr.projectfindr.datastructure.PilhaObj;
import findr.projectfindr.matchControl.MatchGetControlFreelancer;
import findr.projectfindr.matchControl.MatchGetControlProject;
import findr.projectfindr.model.*;
import findr.projectfindr.repository.*;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/like")
public class LikeController {

    @Autowired
    private LikeFreelancerRepository likeFreelancerRepository;

    @Autowired
    private LikeProjectRepository likeProjectRepository;

    @Autowired
    private ContactorRepository contactorRepository;

    @Autowired
    private FreelancerRepository freelancerRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private MatchRepositoy matchRepositoy;



    @GetMapping("/freelancer")
    @Operation(summary = "Registros de 'likes' de freelancers",description =
            "Irá consultar os likes recebidos pelos freelancers no banco de dados",
            tags = {"API match"})
    public ResponseEntity getlikeFreelancer(){
        List<LikeProject> lista = likeProjectRepository.findAll();
        if (lista.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(lista);
    }

    @GetMapping("/project")
    @Operation(summary = "Registros de 'likes' de projetos",description =
            "Irá consultar os likes recebidos pelos projetos no banco de dados",
            tags = {"API match"})
    public ResponseEntity getlikeProject(){
        List<LikeFreelancer> lista = likeFreelancerRepository.findAll();
        if (lista.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(lista);
    }



    //fazer o postMapping certo aqui
    @PostMapping("/freelancer/{fkFreelancer}/{fkContactor}/{like}")
    @Operation(summary = "Registros de 'likes' de freelancers",description =
            "Irá inserir os likes recebidos pelos freelancers no banco de dados",
            tags = {"API match"})
    public ResponseEntity cadastrarLikeFreelancer(@PathVariable long fkFreelancer,
                                                  @PathVariable long fkContactor,
                                                  @PathVariable Boolean like){
        Contactor c = contactorRepository.findByIdContactor(fkContactor);
        UserFreelancer f = freelancerRepository.findByIdUserFreelancer(fkFreelancer);
        pkLikeFreelancer pkf = new pkLikeFreelancer(f,c);
        Date dataLike = new Date();
        LikeFreelancer lk = new LikeFreelancer(dataLike,like,pkf);
        List<LikeFreelancer> listLp = likeFreelancerRepository.findAll();
        Boolean temLike = false;
        try {
            if(!listLp.isEmpty()) {
                for (int i = 0; i < listLp.size(); i++) {
                    if (lk == listLp.get(i)) {
                        temLike = true;
                        break;
                    } else {
                        temLike = false;
                    }
                }
                if (!temLike) {
                    likeFreelancerRepository.save(lk);
                }
            }else{
                likeFreelancerRepository.save(lk);
            }

        }catch (Exception e){
            return ResponseEntity.status(406).build();
        }
        MatchGetControlFreelancer m = new MatchGetControlFreelancer(likeProjectRepository.findAll(),lk);
        if(m.getMatch() == null) {
            return ResponseEntity.status(201).body(0);
        }else{
            matchRepositoy.save(m.getMatch());
            return ResponseEntity.status(201).body("Temos um match");
        }
    }

    @PostMapping("/project/{fkFreelancer}/{fkContactor}/{fkProject}/{like}")
    @Operation(summary = "Registros de 'likes' de projetos",description =
            "Irá inserir os likes recebidos pelos projetos no banco de dados",
            tags = {"API match"})
    public ResponseEntity cadastrarLikeProject(@PathVariable long fkFreelancer,
                                               @PathVariable long fkContactor,
                                               @PathVariable long fkProject,
                                               @PathVariable Boolean like){
        Contactor c = contactorRepository.findByIdContactor(fkContactor);
        UserFreelancer f = freelancerRepository.findByIdUserFreelancer(fkFreelancer);
        ProjectModel p = projectRepository.findByIdProjectContactor(fkProject);
        Date dataLike = new Date();
        pkLikeProject pkf = new pkLikeProject(f,c,p);
        LikeProject lp = new LikeProject(dataLike,like,pkf);
        List<LikeProject> listLp = likeProjectRepository.findAll();
        try {
            Boolean temLike = false;
            for(int i = 0; i < listLp.size();i++){
                if(lp == listLp.get(i)){
                    temLike = true;
                    break;
                }else{
                    temLike = false;
                }
            }
            if(!temLike){
                likeProjectRepository.save(lp);
            }
        }catch (Exception e){
            return ResponseEntity.status(406).build();
        }
        MatchGetControlProject m = new MatchGetControlProject(likeFreelancerRepository.findAll(),lp);
        if(m.getMatch() == null) {
            return ResponseEntity.status(201).body(0);
        }else{
            matchRepositoy.save(m.getMatch());
            return ResponseEntity.status(201).body("Temos um match");
        }
    }


    @GetMapping("/get/project/{fkContactor}")
    @Operation(summary = "Consulta de 'likes' de um projeto de um contratante",description =
            "Irá buscar o like de projetos de um contratante especifico no banco de dados",
            tags = {"API match"})
    public ResponseEntity getLikeProject(@PathVariable long fkContactor){
        List<LikeProject> lista = likeProjectRepository.findByIdLikeProject_FkContactor_IdContactor(fkContactor);
        return ResponseEntity.status(200).body(lista);
    }


    @GetMapping("/get/freelancer/{fkFreelancer}")
    @Operation(summary = "Consulta de 'likes' de um freelancer",description =
            "Irá buscar o like de um freelancer especifico no banco de dados",
            tags = {"API match"})
    public ResponseEntity getLikeFreelancer(@PathVariable long fkFreelancer){
        List<LikeFreelancer> lista = likeFreelancerRepository.findByIdLikeFreelancer_FkFreelancer_IdUserFreelancer(fkFreelancer);
        return ResponseEntity.status(200).body(lista);
    }
}
