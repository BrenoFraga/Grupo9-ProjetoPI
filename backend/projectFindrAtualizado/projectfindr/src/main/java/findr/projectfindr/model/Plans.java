package findr.projectfindr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
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
}
