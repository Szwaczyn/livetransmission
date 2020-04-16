package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import domainmodel.Team;
import interfaces.IDatabase;
import interfaces.ITeam;

@Component
public class TeamDAO implements ITeam{

	private EntityManager em;
	
	public TeamDAO(IDatabase idb) {
		this.em = idb.getEntityManager();
	}
	
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
	public boolean newTeam(Team team) {
		EntityTransaction et = this.em.getTransaction();
		try {
			et.begin();
			em.persist(team);
			et.commit();
			
			return true;
		}catch(Exception e) {
			et.rollback();
			return false;
		}
	}

}
