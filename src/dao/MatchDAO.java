package dao;

import java.util.List;

import domainmodel.Match;
import domainmodel.Team;
import interfaces.IMatchDAO;

public class MatchDAO implements IMatchDAO{

	@Override
	public List<Match> getMatch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Match getMatch(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Match getMatch(Team team) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Match newMatch(Team homeTeam, Team awayTeam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean finishMatch() {
		// TODO Auto-generated method stub
		return false;
	}

}
