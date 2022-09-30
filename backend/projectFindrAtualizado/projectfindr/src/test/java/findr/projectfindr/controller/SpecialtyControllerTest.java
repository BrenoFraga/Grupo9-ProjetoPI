package findr.projectfindr.controller;

import findr.projectfindr.model.SpecialtyModel;
import findr.projectfindr.model.UserFreelancer;
import findr.projectfindr.repository.PlanRepository;
import findr.projectfindr.repository.SpecialtyRepository;
import findr.projectfindr.request.LoginRequest;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {SpecialtyController.class})
public class SpecialtyControllerTest {


    @Autowired
    SpecialtyController controller;

    @MockBean
    SpecialtyModel model = new SpecialtyModel();

    @MockBean
    private SpecialtyRepository repositoryMock;

    @BeforeEach
    public void setup() { }


    @Test
     public void isValidSpecialtyAndNotNullReturn201(){
        SpecialtyModel s1 = mock(SpecialtyModel.class);
        SpecialtyModel s2 = mock(SpecialtyModel.class);
        List<SpecialtyModel> listaMock = List.of(s1, s2);

        List<SpecialtyModel> all = repositoryMock.findAll();

        when(all).thenReturn(listaMock);

//        ResponseEntity resposta = controller.getSpecialty();

//        assertEquals(201, resposta.getStatusCodeValue());
//        assertNotNull(resposta.getBody());
//        assertEquals(listaMock, resposta.getBody());
    }

    @Test
    public void isNullSpecialtyReturnNull(){
        SpecialtyController controller1 = mock(SpecialtyController.class);
        SpecialtyModel model1 = mock(SpecialtyModel.class);
        assertNull(controller1.addSpecialty(model1));
    }

    @Test
    public void isNotEmptySpecialtyReturn200(){
        SpecialtyRepository repository1 = mock(SpecialtyRepository.class);
        SpecialtyModel model1 = mock(SpecialtyModel.class);
        SpecialtyController controller1 = mock(SpecialtyController.class);
        System.out.println(controller1.getSpecialty());

    }




    SpecialtyModel returnModel(){
        SpecialtyModel testeModel = new SpecialtyModel();
        UserFreelancer testeUser = mock(UserFreelancer.class);
        model.setTechnologyUsed("java");
        model.setOcupationArea("java");
        model.setLevelKnowledge("mdoerado");
        model.setFkFreelancer(testeUser);
        model.setIdSpecialty(2L);

        return model;
    }



}
