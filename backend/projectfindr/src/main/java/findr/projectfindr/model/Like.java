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

    private char evaluation;

    public Like(Date dateHour, char evaluation) {
        this.dateHour = dateHour;
        this.evaluation = evaluation;
    }

    public Date getDateHour() {
        return dateHour;
    }

    public void setDateHour(Date dateHour) {
        this.dateHour = dateHour;
    }

    public char getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(char evaluation) {
        this.evaluation = evaluation;
    }
}
