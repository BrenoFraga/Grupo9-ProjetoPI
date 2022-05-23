package findr.projectfindr.model;


import javax.persistence.*;

@Entity
public class UserFreelancer extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUserFreelancer;

    private String cpf;

    public UserFreelancer(String name, String email, String password, String phoneContact, String country, String state, String city, String avaliableTime, Long idUserFreelancer, String cpf) {
        super(name, email, password, phoneContact, country, state, city, avaliableTime);
        this.idUserFreelancer = idUserFreelancer;
        this.cpf = cpf;
    }

    public UserFreelancer() {
    }




    public Long getIdUserFreelancer() {
        return idUserFreelancer;
    }

    public void setIdUserFreelancer(Long idUserFreelancer) {
        this.idUserFreelancer = idUserFreelancer;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }





}
