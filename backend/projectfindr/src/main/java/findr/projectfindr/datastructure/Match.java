package findr.projectfindr.datastructure;

public class Match {
    private long fkFreelancer;
    private long fkContactor;

    public Match(long fkFreelancer, long fkContactor) {
        this.fkFreelancer = fkFreelancer;
        this.fkContactor = fkContactor;
    }

    public long getFkFreelancer() {
        return fkFreelancer;
    }

    public long getFkContactor() {
        return fkContactor;
    }
}
