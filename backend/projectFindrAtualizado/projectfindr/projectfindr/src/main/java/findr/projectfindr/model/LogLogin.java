package findr.projectfindr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "log_login")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogLogin {
    @EmbeddedId
    private pkLogLogin idLogLogin;

    private Date dateHour;
}
