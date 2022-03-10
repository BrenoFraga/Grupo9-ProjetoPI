package FindR.projectFindR.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class ContratanteModel {
    private int id_contactor;
    private String name_contactor;
//    private String email;
//    private String password_contactor;
//    private String cpf;
//    private String cnpj;
//    private String phone_contact;
//    private String country;
//    private String state;
//    private String city;
    private String administrator_name;
    private int administrator;
    private List<RepresentanteModel> usersManeger;
    private List<ProjectModel> projects;


    public ContratanteModel() {
        this.projects = new ArrayList<>();
        this.usersManeger = new ArrayList<>();
    }


}
