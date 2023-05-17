package footballscoreboard.service;

import footballscoreboard.entity.Team;
import footballscoreboard.enums.MatchTeam;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class scoreboardTest {
    scoreboard sb;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        List<List<Team>> list=new ArrayList<>();
        List<Team> firstMatch=new ArrayList<>();
        firstMatch.add(new Team(MatchTeam.Mexico,0));
        firstMatch.add(new Team(MatchTeam.CANADA,5));
        List<Team> secondMatch=new ArrayList<>();
        secondMatch.add(new Team(MatchTeam.SPAIN,10));
        secondMatch.add(new Team(MatchTeam.BRAZIL,2));
        List<Team> thirdMatch=new ArrayList<>();
        thirdMatch.add(new Team(MatchTeam.GERMANY,2));
        thirdMatch.add(new Team(MatchTeam.FRANCE,2));
        List<Team> fourthMatch=new ArrayList<>();
        fourthMatch.add(new Team(MatchTeam.URUGUAY,6));
        fourthMatch.add(new Team(MatchTeam.ITALY,6));
        List<Team> fivethMatch=new ArrayList<>();
        fivethMatch.add(new Team(MatchTeam.ARGENTINA,3));
        fivethMatch.add(new Team(MatchTeam.AUSTRALIA,1));
        list.add(firstMatch);
        list.add(secondMatch);
        list.add(thirdMatch);
        list.add(fourthMatch);
        list.add(fivethMatch);
        sb=new scoreboard(list);
    }

    @org.junit.jupiter.api.Test
    void matchStarted() {
        sb.matchStarted(new Team(MatchTeam.ARGENTINA,3),new Team(MatchTeam.AUSTRALIA,1));
    }

    @org.junit.jupiter.api.Test
    void matchFinished() {

    }

    @org.junit.jupiter.api.Test
    void scoreUpdated() {
        Team homeTeam=new Team(MatchTeam.ARGENTINA,11);
        Team awayTeam=new Team(MatchTeam.AUSTRALIA,3);
      Assert.assertEquals(true,sb.scoreUpdated(homeTeam,awayTeam));
    }

    @org.junit.jupiter.api.Test
    void getAllMatchesSummaryByTotalOrder() {
        sb.getAllMatchesSummaryByTotalOrder();

    }
}