package findr.projectfindr.controller;

import findr.projectfindr.model.Contactor;
import findr.projectfindr.model.ProjectModel;
import findr.projectfindr.model.UserFreelancer;
import findr.projectfindr.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {ProjectController.class})
public class ProjectControllerTest {

    @MockBean
    ProjectController controller;

    @MockBean
    private ProjectRepository projectRepository;

    @Test
    void hasNoProjectReturnNull() {
        assertNull(controller.getProject());
    }

    @Test
    void hasAtLeastOneProjectNotReturnNull() {
        ProjectRepository projectRepository1 = mock(ProjectRepository.class);
        ProjectModel projectMock = mock(ProjectModel.class);
        ProjectController controller1 = mock(ProjectController.class);
        projectRepository1.save(projectMock);

        Mockito.verify(projectRepository1).save(projectMock);

        assertNotNull(projectRepository1.findAll());
    }

    @Test
    void hasAValidProjectAndSearchByIdNotReturnNull(){
        ProjectRepository projectRepository1 = mock(ProjectRepository.class);
        ProjectModel projectMock = mock(ProjectModel.class);
        ProjectController controller1 = mock(ProjectController.class);
        Contactor contactor = mock(Contactor.class);
        when(contactor.getIdContactor()).thenReturn(2L);
        when(projectRepository1.findByIdProjectContactor(contactor.getIdContactor())).thenReturn(projectMock);

        assertNotNull(projectRepository1.findByIdProjectContactor(contactor.getIdContactor()));
    }

    @Test
    void hasAInvalidProjectAndSearchByIdReturnNull() {
        ProjectRepository projectRepository1 = mock(ProjectRepository.class);
        ProjectModel projectMock = mock(ProjectModel.class);
        ProjectController controller1 = mock(ProjectController.class);
        Contactor contactor = mock(Contactor.class);
        when(projectRepository1.findByIdProjectContactor(contactor.getIdContactor())).thenReturn(projectMock);

        assertNull(projectRepository1.findByIdProjectContactor(999L));
    }


}
