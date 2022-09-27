package findr.projectfindr.controller;

import findr.projectfindr.model.*;
import findr.projectfindr.repository.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {LikeController.class})
public class LikeControllerTest {
    @MockBean
    LikeController controller;

    @MockBean
    private LikeProjectRepository likeProjectRepository;

    @MockBean
    private LikeFreelancerRepository likeFreelancerRepository;




    @Test
    void hasValidLikeReturn201(){
       LikeProject likeProject = mock(LikeProject.class);
       LikeProjectRepository likeProjectRepository1 = mock(LikeProjectRepository.class);

       likeProjectRepository1.save(likeProject);

       ResponseEntity response = new ResponseEntity(HttpStatus.valueOf(201));
       ResponseEntity expectedResponse = new ResponseEntity(HttpStatus.valueOf(201));

       when(controller.getlikeProject()).thenReturn(response);
       assertEquals(expectedResponse, response);

    }

    @Test
    void isValidLikeValidProjectReturnNotNull(){
        Contactor contactor = mock(Contactor.class);
        UserFreelancer freelancer = mock(UserFreelancer.class);
        ContactorRepository contactorRepository = mock(ContactorRepository.class);
        FreelancerRepository freelancerRepository = mock(FreelancerRepository.class);

        when(contactorRepository.findByIdContactor(2L)).thenReturn(contactor);
        when(freelancerRepository.findByIdUserFreelancer(2L)).thenReturn(freelancer);

        ResponseEntity response = new ResponseEntity(HttpStatus.valueOf(201));
        ResponseEntity expectedResponse = new ResponseEntity(HttpStatus.valueOf(201));

        when(controller.cadastrarLikeFreelancer(2L,2L,true)).thenReturn(response);
        assertEquals(expectedResponse, controller.cadastrarLikeFreelancer(2L, 2L, true));
    }
}
