package com.projectfindr.controller;

import com.projectfindr.model.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BancoService {
    List<UserFreelancer> freelancers = new ArrayList<>();
    List<UserContactorCompany> contactorCompanies = new ArrayList<>();
    List<UserContactorPerson> contactorPersons = new ArrayList<>();
    List<Project> projects = new ArrayList<>();
    List<Specialty> specialties = new ArrayList<>();

    //Adicionando um usuário Freelancer
    public String addUserFreelancer(UserFreelancer userFreelancer){
        freelancers.add(userFreelancer);
        userFreelancer.setStatusUser();
        return "Usuário cadastrado com sucesso!";
    }

    //Adicionando um usuário Company
    public String addUserContactorCompany(UserContactorCompany userContactorCompany){
        contactorCompanies.add(userContactorCompany);
        userContactorCompany.setStatusUser();
        return "Empresa cadastrada com sucesso!";
    }

    //Adicionando um usuário Person
    public String addUserContactorPerson(UserContactorPerson userContactorPerson){
        contactorPersons.add(userContactorPerson);
        userContactorPerson.setStatusUser();
        return "Contratante cadastrado com sucesso!";
    }

    //Empresa adicionando um projeto
    public String addProjectCompany(Project project, String email, String password){
        Boolean companyExists = false;
        for (int i = 0; i < contactorCompanies.size(); i++) {
            if(contactorCompanies.get(i).getEmail().equals(email) && contactorCompanies.get(i).getPassword().equals(password)){
                projects.add(project);
                projects.get(i).setStatusProject(true);
                companyExists = true;
                contactorCompanies.get(i).getProjectCompany().add(project);
            }
        }

        if(companyExists){
            return "Projeto postado com sucesso!";

        }else{
            return "Erro ao postar o projeto. Email ou senha incorreto, tente novamente.";

        }
    }

    //ContactorPerson Adicionando Projeto
    public String addProjectContactorPerson(Project project, String email, String password){
        Boolean personExists = false;
        for (int i = 0; i < contactorPersons.size(); i++) {
            if(contactorPersons.get(i).getEmail().equals(email) && contactorPersons.get(i).getPassword().equals(password)){
                projects.add(project);
                projects.get(i).setStatusProject(true);
                personExists = true;
                contactorPersons.get(i).getProjectContactorPeople().add(project);
            }
        }

        if(personExists){
            return "Projeto postado com sucesso!";

        }else{
            return "Erro ao postar o projeto. Email ou senha incorreto, tente novamente.";

        }
    }

    //Adicionando Specialty
    public String addSpecialty(Specialty specialty, String email, String password){
        Boolean freelancerExists = false;
        for (int i = 0; i < freelancers.size(); i++) {
            if(freelancers.get(i).getEmail().equals(email) && freelancers.get(i).getPassword().equals(password)){
                specialties.add(specialty);
                freelancerExists = true;
                freelancers.get(i).getSpecialties().add(specialty);
            }
        }

        if(freelancerExists){
            return "Habilidade adicionada com sucesso!";

        }else{
            return "Erro ao postar o projeto. Email ou senha incorreto, tente novamente.";

        }
    }

    //Adicionar freelancer a um projeto
    public String addUserFreelancerProject(String email, String password, String nameProject){
        Boolean projectExists = false;
        for (int i = 0; i < projects.size(); i++) {
            if(projects.get(i).getNameProject().equals(nameProject) && freelancers.get(i).getEmail().equals(email) &&
                    freelancers.get(i).getPassword().equals(password)){
                projects.get(i).getProfissionals().add(freelancers.get(i));
                projectExists = true;
            }
        }
        if(projectExists){
            return "Freelancer adicionado ao projeto com sucesso!";
        }else{
            return "Não foi possível adicionar o freelancer ao projeto, tente novamente..";
        }
    }

    //Fazer Login Freelancer
    public String setLoginFreelancer(String email, String password){
        Boolean freelancerExists = false;
        String nameFreelancer = "";
        for (int i = 0; i < freelancers.size(); i++) {
            if(freelancers.get(i).getEmail().equals(email) && freelancers.get(i).getPassword().equals(password)){
                freelancerExists = true;
                freelancers.get(i).setStatusOnline(true);
                nameFreelancer = freelancers.get(i).getName();
            }
        }

        if(freelancerExists){
            return String.format("Login de %s realizado com sucesso;", nameFreelancer);
        }else{
            return "Falha ao realizar o login, usuário ou senha inválidos, tente novamente...";
        }
    }

    //Fazer Login Company
    public String setLoginCompany(String email, String password){
        Boolean companyExists = false;
        String nameCompany = "";
        for (int i = 0; i < contactorCompanies.size(); i++) {
            if(contactorCompanies.get(i).getEmail().equals(email) && contactorCompanies.get(i).getPassword().equals(password)){
                companyExists = true;
                contactorCompanies.get(i).setStatusOnline(true);
                nameCompany = contactorCompanies.get(i).getName();
            }
        }

        if(companyExists){
            return String.format("Login de %s realizado com sucesso;", nameCompany);
        }else{
            return "Falha ao realizar o login, usuário ou senha inválidos, tente novamente...";
        }
    }

    //Fazer Login Contactor Person
    public String setLoginContactorPerson(String email, String password){
        Boolean personExists = false;
        String namePerson = "";
        for (int i = 0; i < contactorPersons.size(); i++) {
            if(contactorPersons.get(i).getEmail().equals(email) && contactorPersons.get(i).getPassword().equals(password)){
                personExists = true;
                contactorPersons.get(i).setStatusOnline(true);
                namePerson = contactorPersons.get(i).getName();
            }
        }
        if(personExists){
            return String.format("Login de %s realizado com sucesso;", namePerson);
        }else{
            return "Falha ao realizar o login, usuário ou senha inválidos, tente novamente...";
        }
    }

    //Fazer Logoff Freelancer
    public String setLogoffFreelancer(String email, String password){
        Boolean freelancerExists = false;
        String nameFreelancer = "";
        for (int i = 0; i < freelancers.size(); i++) {
            if(freelancers.get(i).getEmail().equals(email) && freelancers.get(i).getPassword().equals(password)){
                freelancerExists = true;
                freelancers.get(i).setStatusOnline(false);
                nameFreelancer = freelancers.get(i).getName();
            }
        }

        if(freelancerExists){
            return String.format("Logouff de %s realizado com sucesso;", nameFreelancer);
        }else{
            return "Falha ao fazer o logoff, usuário ou senha inválidos, tente novamente...";
        }
    }

    //Fazer Logoff Company
    public String setLogoffCompany(String email, String password){
        Boolean companyExists = false;
        String nameCompany = "";
        for (int i = 0; i < contactorCompanies.size(); i++) {
            if(contactorCompanies.get(i).getEmail().equals(email) && contactorCompanies.get(i).getPassword().equals(password)){
                companyExists = true;
                contactorCompanies.get(i).setStatusOnline(false);
                nameCompany = contactorCompanies.get(i).getName();
            }
        }

        if(companyExists){
            return String.format("Logoff de %s realizado com sucesso;", nameCompany);
        }else{
            return "Falha ao fazer o logoff, usuário ou senha inválidos, tente novamente...";
        }
    }

    //Fazer Logoff Contactor Person
    public String setLogoffContactorPerson(String email, String password){
        Boolean personExists = false;
        String namePerson = "";
        for (int i = 0; i < contactorPersons.size(); i++) {
            if(contactorPersons.get(i).getEmail().equals(email) && contactorPersons.get(i).getPassword().equals(password)){
                personExists = true;
                contactorPersons.get(i).setStatusOnline(false);
                namePerson = contactorPersons.get(i).getName();
            }
        }
        if(personExists){
            return String.format("Logoff de %s realizado com sucesso;", namePerson);
        }else{
            return "Falha ao fazer o logoff, usuário ou senha inválidos, tente novamente...";
        }
    }

    //Removendo usuário Freelancer
    public String deleteUserFreelancer(String email, String password){
        Boolean personExists = false;
        String nameUser = "";

        for (int i = 0; i < freelancers.size(); i++) {
           if(freelancers.get(i).getEmail().equals(email) && freelancers.get(i).getPassword().equals(password)){
                nameUser = freelancers.get(i).getName();
                personExists = true;
                freelancers.remove(i);
            }
        }
        if(personExists){
            return String.format("Usuário %s deletado com sucesso!", nameUser);
        }else{
            return "Usuário não encontrado";
        }
    }

    //Removendo usuário Company
    public String deleteUserContactorCompany(String email, String password){
        Boolean companyExists = false;
        String nameUser = "";

        for (int i = 0; i < contactorCompanies.size(); i++) {
            if(contactorCompanies.get(i).getEmail().equals(email) && contactorCompanies.get(i).getPassword().equals(password)){
                nameUser = contactorCompanies.get(i).getName();
                companyExists = true;
                contactorCompanies.remove(i);
            }
        }
        if(companyExists){
            return String.format("Empresa %s deletada com sucesso!", nameUser);
        }else{
            return "Empresa não encontrada";
        }
    }

    //Removendo usuário Person
    public String deleteUserContactorPerson(String email, String password){
        Boolean personExists = false;
        String nameUser = "";

        for (int i = 0; i < contactorPersons.size(); i++) {
            if(contactorPersons.get(i).getEmail().equals(email) && contactorPersons.get(i).getPassword().equals(password)){
                nameUser = contactorPersons.get(i).getName();
                personExists = true;
                contactorPersons.remove(i);
            }
        }
        if(personExists){
            return String.format("Usuário %s deletado com sucesso!", nameUser);
        }else{
            return "Usuário não encontrado";
        }
    }

    //Removendo Project
    public String deleteProject(String nameProject, String email, String password){
        String projectName = "";
        Boolean projectExists = false;
        for (int i = 0; i < projects.size(); i++) {
            if(projects.get(i).getNameProject().equals(nameProject) && contactorCompanies.get(i).getEmail().equals(email) &&
                    contactorCompanies.get(i).getPassword().equals(password)){
                projectName = projects.get(i).getNameProject();
                projectExists = true;
                projects.remove(i);
                contactorCompanies.get(i).getProjectCompany().remove(i);
            }
        }
        if(projectExists){
            return String.format("Projeto %s deletado com sucesso!", projectName);
        }else{
            return "Projeto não encontrado";
        }
    }
}
