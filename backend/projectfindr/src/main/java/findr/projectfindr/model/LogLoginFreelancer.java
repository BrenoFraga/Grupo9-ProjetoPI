package findr.projectfindr.model;

import findr.projectfindr.pks.pkLogLoginFreelancer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "log_login_freelancer")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LogLoginFreelancer implements Serializable {

    @EmbeddedId
    pkLogLoginFreelancer fkFreelancer;

    private Date dateHour;
}
