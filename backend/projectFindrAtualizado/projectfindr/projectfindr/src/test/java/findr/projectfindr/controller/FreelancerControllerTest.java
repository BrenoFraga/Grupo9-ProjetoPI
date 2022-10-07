package findr.projectfindr.controller;

import findr.projectfindr.model.UserFreelancer;
import findr.projectfindr.repository.FreelancerRepository;
import findr.projectfindr.repository.SpecialtyRepository;
import findr.projectfindr.request.LoginRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {FreelancerController.class})
class FreelancerControllerTest {
    @Autowired
    FreelancerController controller;

    @MockBean
    private SpecialtyRepository specialtyRepository;

    @MockBean
    private FreelancerRepository repository;

    @Test
    void addUserFreelancer() {
        UserFreelancer testeUser = new UserFreelancer();

        ResponseEntity resposta = controller.addUserFreelancer(testeUser);

        assertEquals(201, resposta.getStatusCodeValue());
    }

    @Test
    void addUserFreelancerParametersIncorrect(){
        UserFreelancer testeUser= null;

        when(controller.addUserFreelancer(testeUser)).thenReturn(ResponseEntity.status(406).build());
        ResponseEntity resposta = controller.addUserFreelancer(testeUser);

        assertEquals(406, resposta.getStatusCodeValue());
    }

    @Test
    void setLoginFreelancer() {
        UserFreelancer testeUser = mock(UserFreelancer.class);
        when(repository.findByEmailAndPassword(testeUser.getEmail(),testeUser.getPassword())).thenReturn(testeUser);
        LoginRequest loginRequest = new LoginRequest(testeUser.getEmail(), testeUser.getPassword());
        ResponseEntity<List<LoginRequest>> testeLogin = controller.setLoginFreelancer(loginRequest);

        assertEquals(200, testeLogin.getStatusCodeValue());
    }

    @Test
    void setLoginFreelancerUserIsEmpty(){
        UserFreelancer testeUser = new UserFreelancer();
        when(repository.findByEmailAndPassword(testeUser.getEmail(),testeUser.getPassword())).thenReturn(null);
        LoginRequest loginRequest = new LoginRequest(testeUser.getEmail(), testeUser.getPassword());
        ResponseEntity<List<LoginRequest>> testeLogin = controller.setLoginFreelancer(loginRequest);
        assertEquals(404, testeLogin.getStatusCodeValue());
    }
}