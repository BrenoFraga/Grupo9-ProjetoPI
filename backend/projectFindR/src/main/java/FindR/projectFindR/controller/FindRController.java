package FindR.projectFindR.controller;

import FindR.projectFindR.model.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/FindR")
public class FindRController {
    List<FreelancerModel> users = new ArrayList<>();
    List<RepresentanteModel> managers = new ArrayList<>();
    List<ContratanteModel> companys = new ArrayList<>();
    List<TaskModel> tasks = new ArrayList<>();

    //GET  USERS, MANAGERS AND TASKS
    @GetMapping("/tasks")
    public List<TaskModel> viewTasks() {
        return tasks;
    }

    @GetMapping("/users")
    public List<FreelancerModel> viewUsers() {
        return users;
    }

    @GetMapping("/managers")
    public List<RepresentanteModel> viewManagers() {
        return managers;
    }

    //LOGIN USER,MANAGER
    @GetMapping("user/{email}/{senha}/login")
    public String userLogin(@PathVariable String email,
                            @PathVariable String senha) {
        for (FreelancerModel comumUser : users
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
    public String managerLogin(@PathVariable String email,
                               @PathVariable String senha) {
        for (RepresentanteModel manager : managers
        ) {
            if (manager.getEmailUser().equals(email) &&
                    manager.getSenhaUser().equals(senha)) {
                manager.setStatusOnline(true);
                return "Login realizado com sucesso";
            }
        }
        return "Senha ou email incorreto";
    }

    //LOGOFF USER,MANAGER
    @GetMapping("user/{email}/{senha}/logoff")
    public String userLogoff(@PathVariable String email,
                             @PathVariable String senha) {
        for (FreelancerModel comumUser : users
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
    public String managerLogoff(@PathVariable String email,
                                @PathVariable String senha) {
        for (RepresentanteModel manager : managers
        ) {
            if (manager.getEmailUser().equals(email) &&
                    manager.getSenhaUser().equals(senha)) {
                manager.setStatusUser();
                return "Logoff realizado com sucesso";
            }
        }
        return "Senha e email incorreto";
    }

    //REGISTER COMPANY, USERS, MANAGERS AND TASKS
    @PostMapping("/user")
    public String addUserFindR(@RequestBody FreelancerModel comumUser) {
        users.add(comumUser);
        comumUser.setTypeUser();
        comumUser.setStatusUser();
        return "Usuario cadastrado com sucesso";
    }

    @PostMapping("/company")
    public String addCompany(@RequestBody ContratanteModel company) {
        companys.add(company);
        return "Empresa cadastrada com sucesso";
    }

    @PostMapping("/company/{indiceCompany}/manager")
    public String addUserManager(@RequestBody RepresentanteModel managerUser,
                                 @PathVariable int indiceCompany) {
        companys.get(indiceCompany).getUsersManeger().add(managerUser);
        managers.add(managerUser);
        managerUser.setTypeUser();
        managerUser.setStatusUser();

        return "Usuário administrador cadastrado com sucesso!";
    }

    @PostMapping("/company/{indiceCompany}/manager/{indiceManager}")
    public String addManagerToCompany(@PathVariable int indiceCompany,
                                      @PathVariable int indiceManager) {
        for (RepresentanteModel manager: managers
             ) {
            if (managers.equals(manager)){
                for (ContratanteModel company: companys
                     ) {
                    if (companys.equals(company)){
                        company.getUsersManeger().add(manager);
                        return "Representante cadastrado na empresa "+ company.getNome() + "!";
                    }else {
                        return "Empresa não encontrada";
                    }
                }
            }else{
                return "Usuário não encontrado";
            }

        }
        return "M";
    }


    @PostMapping("/company/{indiceCompany}/manager/{email}/{senha}/task/")
    public String addTask(@RequestBody TaskModel task,
                          @PathVariable int indiceCompany,
                          @PathVariable String email,
                          @PathVariable String senha) {
        for (RepresentanteModel manager: managers
             ) {
            if (manager.getEmailUser().equals(email) && manager.getSenhaUser().equals(senha) ){
                tasks.add(task);
                companys.get(indiceCompany).getProjects().add(task);

            }else {
               return "Email ou senha incorreto";
            }
        }
        return "Projeto postado com sucesso";
    }

    //ADD USER TO TASK
    @PostMapping("/task/{indiceTask}/dev/{indiceUser}")
    public String addUserTask(@PathVariable int indiceTask,
                              @PathVariable int indiceUser) {
        for (PessoaModel devs : users
        ) {
            if (users.get(indiceUser) == null) {
                return "Usuário inexistente";
            } else {
                tasks.get(indiceTask).getDevs().add((FreelancerModel) users.get(indiceUser));
            }
        }
        return "Desenvolvedor adicionado com sucesso!";
    }

}
