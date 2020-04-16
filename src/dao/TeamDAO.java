package dao;

import org.springframework.stereotype.Component;

import interfaces.IDatabase;
import interfaces.ITeam;

@Component
public class TeamDAO implements ITeam{

	//private IDatabase db;
	
	@Override
	public ITeam getTeam() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean newTeam(String name) {
		// TODO Auto-generated method stub
		return true;
	}

}
