package interfaces;

import domainmodel.Match;

public interface IMatchExecution {

	public void beginMatch();
	public Match getMatch();
	public void setMatch(Match match);
}
