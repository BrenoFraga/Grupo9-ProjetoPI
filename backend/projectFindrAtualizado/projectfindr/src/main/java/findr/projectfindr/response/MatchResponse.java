package findr.projectfindr.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MatchResponse {
    private long idContactor;
    private long fkContactor;
    private long idFreelancer;
    private long fkFreelancer;
}
