package interfaces;

import domainmodel.Team;

public interface ITeam {

	public ITeam getTeam();
	public String getName();
	public boolean newTeam(Team team);
}
