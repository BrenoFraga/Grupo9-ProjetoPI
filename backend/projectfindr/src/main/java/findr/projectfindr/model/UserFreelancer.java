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

    private Integer fkStatusFreelancer;

    private Integer fkPlanFreelancer;

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
}
