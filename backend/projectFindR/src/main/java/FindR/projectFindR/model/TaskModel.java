package FindR.projectFindR.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class TaskModel {
    private String nome;
    private String descricao;
    private List<FreelancerModel> devs;

    public TaskModel(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.devs = new ArrayList<>();
    }
}
