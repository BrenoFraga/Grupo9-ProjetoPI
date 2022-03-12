package FindR.projectFindR.controller;

import FindR.projectFindR.model.*;

import java.util.ArrayList;
import java.util.List;

public class BancoController {
    List<FreelancerModel> users = new ArrayList<>();
    List<RepresentanteModel> managers = new ArrayList<>();
    List<ContratanteModel> companys = new ArrayList<>();
    List<ProjectModel> tasks = new ArrayList<>();

    // INSERTS
    public String addUserFindR(FreelancerModel comumUser) {
        users.add(comumUser);
        comumUser.setTypeUser();
        comumUser.setStatusUser();
        return "Usuario cadastrado com sucesso";
    }

    public String addCompany(ContratanteModel company) {
        companys.add(company);
        return "Empresa cadastrada com sucesso";
    }

    public String addUserManager(RepresentanteModel managerUser,
                                 int indiceCompany) {
        companys.get(indiceCompany).getUsersManeger().add(managerUser);
        managers.add(managerUser);
        managerUser.setTypeUser();
        managerUser.setStatusUser();

        return "Usuário administrador cadastrado com sucesso!";
    }

    public String addManagerToCompany( int indiceCompany,
                                       int indiceManager) {
        for (RepresentanteModel manager : managers
        ) {
            if (managers.equals(manager)) {
                for (ContratanteModel company : companys
                ) {
                    if (companys.equals(company)) {
                        company.getUsersManeger().add(manager);
                    } else {
                        return "Empresa não encontrada";
                    }
                }
            } else {
                return "Usuário não encontrado";
            }

        }
        return "Representante cadastrado na empresa !";
    }

    public String addTask(ProjectModel task, int indiceCompany, String email, String senha) {
        for (RepresentanteModel manager : managers
        ) {
            if (manager.getEmail().equals(email) && manager.getPassword().equals(senha)) {
                tasks.add(task);
                companys.get(indiceCompany).getProjects().add(task);

            } else {
                return "Email ou senha incorreto";
            }
        }
        return "Projeto postado com sucesso";
    }

    public String addUserTask(int indiceTask, int indiceUser) {
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

    //DELETS

    public String removeUser(String email, String senha) {
        String frase = "";
        for (PessoaModel pessoa : users) {
            if (pessoa.getEmail().equals(email) && pessoa.getPassword().equals(senha)) {
                users.remove(pessoa);
                frase = String.format("Usuario removido com sucesso");
            } else {
                frase = "Usuario não encontrado";
            }
        }
        return frase;
    }

    public String removerManeger(String email, String senha) {
        String frase = "";
        for (PessoaModel pessoa : managers) {
            if (pessoa.getEmail().equals(email) && pessoa.getPassword().equals(senha)) {
                managers.remove(pessoa);
                frase = String.format("Usuario removido com sucesso");
            } else {
                frase = "Usuario não encontrado";
            }
        }
        return frase;
    }

    public String removerContratante(String email,
                                     String senha) {
        String frase = "";
        for (ContratanteModel contratante : companys) {
            if (contratante.getEmail().equals(email) && contratante.getPassword().equals(senha)) {
                managers.remove(contratante);
                frase = String.format("Usuario removido com sucesso");
            } else {
                frase = "Usuario não encontrado";
            }
        }
        return frase;
    }

    public String deleteTask(String email,
                             String senha,
                             int indiceTask) {
        String frase = "";
        for (RepresentanteModel manager : managers) {
            if (manager.getEmail().equals(manager) && manager.getPassword().equals(manager)) {
                if (indiceTask <= tasks.size() - 1) {
                    String tasknome = tasks.get(indiceTask).getName_project();
                    tasks.remove(indiceTask);
                    frase = String.format("Removendo a task %s", tasknome);
                } else {
                    frase = "Task não encontrada";
                }
            } else {
                frase = "Usuário não encontrado";
            }
        }
        return frase;
    }
}
