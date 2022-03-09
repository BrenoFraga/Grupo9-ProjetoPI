package FindR.projectFindR.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public abstract class PessoaModel {
    final String cpf;
    private String name;
    private String lastName;
    private String emailUser;
    private String senhaUser;


    abstract boolean setTypeUser();
    abstract boolean setStatusUser();

 }
