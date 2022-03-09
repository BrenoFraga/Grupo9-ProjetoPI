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

    public RepresentanteModel(String name,
                              String lastName,
                              String cpf,
                              String emailUserComum,
                              String senhaUserComum) {
        super(name, lastName, cpf, emailUserComum, senhaUserComum);
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
