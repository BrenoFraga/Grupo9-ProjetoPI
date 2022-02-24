package FindR.projectFindR.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TaskModel implements IMonetariavel {
    private String nome;
    private String descricao;
    private double price;

    public TaskModel(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.price = price;
    }


    @Override
    public Double menetizacao() {
        setPrice(0.00);
        return price;
    }
}
