package findr.projectfindr.response;

public class SpecialtyResponse {

    private String ocupationArea;
    private String thecnologyUsed;
    private String levelKnowledge;

    public SpecialtyResponse(String ocupationArea, String thecnologyUsed, String levelKnowledge) {
        this.ocupationArea = ocupationArea;
        this.thecnologyUsed = thecnologyUsed;
        this.levelKnowledge = levelKnowledge;
    }

    public String getOcupationArea() {
        return ocupationArea;
    }

    public String getThecnologyUsed() {
        return thecnologyUsed;
    }

    public String getLevelKnowledge() {
        return levelKnowledge;
    }
}
