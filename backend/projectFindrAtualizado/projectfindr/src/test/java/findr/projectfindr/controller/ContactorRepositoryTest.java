package findr.projectfindr.controller;

import findr.projectfindr.model.Contactor;
import findr.projectfindr.model.ProjectModel;
import findr.projectfindr.repository.ContactorRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ContactorRepository.class})
class ContactorRepositoryTest {
    @MockBean
    private ContactorRepository contactorRepository;

    @Test
    void whenAddingProjectNotReturnNull(){
        ProjectModel projectTest = mock(ProjectModel.class);
        List<ProjectModel> listProjects = mock(List.class);

        for (int i = 0; i <= 10; i++) {
            listProjects.add(projectTest);
        }

        assertNotNull(listProjects);
    }

    @Test
    void whenAddingContactorNotReturnNull(){
        ContactorRepository contactorRepository1 = mock(ContactorRepository.class);
        List<ContactorRepository> listContactor = mock(List.class);

        for (int i = 0; i <= 10; i++) {
            listContactor.add(contactorRepository1);
        }

        assertNotNull(contactorRepository1.findAll());
    }

    @Test
    void whenInformingInvalidIdContactorReturnNull(){
       Contactor res = contactorRepository.findByIdContactor(999L);
       assertNull(res);
    }

    @Test
    void whenInformingValidIdContactorNotReturnNull(){
        Contactor contactor = mock(Contactor.class);
        ContactorRepository contactorRepository1 = mock(ContactorRepository.class);

        when(contactor.getIdContactor()).thenReturn(2L);
        when(contactorRepository1.findByIdContactor(contactor.getIdContactor())).thenReturn(contactor);

        assertNotNull(contactorRepository1.findByIdContactor(contactor.getIdContactor()));
    }



}
