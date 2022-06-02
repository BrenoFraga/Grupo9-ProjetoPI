package findr.projectfindr.controller;

import findr.projectfindr.datastructure.FilaObj;
import findr.projectfindr.datastructure.ListaObj;
import findr.projectfindr.datastructure.Match;
import findr.projectfindr.datastructure.PilhaObj;
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



    @GetMapping("/freelancer")
    @Operation(summary = "Registros de 'likes' de freelancers",description =
            "Irá consultar os likes recebidos pelos freelancers no banco de dados",
            tags = {"API match"})
    public ResponseEntity getlikeFreelancer(){
        List<LikeProject> lista = likeProjectRepository.findAll();
        if (likeFreelancerRepository.findAll().isEmpty()){
            return ResponseEntity.status(204).body(likeFreelancerRepository.findAll());
        }
        return ResponseEntity.status(200).body(likeFreelancerRepository.findAll());
    }

    @GetMapping("/project")
    @Operation(summary = "Registros de 'likes' de projetos",description =
            "Irá consultar os likes recebidos pelos projetos no banco de dados",
            tags = {"API match"})
    public ResponseEntity getlikeProject(){
        List<LikeFreelancer> lista = likeFreelancerRepository.findAll();
        if (likeProjectRepository.findAll().isEmpty()){
            return ResponseEntity.status(204).body(likeProjectRepository.findAll());
        }
        return ResponseEntity.status(200).body(likeProjectRepository.findAll());
    }



    //fazer o postMapping certo aqui
    @PostMapping("/freelancer/{fkFreelancer}/{fkContactor}/{like}")
    @Operation(summary = "Registros de 'likes' de freelancers",description =
            "Irá inserir os likes recebidos pelos freelancers no banco de dados",
            tags = {"API match"})
    public ResponseEntity cadastrarLikeFreelancer(@PathVariable long fkFreelancer,
                                                  @PathVariable long fkContactor,
                                                  @PathVariable Boolean like){
        try {
        Contactor c = contactorRepository.findByIdContactor(fkContactor);
        UserFreelancer f = freelancerRepository.findByIdUserFreelancer(fkFreelancer);
        pkLikeFreelancer pkf = new pkLikeFreelancer(f,c);
        Date dataLike = new Date();
            LikeFreelancer lk = new LikeFreelancer(dataLike,like,pkf);
            likeFreelancerRepository.save(lk);
        }catch (Exception e){
            return ResponseEntity.status(406).build();
        }
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/project/{fkFreelancer}/{fkContactor}/{fkProject}/{like}")
    @Operation(summary = "Registros de 'likes' de projetos",description =
            "Irá inserir os likes recebidos pelos projetos no banco de dados",
            tags = {"API match"})
    public ResponseEntity cadastrarLikeProject(@PathVariable long fkFreelancer,
                                               @PathVariable long fkContactor,
                                               @PathVariable long fkProject,
                                               @PathVariable Boolean like){
        try {
            Contactor c = contactorRepository.findByIdContactor(fkContactor);
            UserFreelancer f = freelancerRepository.findByIdUserFreelancer(fkFreelancer);
            ProjectModel p = projectRepository.findByIdProjectContactor(fkProject);
            Date dataLike = new Date();
            pkLikeProject pkf = new pkLikeProject(f,c,p);
            LikeProject lp = new LikeProject(dataLike,like,pkf);
            likeProjectRepository.save(lp);
        }catch (Exception e){
            return ResponseEntity.status(406).build();
        }
        return ResponseEntity.status(201).build();
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

    int tamanho = 0;
    PilhaObj<Match> matchs = new PilhaObj<>(tamanho);;
    FilaObj<Match> matchFilaObj = new FilaObj<>(tamanho);
    List<Match> exibicao = new ArrayList<>();

    @GetMapping("/match/{fkFreelancer}/{fkContactor}")
    @Operation(summary = "Consulta se houve match de um usuário",description =
            "Irá buscar checar se há registros iguais no banco para caracterizar o match",
            tags = {"API match"})
    public ResponseEntity getMatchFreelancer(@PathVariable long fkFreelancer,@PathVariable long fkContactor){
        tamanho ++;
        LikeProject projetoSelecionado = likeProjectRepository.findByIdLikeProject_FkContactor_IdContactorAndIdLikeProject_FkFreelancer_IdUserFreelancer(fkContactor,fkFreelancer);
        LikeFreelancer freelancerSelecionado = likeFreelancerRepository.findByIdLikeFreelancer_FkFreelancer_IdUserFreelancerAndIdLikeFreelancer_FkContactor_IdContactor(fkFreelancer,fkContactor);
        if(projetoSelecionado != null && freelancerSelecionado != null) {
            if (projetoSelecionado.getIdLikeProject().getFkContactor() ==
                            freelancerSelecionado.getIdLikeFreelancer().getFkContactor() &&
                            projetoSelecionado.getIdLikeProject().getFkFreelancer() ==
                            freelancerSelecionado.getIdLikeFreelancer().getFkFreelancer()) {
                Match m = new Match(fkFreelancer, fkContactor);
                if (projetoSelecionado.getEvaluation() == true && freelancerSelecionado.getEvaluation() == true) {
                    matchs.push(m);
                    matchFilaObj.insert(m);
                    exibicao.add(m);
                    return ResponseEntity.status(200).body(exibicao);
                }
            }
        }
        return ResponseEntity.status(204).build();
    }

}
