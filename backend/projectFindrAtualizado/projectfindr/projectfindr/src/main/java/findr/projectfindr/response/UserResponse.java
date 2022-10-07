package findr.projectfindr.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserResponse {

    private String name;

    private String email;

    private String phoneContact;

    private String country;

    private String state;

    private String city;

}
