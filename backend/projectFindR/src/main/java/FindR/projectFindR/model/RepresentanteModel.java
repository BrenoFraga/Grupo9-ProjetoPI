package FindR.projectFindR.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RepresentanteModel extends PessoaModel {
    private boolean typeUser;
    private boolean statusOnline;

    public RepresentanteModel(String cpf_cnpj, String email, String password,
                              String phone_contact, String country, String state,
                              String city, boolean typeUser, boolean statusOnline) {
        super(cpf_cnpj, email, password, phone_contact, country, state, city);
        this.typeUser = typeUser;
        this.statusOnline = statusOnline;
    }

    @Override
    public boolean setTypeUser() {
        setTypeUser(true);
        return true;
    }

    @Override
    public boolean setStatusUser() {
        setStatusOnline(false);
        return false;
    }
}
