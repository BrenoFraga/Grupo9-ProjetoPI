package findr.projectfindr.controller;

import findr.projectfindr.model.Plans;
import findr.projectfindr.model.SpecialtyModel;
import findr.projectfindr.repository.PlanRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {PlanController.class})
class PlanControllerTest{
    @Autowired
    PlanController controller;

    @MockBean
    private PlanRepository repository;

    @Test
    public void getNullPlansReturn204(){
        when(repository.findAll()).thenReturn(new ArrayList<>());

        ResponseEntity<List<Plans>> resposta = controller.getPlans();

        assertEquals(204, resposta.getStatusCodeValue());
    }

    @Test
    public void getValidNotNullPlansReturn200() {
        Plans s1 = mock(Plans.class);
        Plans s2 = mock(Plans.class);
        List<Plans> listaMock = List.of(s1, s2);

        when(repository.findAll()).thenReturn(listaMock);

        ResponseEntity<List<Plans>> resposta = controller.getPlans();

        assertEquals(200, resposta.getStatusCodeValue());
        assertNotNull(resposta.getBody());
        assertEquals(listaMock, resposta.getBody());
    }

    @Test
    public void saveValidPlanReturn201(){
        Plans s1 = mock(Plans.class);
        controller.salvarPlan(s1);

        ResponseEntity<List<Plans>> resposta = controller.salvarPlan(s1);
        assertEquals(201, resposta.getStatusCodeValue());
    }

}