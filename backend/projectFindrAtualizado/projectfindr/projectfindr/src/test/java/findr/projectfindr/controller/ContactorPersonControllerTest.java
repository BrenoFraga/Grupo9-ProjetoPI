package findr.projectfindr.controller;

import findr.projectfindr.model.Contactor;
import findr.projectfindr.model.ProjectModel;
import findr.projectfindr.repository.ContactorRepository;
import findr.projectfindr.repository.ProjectRepository;
import findr.projectfindr.repository.SpecialtyRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ContactorPersonController.class})
class ContactorPersonControllerTest {
    @Autowired
    ContactorPersonController controller;

    @MockBean
    ProjectModel projectTest;

    @MockBean
    private ContactorRepository contactorRepository;

    @MockBean
    private SpecialtyRepository specialtyRepository;

    @MockBean
    private ProjectRepository projectRepository;

    @MockBean
    private ContactorRepository repository;

    @MockBean
    private Contactor testContactor;

    @Test
    void addContactor() {
        Contactor testeUser = org.mockito.Mockito.mock(Contactor.class);
        ResponseEntity res = controller.addUserContactorPerson(testeUser);
        assertEquals(201, res.getStatusCodeValue());
    }

    @Test
    void emptyProjectListById() {
        ResponseEntity res = controller.myProjects( 999L);
        assertEquals(204, res.getStatusCodeValue());
    }

    @Test
    void validReturnProjectsById() {
        Contactor contactor = mock(Contactor.class);
        when(contactor.getIdContactor()).thenReturn(999L);

        ProjectModel mockedList = mock(ProjectModel.class);
        when(mockedList.getIdProjectContactor()).thenReturn(200L);

        Long res = mockedList.getIdProjectContactor();
        assertEquals(200, res);
    }


    @Test
    void saveProjectReturnNotNull() {
        Contactor contactor = mock(Contactor.class);
        ProjectModel mockedList = mock(ProjectModel.class);

        mockedList.setFkContactor(contactor);
        mockedList.setNameProject("Teste");
        mockedList.setLevelKnowledge("medio");

        ResponseEntity res = controller.myProjects(contactor.getIdContactor());
        assertNotNull(mockedList);
    }

}