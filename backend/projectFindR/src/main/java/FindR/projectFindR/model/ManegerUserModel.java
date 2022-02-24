package FindR.projectFindR.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ManegerUserModel extends PersonModel{
    private boolean typeUser;

    public ManegerUserModel(String name,
                            String lastName,
                            String cpf,
                            String emailUserComum,
                            String senhaUserComum,
                            boolean typeUser) {
        super(name, lastName, cpf, emailUserComum, senhaUserComum);
        this.typeUser = typeUser;
    }
}
