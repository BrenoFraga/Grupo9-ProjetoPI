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
    private String nome;
    private String cpf;
    private String cnpj;
    private List<RepresentanteModel> usersManeger;
    private List<TaskModel> projects;


    public ContratanteModel() {
        this.projects = new ArrayList<>();
        this.usersManeger = new ArrayList<>();
    }


}
