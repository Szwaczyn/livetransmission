package interfaces;

import java.util.List;

import domainmodel.Match;
import domainmodel.Team;

public interface IMatchDAO {

	public List<Match> getMatch();
	public Match getMatch(int id);
	public Match getMatch(Team team);
	public Match newMatch(Team homeTeam, Team awayTeam);
	public boolean finishMatch();
}
