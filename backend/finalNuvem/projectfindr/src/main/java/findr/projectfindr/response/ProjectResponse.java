package findr.projectfindr.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProjectResponse {
    private String nomeProjeto;
    private String descProjeto;
    private String requiredArea;
    private String requiredLanguage;
    private int quantityProfissionals;

}
