package interfaces;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import domainmodel.Team;

public interface ITeamDAO {

	public Team getTeam(int id);
	public Team getTeam(String name);
	public boolean newTeam(Team team);
	public List<Team> getTeam();
	public void setContext(AnnotationConfigApplicationContext context);
}
