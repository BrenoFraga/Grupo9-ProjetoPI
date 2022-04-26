package findr.projectfindr.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserFreelancer extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUserFreelancer;

    private String cpf;

    private String avaliableTime;

    private Boolean online = false;

    private Integer fkStatusFreelancer;

    private Integer fkPlanFreelancer;

    public UserFreelancer() {
    }

    public UserFreelancer(String name, String email, String password, String phoneContact, String country, String state, String city, Long idUserFreelancer, String cpf, String avaliableTime, Integer fkStatusFreelancer, Integer fkPlanFreelancer) {
        super(name, email, password, phoneContact, country, state, city);
        this.idUserFreelancer = idUserFreelancer;
        this.cpf = cpf;
        this.avaliableTime = avaliableTime;
        this.online = false;
        this.fkStatusFreelancer = fkStatusFreelancer;
        this.fkPlanFreelancer = fkPlanFreelancer;
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

    public Integer getFkStatusFreelancer() {
        return fkStatusFreelancer;
    }

    public void setFkStatusFreelancer(Integer fkStatusFreelancer) {
        this.fkStatusFreelancer = fkStatusFreelancer;
    }

    public Integer getFkPlanFreelancer() {
        return fkPlanFreelancer;
    }

    public void setFkPlanFreelancer(Integer fkPlanFreelancer) {
        this.fkPlanFreelancer = fkPlanFreelancer;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }


}
