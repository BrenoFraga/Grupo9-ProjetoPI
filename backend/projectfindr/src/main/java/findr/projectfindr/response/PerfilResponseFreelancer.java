package findr.projectfindr.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PerfilResponseFreelancer {
    private String name;
    private String image;
    private String city;
    private String state;
    private String email;
    private String technologyUsed;

}
