package findr.projectfindr.model;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
public class pkLogLogin implements Serializable{

        @JoinColumn(name = "fk_freelancer")
        @ManyToOne
        private UserFreelancer fkFreelancer;


        @JoinColumn(name = "fk_contactor")
        @ManyToOne
        private Contactor fkContactor;

        public pkLogLogin(UserFreelancer fkFreelancer, Contactor fkContactor) {
            this.fkFreelancer = fkFreelancer;
            this.fkContactor = fkContactor;
        }
        public pkLogLogin() {

        }
    }

