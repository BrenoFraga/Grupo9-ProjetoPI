package findr.projectfindr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Plans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPlan;
    private String planType;
    private int quantityClicks;

    public Plans(long idPlan, String planType, int quantityClicks) {
        this.idPlan = idPlan;
        this.planType = planType;
        this.quantityClicks = quantityClicks;
    }

    public Plans() {
    }

    public long getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(long idPlan) {
        this.idPlan = idPlan;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public int getQuantityClicks() {
        return quantityClicks;
    }

    public void setQuantityClicks(int quantityClicks) {
        this.quantityClicks = quantityClicks;
    }
}
