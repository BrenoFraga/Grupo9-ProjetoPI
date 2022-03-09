package FindR.projectFindR.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FreelancerModel extends PessoaModel {
    boolean typeUser;
    boolean statusOnline;

    public FreelancerModel(String name,
                           String lastName,
                           String cpf,
                           String emailUser,
                           String senhaUser) {
        super(name, lastName, cpf, emailUser, senhaUser);
    }

    @Override
    public boolean setTypeUser() {
        setTypeUser(false);
        return false;
    }

    @Override
    public boolean setStatusUser() {
        setStatusOnline(false);
        return false;
    }
}
