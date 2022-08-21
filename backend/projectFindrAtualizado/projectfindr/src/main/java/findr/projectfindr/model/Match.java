package findr.projectfindr.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "match_user")
@Data
public class Match{

    @EmbeddedId
    private pkMatch idMatch;

    private Date dateHour;

    public Match(pkMatch idMatch, Date dateHour) {
        this.idMatch = idMatch;
        this.dateHour = dateHour;
    }
    public Match(){}
}
