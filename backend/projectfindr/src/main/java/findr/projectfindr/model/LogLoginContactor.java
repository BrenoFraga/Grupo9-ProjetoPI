package findr.projectfindr.model;

import findr.projectfindr.pks.pkLogLoginContactor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "log_login_contactor")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LogLoginContactor implements Serializable {

    @EmbeddedId
    pkLogLoginContactor fkContactor;

    private Date dateHour;

}
