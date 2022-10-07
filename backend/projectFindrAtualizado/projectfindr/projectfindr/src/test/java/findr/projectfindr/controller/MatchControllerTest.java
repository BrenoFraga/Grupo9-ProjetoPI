package findr.projectfindr.controller;

import findr.projectfindr.model.Match;
import findr.projectfindr.model.Plans;
import findr.projectfindr.repository.ContactorRepository;
import findr.projectfindr.repository.FreelancerRepository;
import findr.projectfindr.repository.MatchRepositoy;
import findr.projectfindr.response.MatchFreelancer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {MatchController.class})
public class MatchControllerTest {
    @Autowired
    MatchController controller;

    @MockBean
    private MatchRepositoy matchRepositoy;

    @MockBean
    private FreelancerRepository freelancerRepository;

    @MockBean
    private ContactorRepository contactorRepository;


    @Test
    public void getEmptyFreelancerMatchResult204(){
        when(matchRepositoy.findByIdMatch_fkFreelancer_IdUserFreelancer(2L)).thenReturn(new ArrayList<>());
        ResponseEntity<List<Match>> resposta = controller.getMatchFreelancer(2L);

        assertEquals(204, resposta.getStatusCodeValue());
    }

    @Test
    public void getValidFreelancerMatchResult200(){
        Match m1 = mock(Match.class);
        Match m2 = mock(Match.class);
        List<Match> listaMock = List.of(m1, m2);

        when(matchRepositoy.findByIdMatch_fkFreelancer_IdUserFreelancer(2L)).thenReturn(listaMock);
        ResponseEntity<List<Match>> resposta = controller.getMatchFreelancer(2L);

        assertEquals(200, resposta.getStatusCodeValue());
    }



    @Test
    public void getEmptyContactorMatchResult204(){
        when(matchRepositoy.findByIdMatch_FkContactor_IdContactor(2L)).thenReturn(new ArrayList<>());
        ResponseEntity<List<Match>> resposta = controller.getMatchContactor(2L);

        assertEquals(204, resposta.getStatusCodeValue());
    }

    @Test
    public void getValidContactorMatchResult200(){
        Match m1 = mock(Match.class);
        Match m2 = mock(Match.class);
        List<Match> listaMock = List.of(m1, m2);

        when(matchRepositoy.findByIdMatch_FkContactor_IdContactor(2L)).thenReturn(listaMock);
        ResponseEntity<List<Match>> resposta = controller.getMatchContactor(2L);

        assertEquals(200, resposta.getStatusCodeValue());
    }

    @Test
    public void getEmptyMatchFreelancerProjectResult204(){
        when(matchRepositoy.showMatchFreelancer(2L)).thenReturn(new ArrayList<>());
        ResponseEntity<List<Match>> resposta = controller.getMatchFreelancerProject(2L);

        assertEquals(204, resposta.getStatusCodeValue());
    }

    @Test
    public void getValidMatchFreelancerProjectResult200(){
        MatchFreelancer m1 = mock(MatchFreelancer.class);
        MatchFreelancer m2 = mock(MatchFreelancer.class);
        List<MatchFreelancer> listaMock = List.of(m1, m2);

        when(matchRepositoy.showMatchFreelancer(2L)).thenReturn(listaMock);
        ResponseEntity<List<MatchFreelancer>> resposta = controller.getMatchFreelancerProject(2L);

        assertEquals(200, resposta.getStatusCodeValue());
    }

    @Test
    public void getEmptyMatchContactorSpecialtyResult204(){
        when(matchRepositoy.showMatchContactor(2L)).thenReturn(new ArrayList<>());
        ResponseEntity<List<Match>> resposta = controller.getMatchContactorSpecialty(2L);

        assertEquals(204, resposta.getStatusCodeValue());
    }

}
