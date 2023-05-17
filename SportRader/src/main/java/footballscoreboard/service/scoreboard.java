package footballscoreboard.service;

import footballscoreboard.entity.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ScoreBoard {

    private Team homeTeam,awayTeam;
    List<List<Team>> matchAdded;
    public scoreboard(List<List<Team>> listofList) {
      matchAdded=listofList;
    }
    /*
      This method invokes when a match started.
     */
    public void matchStarted(Team hTeam,Team aTeam)
    {
        this.homeTeam=hTeam;
        this.awayTeam=aTeam;
    }
    /*
     When the match finishes,it should be removed from the board list
     */
    public void matchFinished(Team curHomeTeam,Team curAwayTeam)
    {
        int counter=0;
        List<Team> removeEndedMatch=new ArrayList<>();
        for(List<Team> selected:matchAdded) {
            if(selected.get(0).getTeamName().equals(this.homeTeam.getTeamName()) && selected.get(1).getTeamName().equals(this.awayTeam.getTeamName()))
                removeEndedMatch=selected;
        }
        matchAdded.remove(removeEndedMatch);
    }
    /*
    Update score when a new score added to a team.
     */
    public Boolean scoreUpdated(Team updatedHomeTeamScore,Team updatedAwayTeamScore)
    {
      this.homeTeam=updatedHomeTeamScore;
      this.awayTeam=updatedAwayTeamScore;
      int counter=0;
      for(List<Team> selected:matchAdded)
      {
          if(selected.get(0).getTeamName().equals(this.homeTeam.getTeamName()) && selected.get(1).getTeamName().equals(this.awayTeam.getTeamName()))
          {
              matchAdded.set(counter,Arrays.asList(this.homeTeam,this.awayTeam));
              return true;
          }

          counter++;
      }
      return false;
    }
    /*
    Display up-to-date summary of the entire matches in the score board.
     */
    public void getAllMatchesSummaryByTotalOrder()
    {
       Collections.sort(matchAdded,(a1,a2)->a2.get(0).getScore()+a2.get(1).getScore()>a1.get(0).getScore()+a1.get(1).getScore()?1:-1);
       List<String> summarySorted=new ArrayList<>();
       for(List<Team> list:matchAdded)
       {
           StringBuilder sb=new StringBuilder();
           for(Team selected:list)
           {
            sb.append(selected.getTeamName()+" "+selected.getScore()+" - ");
           }
           System.out.println(sb.substring(0,sb.length()-2));
       }
    }
}
