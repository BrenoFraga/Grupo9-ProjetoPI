package findr.projectfindr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public abstract class Like {

    private Date dateHour;

    private boolean evaluation;

    public Like(Date dateHour, boolean evaluation) {
        this.dateHour = dateHour;
        this.evaluation = evaluation;
    }

    protected Like() {
    }
    
    public boolean getEvaluation() {
        return evaluation;
    }


}
