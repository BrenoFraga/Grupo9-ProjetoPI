package findr.projectfindr.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public abstract class User {

    private String name;

    private String email;

    private String password;

    private String cpf;
    private String cnpj;

    private String phoneContact;

    private String country;

    private String state;

    private String city;


    public User(String name, String email, String password, String cpf, String cnpj, String phoneContact, String country, String state, String city) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.phoneContact = phoneContact;
        this.country = country;
        this.state = state;
        this.city = city;
    }

    public User(String name, String email, String phoneContact, String country, String state, String city) {
        this.name = name;
        this.email = email;
        this.phoneContact = phoneContact;
        this.country = country;
        this.state = state;
        this.city = city;
    }

    protected User() {
    }

}
