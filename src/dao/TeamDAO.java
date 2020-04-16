package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import domainmodel.Team;
import interfaces.IDatabase;
import interfaces.ITeamDAO;

@Component
public class TeamDAO implements ITeamDAO{

	private EntityManager em;
	
	public TeamDAO(IDatabase idb) {
		this.em = idb.getEntityManager();
	}
	
	@Override
	public Team getTeam(int id) {
		
		Team resultTeam = (Team)this.em.createQuery("SELECT t FROM Team t WHERE t.id = :id")
				.setParameter("id", id)
				.getSingleResult();
	
		return resultTeam;
	}

	@Override
	public Team getTeam(String name) {
		
		Team resultTeam = (Team)this.em.createQuery("SELECT t FROM Team t WHERE t.name = :name")
				.setParameter("name", name)
				.getSingleResult();
		
		return resultTeam;
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
