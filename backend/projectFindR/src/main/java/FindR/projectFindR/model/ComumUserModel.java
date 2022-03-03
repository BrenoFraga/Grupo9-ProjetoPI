package FindR.projectFindR.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ComumUserModel extends PersonModel implements Classificavel{
    boolean typeUser;
    boolean statusOnline;

    public ComumUserModel(String name,
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
