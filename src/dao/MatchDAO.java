package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transaction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import domainmodel.Match;
import domainmodel.Team;
import interfaces.IDatabase;
import interfaces.IMatchDAO;
import utils.Status;

@Component
public class MatchDAO implements IMatchDAO {

	private AnnotationConfigApplicationContext context;
	private EntityManager em;
	
	public MatchDAO(IDatabase db) {
		this.em = db.getEntityManager();
	}
	
	@Override
	public List<Match> getMatch() {
		List<Match> matches = this.em.createQuery("SELECT m FROM Match m")
				.getResultList();
		return matches;
	}

	@Override
	public Match getMatch(int id) {
		Match match = (Match)this.em.createQuery("SELECT m FROM Match m WHERE id = :id")
				.setParameter("id", id)
				.getSingleResult();
		return match;
	}

	@Override
	public List<Match> getMatch(Team team) {
		List<Match> matches = this.em.createQuery("SELECT m FROM Match m WHERE homeTeam = :team OR awayTeam = :team")
				.setParameter("team", team)
				.getResultList();
		return matches;
	}

	@Override
	public Match newMatch(Team homeTeam, Team awayTeam) {
		Match newMatch = new Match();
		newMatch.setAwayTeam(awayTeam);
		newMatch.setHomeTeam(homeTeam);
		
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();
			em.persist(newMatch);
			et.commit();
			return newMatch;
		}catch (Exception e) {
			et.rollback();
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean finishMatch() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Match> getMatch(Status status) {
		boolean started = false;
		boolean finished = false;

		if (status == Status.Finished) {
			started = true;
			finished = true;
		} else if (status == Status.notStarted) {
			started = false;
			finished = false;
		} else if (status == Status.Started) {
			started = true;
			finished = false;
		}
		
		List<Match> matches = this.em.createQuery("SELECT m FROM Match m WHERE m.started = :started AND m.finished = :finished")
				.setParameter("finished", finished)
				.setParameter("started", started)
				.getResultList();
		return matches;
	}

	@Override
	public void setContext(AnnotationConfigApplicationContext context) {
		this.context = context;
	}

}
