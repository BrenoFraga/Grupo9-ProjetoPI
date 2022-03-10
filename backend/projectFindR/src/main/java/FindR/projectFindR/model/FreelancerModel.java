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
    private int id_user_freelancer;
    private String name_freelancer;


    public FreelancerModel(String email,
                           String password,
                           String cpf_cnpj,
                           String phone_contact,
                           String country,
                           String state,
                           String city,
                           boolean typeUser,
                           boolean statusOnline,
                           int id_user_freelancer,
                           String name_freelancer) {
        super(email, password, cpf_cnpj, phone_contact, country, state, city);
        this.typeUser = typeUser;
        this.statusOnline = statusOnline;
        this.id_user_freelancer = id_user_freelancer;
        this.name_freelancer = name_freelancer;
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
