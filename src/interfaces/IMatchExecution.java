package interfaces;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import domainmodel.Match;

public interface IMatchExecution {

	public void beginMatch();
	public Match getMatch();
	public void setMatch(Match match);
	public void setContext(AnnotationConfigApplicationContext context);
}
