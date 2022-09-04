package findr.projectfindr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "mock_freelancer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MockFreelancer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mock_freelancer")
    private Long idMockFreelancer;
    private String name;
    private String nameProject;
}
