package interfaces;

import domainmodel.Team;

public interface ITeamDAO {

	public Team getTeam(int id);
	public Team getTeam(String name);
	public boolean newTeam(Team team);
}
