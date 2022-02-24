package FindR.projectFindR.controller;

import FindR.projectFindR.model.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/FindR")
public class FindRController {
    List<PersonModel> users = new ArrayList<>();
    List<DevsModel> equipes = new ArrayList<>();
    List<TaskModel> tasks = new ArrayList<>();

    @GetMapping("/tasks")
    public List<TaskModel> viewTasks() {
        return tasks;
    }

    @GetMapping("/groups")
    public List<DevsModel> viewGroups() {
        return equipes;
    }

    @GetMapping("/user")
    public List<PersonModel> viewUsers() {
        return users;
    }

    @GetMapping("/devs/group/{indiceGroup}/payment")
    public void getpaymentGroup(@PathVariable int indiceGroup){
        int contador = 0;
        for (DevsModel group: equipes
             ) {
            if (equipes.get(indiceGroup) == null){
                System.out.println("Equipe inexistente");
            }
        }
    }

    @PostMapping("/user")
    public String addUserFindR(@RequestBody ComumUserModel comumUser) {
        users.add(comumUser);
        return "Usuario cadastrado com sucesso";
    }

    @PostMapping("/manager")
    public void addUserManager(ManegerUserModel person) {
        users.add(person);
    }

    @PostMapping("manager/{indiceManager}/task/")
    public String addTask(@RequestBody TaskModel task, @PathVariable int indiceManager) {
        if (users.get(indiceManager) instanceof ManegerUserModel) {
            tasks.add(task);
        }else if (users.get(indiceManager) == null){
            System.out.println("Usuário não encontrado");
        }else{
            System.out.println("O usuário não é um Administrador");
        }
        return "Projeto postado com sucesso";
    }

    @PostMapping("/dev/group/{name}")
    public String addGroupDev(@PathVariable String name) {
        DevsModel devsModel = new DevsModel(name);
        devsModel.setNameGroup(name);
        equipes.add(devsModel);

        return devsModel + "Equipe cadastrada com sucesso";
    }

    @PostMapping("/user/dev/group/{indiceGroup}/{indiceDev}")
    public String addUserToGroupDev(@PathVariable int indiceGroup, @PathVariable int indiceDev) {
        for (DevsModel devs : equipes
        ) {
            if (equipes.get(indiceGroup) == null) {
                return "Equipe inexistente";
            } else {
                equipes.get(indiceGroup).getDevs().add(0, (ComumUserModel) users.get(indiceDev));
            }
        }

        return "Desenvolvedor cadastrado com sucesso cadastrada com sucesso";
    }

    @PostMapping("/task/dev/group/{indiceGroup}/task/{indiceTask}")
    public String addTaskGroup(@PathVariable int indiceGroup, @PathVariable int indiceTask) {
        for (DevsModel devs : equipes
        ) {
            if (equipes.get(indiceGroup) == null) {
                return "Equipe inexistente";
            } else {
                equipes.get(indiceGroup).getProjectsDoing().add(0, tasks.get(indiceTask));
            }
        }
        return "Tarefa adicionada com sucesso!";
    }

}
