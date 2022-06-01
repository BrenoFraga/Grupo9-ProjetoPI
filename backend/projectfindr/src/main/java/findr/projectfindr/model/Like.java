package findr.projectfindr.model;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Like {

    private Date dateHour;

    private boolean evaluation;

    public Like(Date dateHour, boolean evaluation) {
        this.dateHour = dateHour;
        this.evaluation = evaluation;
    }

    protected Like() {
    }

    public Date getDateHour() {
        return dateHour;
    }

    public void setDateHour(Date dateHour) {
        this.dateHour = dateHour;
    }

    public boolean getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(boolean evaluation) {
        this.evaluation = evaluation;
    }
}
