package interfaces;

import domainmodel.Match;

public interface IMatchExecution {

	public void beginMatch(Match match);
	public void finishMatch(Match match);
}
