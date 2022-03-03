package FindR.projectFindR.controller;

import FindR.projectFindR.model.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/FindR")
public class FindRController {
    List<ComumUserModel> users = new ArrayList<>();
    List<ManegerUserModel> managers = new ArrayList<>();
    List<TaskModel> tasks = new ArrayList<>();

    //GET  USERS, MANAGERS AND TASKS
    @GetMapping("/tasks")
    public List<TaskModel> viewTasks() {
        return tasks;
    }

    @GetMapping("/user")
    public List<ComumUserModel> viewUsers() {
        return users;
    }

    @GetMapping("/manager")
    public List<ManegerUserModel> viewManagers() {
        return managers;
    }

    //LOGIN AND LOGOFF
    @GetMapping("user/{email}/{senha}/login")
    public String userLogin(@PathVariable String email, @PathVariable String senha) {
        for (ComumUserModel comumUser : users
        ) {
            if (comumUser.getEmailUser().equals(email) &&
                    comumUser.getSenhaUser().equals(senha)) {
                comumUser.setStatusOnline(true);
                return "Login realizado com sucesso";
            }
        }
        return "Senha ou email incorreto";
    }

    @GetMapping("manager/{email}/{senha}/login")
    public String managerLogin(@PathVariable String email, @PathVariable String senha) {
        for (ManegerUserModel manager : managers
        ) {
            if (manager.getEmailUser().equals(email) &&
                    manager.getSenhaUser().equals(senha)) {
                manager.setStatusOnline(true);
                return "Login realizado com sucesso";
            }
        }
        return "Senha ou email incorreto";
    }

    @GetMapping("user/{email}/{senha}/logoff")
    public String userLogoff(@PathVariable String email, @PathVariable String senha) {
        for (ComumUserModel comumUser : users
        ) {
            if (comumUser.getEmailUser().equals(email) &&
                    comumUser.getSenhaUser().equals(senha)) {
                comumUser.setStatusUser();
                return "Logoff realizado com sucesso";
            }
        }
        return "Senha e email incorreto";
    }

    @GetMapping("manager/{email}/{senha}/logoff")
    public String managerLogoff(@PathVariable String email, @PathVariable String senha) {
        for (ManegerUserModel manager : managers
        ) {
            if (manager.getEmailUser().equals(email) &&
                    manager.getSenhaUser().equals(senha)) {
                manager.setStatusUser();
                return "Logoff realizado com sucesso";
            }
        }
        return "Senha e email incorreto";
    }

    //REGISTER USERS, MANAGERS AND TASKS
    @PostMapping("/user")
    public String addUserFindR(@RequestBody ComumUserModel comumUser) {
        users.add(comumUser);
        comumUser.setTypeUser();
        comumUser.setStatusUser();
        return "Usuario cadastrado com sucesso";
    }

    @PostMapping("/manager")
    public String addUserManager(@RequestBody ManegerUserModel managerUser) {
        managers.add(managerUser);
        managerUser.setTypeUser();
        managerUser.setStatusUser();
        return "Usuário administrador cadastrado com sucesso!";
    }

    @PostMapping("/manager/{email}/{senha}/task/")
    public String addTask(@RequestBody TaskModel task,
                          @PathVariable String email,
                          @PathVariable String senha) {
        for (ManegerUserModel manager: managers
             ) {
            if (manager.getEmailUser().equals(email) && manager.getSenhaUser().equals(senha) ){
                tasks.add(task);
            }else {
               return "Email ou senha incorreto";
            }
        }
        return "Projeto postado com sucesso";
    }

    //ADD USER TO TASK
    @PostMapping("/task/{indiceTask}/dev/{indiceUser}")
    public String addUserTask(@PathVariable int indiceTask, @PathVariable int indiceUser) {
        for (PersonModel devs : users
        ) {
            if (users.get(indiceUser) == null) {
                return "Usuário inexistente";
            } else {
                tasks.get(indiceTask).getDevs().add((ComumUserModel) users.get(indiceUser));
            }
        }
        return "Desenvolvedor adicionado com sucesso!";
    }

}
