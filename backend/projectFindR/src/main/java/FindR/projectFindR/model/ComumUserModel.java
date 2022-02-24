package FindR.projectFindR.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ComumUserModel extends PersonModel {
    boolean typeUser;

    public ComumUserModel(String name,
                          String lastName,
                          String cpf,
                          String emailUserComum,
                          String senhaUserComum) {
        super(name, lastName, cpf, emailUserComum, senhaUserComum);
        this.typeUser = typeUser;
    }
}
