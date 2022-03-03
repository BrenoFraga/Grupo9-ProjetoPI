package FindR.projectFindR.model;

import lombok.AllArgsConstructor;
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
    private List<ComumUserModel> devs;

    public TaskModel(String nome, String descricao, double price) {
        this.nome = nome;
        this.descricao = descricao;
        this.devs = new ArrayList<>();
    }
}
