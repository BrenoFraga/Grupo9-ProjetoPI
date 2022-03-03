package FindR.projectFindR.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public abstract class PersonModel {
    private String name;
    private String lastName;
    final String cpf;
    private String emailUser;
    private String senhaUser;

 }
