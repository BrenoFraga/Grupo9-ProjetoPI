package findr.projectfindr.matchControl;

import findr.projectfindr.model.LikeFreelancer;
import findr.projectfindr.model.LikeProject;
import findr.projectfindr.model.Match;
import findr.projectfindr.model.pkMatch;

import java.util.Date;
import java.util.List;

public class MatchGetControlProject {
    private List<LikeFreelancer> likef;
    private LikeProject likep;

    public MatchGetControlProject(List<LikeFreelancer> likef, LikeProject likep) {
        this.likef = likef;
        this.likep = likep;
    }

    public Match getMatch(){
        findr.projectfindr.model.Match m = null;
        for(int i = 0;i < likef.size();i ++){
            if(likef.get(i).getIdLikeFreelancer().getFkFreelancer() == likep.getIdLikeProject().getFkFreelancer()
            && likef.get(i).getIdLikeFreelancer().getFkContactor() == likep.getIdLikeProject().getFkContactor()
            && likef.get(i).getEvaluation() == true && likep.getEvaluation() == true
            ){
                Date dataLike = new Date();
                pkMatch p = new pkMatch(likef.get(i).getIdLikeFreelancer().getFkFreelancer(),likef.get(i).getIdLikeFreelancer().getFkContactor());
                m = new Match(p,dataLike);
            }
        }
        return m;
    }
}
