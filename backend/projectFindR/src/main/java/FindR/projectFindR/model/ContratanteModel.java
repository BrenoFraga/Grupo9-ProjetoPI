package FindR.projectFindR.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class ContratanteModel extends PessoaModel{
    private int id_contactor;
    private String name_contactor;
    private String administrator_name;
    private int administrator;
    private List<RepresentanteModel> usersManeger;
    //CRIAR ATRIBUTO DE STATUS DA DISPONIBILIDADE
    private List<ProjectModel> projects;

    public ContratanteModel(String cpf_cnpj, String email, String password, String phone_contact,
                            String country, String state, String city, int id_contactor, String name_contactor,
                            String administrator_name, int administrator, List<RepresentanteModel> usersManeger,
                            List<ProjectModel> projects) {
        super(cpf_cnpj, email, password, phone_contact, country, state, city);
        this.id_contactor = id_contactor;
        this.name_contactor = name_contactor;
        this.administrator_name = administrator_name;
        this.administrator = administrator;
        this.usersManeger = usersManeger;
        this.projects = projects;
    }



    @Override
    boolean setTypeUser() {
        return false;
    }

    @Override
    boolean setStatusUser() {
        return false;
    }
}
