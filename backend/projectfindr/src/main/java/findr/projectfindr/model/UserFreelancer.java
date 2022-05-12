package findr.projectfindr.model;


import javax.persistence.*;

@Entity
public class UserFreelancer extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUserFreelancer;

    private String cpf;

    private String avaliableTime;

    private Boolean online = false;

    @ManyToOne
    private SpecialtyModel specialtyModel;

    public UserFreelancer() {
    }

    public UserFreelancer(String name, String email, String password, String phoneContact, String country, String state, String city, Long idUserFreelancer, String cpf, String avaliableTime, Integer fkStatusFreelancer, Integer fkPlanFreelancer) {
        super(name, email, password, phoneContact, country, state, city);
        this.idUserFreelancer = idUserFreelancer;
        this.cpf = cpf;
        this.avaliableTime = avaliableTime;
        this.online = false;
    }

    public SpecialtyModel getSpecialtyModel() {
        return specialtyModel;
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

    public String getAvaliableTime() {
        return avaliableTime;
    }

    public void setAvaliableTime(String avaliableTime) {
        this.avaliableTime = avaliableTime;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

}
