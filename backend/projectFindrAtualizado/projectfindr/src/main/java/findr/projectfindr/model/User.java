package findr.projectfindr.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
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


    @JsonIgnore
    @Column(length = 50_000_000)
    private byte[] image;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String cpf;
    private String cnpj;

    private String phoneContact;

    private String country;

    private String state;

    private String city;


    public User(byte[] image, String name, String email, String password, String cpf, String cnpj, String phoneContact, String country, String state, String city) {
        this.image = image;
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

    protected User() {
    }

}
