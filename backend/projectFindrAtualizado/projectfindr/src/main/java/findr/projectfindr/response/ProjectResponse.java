package findr.projectfindr.response;

public class ProjectResponse {
    private String nomeProjeto;
    private String descProjeto;
    private String requiredArea;
    private String requiredLanguage;
    private int quantityProfissionals;

    public ProjectResponse(String nomeProjeto, String descProjeto, String requiredArea, String requiredLanguage, int quantityProfissionals) {
        this.nomeProjeto = nomeProjeto;
        this.descProjeto = descProjeto;
        this.requiredArea = requiredArea;
        this.requiredLanguage = requiredLanguage;
        this.quantityProfissionals = quantityProfissionals;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public String getDescProjeto() {
        return descProjeto;
    }

    public String getRequiredArea() {
        return requiredArea;
    }

    public String getRequiredLanguage() {
        return requiredLanguage;
    }

    public int getQuantityProfissionals() {
        return quantityProfissionals;
    }
}
