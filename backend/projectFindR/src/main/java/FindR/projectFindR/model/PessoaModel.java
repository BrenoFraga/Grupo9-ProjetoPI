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
    private final String cpf_cnpj;
    private String email;
    private String password;
    private String phone_contact;
    private String country;
    private String state;
    private String city;

    abstract boolean setTypeUser();

    abstract boolean setStatusUser();

}
