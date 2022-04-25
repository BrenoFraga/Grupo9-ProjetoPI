package findr.projectfindr.resposta;

import javax.validation.constraints.Email;

public class LoginResposta {
    @Email
    private String email;
    private String password;

    public LoginResposta(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
