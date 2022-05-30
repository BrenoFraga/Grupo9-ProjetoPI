package findr.projectfindr.response;

public class MatchResponse {
    private long idContactor;
    private long fkContactor;
    private long idFreelancer;
    private long fkFreelancer;

    public MatchResponse(long idContactor, long fkContactor, long idFreelancer, long fkFreelancer) {
        this.idContactor = idContactor;
        this.fkContactor = fkContactor;
        this.idFreelancer = idFreelancer;
        this.fkFreelancer = fkFreelancer;
    }

    public long getIdContactor() {
        return idContactor;
    }

    public long getFkContactor() {
        return fkContactor;
    }

    public long getIdFreelancer() {
        return idFreelancer;
    }

    public long getFkFreelancer() {
        return fkFreelancer;
    }
}
