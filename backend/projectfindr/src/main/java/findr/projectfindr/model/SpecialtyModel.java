package findr.projectfindr.model;

import javax.persistence.*;

@Entity
public class SpecialtyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSpecialty;
    private String occupationArea;
    private String technologyUsed;
    private String levelKnowledge;

    @ManyToOne
    private UserFreelancer userFreelancer;

    public UserFreelancer getUserFreelancer() {
        return userFreelancer;
    }
    public Long getIdSpecialty() {
        return idSpecialty;
    }

    public void setIdSpecialty(Long idSpecialty) {
        this.idSpecialty = idSpecialty;
    }

    public String getOccupationArea() {
        return occupationArea;
    }

    public void setOccupationArea(String occupationArea) {
        this.occupationArea = occupationArea;
    }

    public String getTechnologyUsed() {
        return technologyUsed;
    }

    public void setTechnologyUsed(String technologyUsed) {
        this.technologyUsed = technologyUsed;
    }

    public String getLevelKnowledge() {
        return levelKnowledge;
    }

    public void setLevelKnowledge(String levelKnowledge) {
        this.levelKnowledge = levelKnowledge;
    }

}
