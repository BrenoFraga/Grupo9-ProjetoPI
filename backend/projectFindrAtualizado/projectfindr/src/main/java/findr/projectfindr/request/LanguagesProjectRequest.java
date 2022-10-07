package findr.projectfindr.request;

public class LanguagesProjectRequest {

    private String requiredLanguages;

    public LanguagesProjectRequest(String requiredLanguages) {
        this.requiredLanguages = requiredLanguages;
    }

    public String getRequiredLanguages() {
        return requiredLanguages;
    }
}
