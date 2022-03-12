package FindR.projectFindR.controller;

import FindR.projectFindR.model.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/FindR")
public class FindRController {
    BancoController bd = new BancoController();
    //GET  USERS, MANAGERS AND TASKS

    @GetMapping("/users")
    public List<FreelancerModel> viewUsers() {
        return bd.users;
    }

    @GetMapping("/managers")
    public List<RepresentanteModel> viewManagers() {
        return bd.managers;
    }

    //LOGIN USER,MANAGER
    @GetMapping("user/{email}/{senha}/login")
    public String userLogin(@PathVariable String email,
                            @PathVariable String senha) {
        for (FreelancerModel comumUser : bd.users
        ) {
            if (comumUser.getEmail().equals(email) &&
                    comumUser.getPassword().equals(senha)) {
                comumUser.setStatusOnline(true);
                return "Login realizado com sucesso";
            }
        }
        return "Senha ou email incorreto";
    }

    @GetMapping("manager/{email}/{senha}/login")
    public String managerLogin(@PathVariable String email,
                               @PathVariable String senha) {
        for (RepresentanteModel manager : bd.managers
        ) {
            if (manager.getEmail().equals(email) &&
                    manager.getPassword().equals(senha)) {
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
        for (FreelancerModel comumUser : bd.users
        ) {
            if (comumUser.getEmail().equals(email) &&
                    comumUser.getPassword().equals(senha)) {
                comumUser.setStatusUser();
                return "Logoff realizado com sucesso";
            }
        }
        return "Senha e email incorreto";
    }

    @GetMapping("manager/{email}/{senha}/logoff")
    public String managerLogoff(@PathVariable String email,
                                @PathVariable String senha) {
        for (RepresentanteModel manager : bd.managers
        ) {
            if (manager.getEmail().equals(email) &&
                    manager.getPassword().equals(senha)) {
                manager.setStatusUser();
                return "Logoff realizado com sucesso";
            }
        }
        return "Senha e email incorreto";
    }

    //REGISTER COMPANY, USERS, MANAGERS, TASKS AND ADD USER TO TASK
    @PostMapping("/user")
    public String addUserFindR(@RequestBody FreelancerModel comumUser) {
        bd.addUserFindR(comumUser);
        return "Usuario cadastrado com sucesso";
    }

    @PostMapping("/company")
    public String addCompany(@RequestBody ContratanteModel company) {
        bd.addCompany(company);
        return "Empresa cadastrada com sucesso";
    }

    @PostMapping("/company/{indiceCompany}/manager")
    public String addUserManager(@RequestBody RepresentanteModel managerUser,
                                 @PathVariable int indiceCompany) {
       bd.addUserManager(managerUser,indiceCompany);
        return "Usuário administrador cadastrado com sucesso!";
    }

    @PostMapping("/company/{indiceCompany}/manager/{indiceManager}")
    public String addManagerToCompany(@PathVariable int indiceCompany,
                                      @PathVariable int indiceManager) {
      return bd.addManagerToCompany(indiceCompany,indiceManager);
    }

    @PostMapping("/company/{indiceCompany}/manager/{email}/{senha}/task/")
    public String addTask(@RequestBody ProjectModel task,
                          @PathVariable int indiceCompany,
                          @PathVariable String email,
                          @PathVariable String senha) {
        return bd.addTask(task,indiceCompany,email,senha);
    }

    @PostMapping("/task/{indiceTask}/dev/{indiceUser}")
    public String addUserTask(@PathVariable int indiceTask,
                              @PathVariable int indiceUser) {

        return bd.addUserTask(indiceTask, indiceUser);
    }

    //DELETE USER
    @DeleteMapping("/user/{email}/{senha}")
    public String removeUser(@PathVariable String email,
                             @PathVariable String senha) {
        return bd.removeUser(email, senha);
    }

    //DELETE REPRESENTANTE
    @DeleteMapping("/maneger/{email}/{senha}")
    public String removerManeger(@PathVariable String email,
                                 @PathVariable String senha) {
        return bd.removerManeger(email, senha);
    }

    //DELETE CONTRATANTE
    @DeleteMapping("/company/{email}/{senha}")
    public String removerContratante(@PathVariable String email,
                                     @PathVariable String senha) {
        return bd.removerContratante(email, senha);
    }

    //DELETE TASK
    @DeleteMapping("/manager/{email}/{senha}/task/{indiceTask}")
    public String deleteTask(@PathVariable String email,
                             @PathVariable String senha,
                             @PathVariable int indiceTask) {
        return bd.deleteTask(email, senha, indiceTask);
    }
}
