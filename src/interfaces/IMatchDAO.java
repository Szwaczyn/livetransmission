package interfaces;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import domainmodel.Match;
import domainmodel.Team;
import utils.Status;

public interface IMatchDAO {

	public List<Match> getMatch();
	public List<Match> getMatch(Status status);
	public List<Match> getMatch(Team team);
	public Match getMatch(int id);
	public Match newMatch(Team homeTeam, Team awayTeam);
	public boolean save(Match match);
	public void setContext(AnnotationConfigApplicationContext context);
	boolean finishMatch(Match match);
}
