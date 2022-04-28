package findr.projectfindr.model;


import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {

    private String name;

    private String email;

    private String password;

    private String phoneContact;

    private String country;

    private String state;

    private String city;

    public User(String name, String email, String password, String phoneContact, String country, String state, String city) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneContact = phoneContact;
        this.country = country;
        this.state = state;
        this.city = city;
    }

    protected User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneContact() {
        return phoneContact;
    }

    public void setPhoneContact(String phoneContact) {
        this.phoneContact = phoneContact;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneContact='" + phoneContact + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}