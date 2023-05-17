package footballscoreboard.entity;

import footballscoreboard.enums.MatchTeam;

public class Team {
  private MatchTeam teamName;
  private  int score=-1;

    public Team(MatchTeam teamName,int initialScore) {
        this.teamName = teamName;
        this.score=initialScore;
    }

    public MatchTeam getTeamName() {
        return teamName;
    }

    public void setTeamName(MatchTeam teamName) {
        this.teamName = teamName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }



}
