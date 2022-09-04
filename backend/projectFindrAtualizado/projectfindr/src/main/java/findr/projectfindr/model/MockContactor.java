package findr.projectfindr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "mock_contactor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MockContactor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mock_contactor")
    private Long idMockContactor;
    private String name;


    private String technologyUsed;
}
