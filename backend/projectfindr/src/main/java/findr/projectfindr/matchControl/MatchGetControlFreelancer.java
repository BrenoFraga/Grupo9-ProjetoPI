package findr.projectfindr.matchControl;

import findr.projectfindr.model.LikeFreelancer;
import findr.projectfindr.model.LikeProject;
import findr.projectfindr.model.Match;
import findr.projectfindr.model.pkMatch;

import java.util.Date;
import java.util.List;

public class MatchGetControlFreelancer {
    private List<LikeProject> likep;
    private LikeFreelancer likef;

    public MatchGetControlFreelancer(List<LikeProject> likep, LikeFreelancer likef) {
        this.likep = likep;
        this.likef = likef;
    }

    public Match getMatch(){
        Match m = null;
        for(int i = 0;i < likep.size();i ++){
            if(likep.get(i).getIdLikeProject().getFkFreelancer() == likef.getIdLikeFreelancer().getFkFreelancer()
                    && likep.get(i).getIdLikeProject().getFkContactor() == likef.getIdLikeFreelancer().getFkContactor()

            ){
                if( !likep.get(i).getEvaluation() || !likef.getEvaluation()){
                    m = null;
                }else {
                    Date dataLike = new Date();
                    pkMatch p = new pkMatch(likep.get(i).getIdLikeProject().getFkFreelancer(), likep.get(i).getIdLikeProject().getFkContactor());
                    m = new Match(p, dataLike);
                }
            }
        }

        return m;
    }
}
