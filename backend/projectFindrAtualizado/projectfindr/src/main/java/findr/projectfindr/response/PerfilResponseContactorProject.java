package findr.projectfindr.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PerfilResponseContactorProject {
    private String name;
    private byte[] image;
    private String city;
    private String state;
    private String email;
    private String nameProject;
}
