package findr.projectfindr.model;


import javax.persistence.*;

@Entity
public class UserFreelancer extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUserFreelancer;


    private long avaliableTime;

    @ManyToOne
    private Plans fkPlanFreelancer;

    public UserFreelancer(String name, String email, String password, String cpf, String cnpj, String phoneContact, String country, String state, String city, Long idUserFreelancer, long avaliableTime, Plans fkPlanFreelancer) {
        super(name, email, password, cpf, cnpj, phoneContact, country, state, city);
        this.idUserFreelancer = idUserFreelancer;
        this.avaliableTime = avaliableTime;
        this.fkPlanFreelancer = fkPlanFreelancer;
    }

    public UserFreelancer() {
    }

    public Long getIdUserFreelancer() {
        return idUserFreelancer;
    }

    public void setIdUserFreelancer(Long idUserFreelancer) {
        this.idUserFreelancer = idUserFreelancer;
    }



    public long getAvaliableTime() {
        return avaliableTime;
    }

    public void setAvaliableTime(long avaliableTime) {
        this.avaliableTime = avaliableTime;
    }

    public Plans getFkPlanFreelancer() {
        return fkPlanFreelancer;
    }

    public void setFkPlanFreelancer(Plans fkPlanFreelancer) {
        this.fkPlanFreelancer = fkPlanFreelancer;
    }
}
